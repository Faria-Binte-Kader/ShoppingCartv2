package com.example.shoppingcartv2;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        String signupUname = session.getAttribute("signupUsername").toString();
        String signupPword = session.getAttribute("signupPassword").toString();
        List<ItemBean> itemBeanShop = new ArrayList<ItemBean>();
        DBConnection dbConnection = new DBConnection();
        dbConnection.getData(itemBeanShop);
        getServletContext().setAttribute("ShopItems", itemBeanShop);
        session.setAttribute("ShopItems", itemBeanShop);

        if (username.equals(signupUname) && password.equals(signupPword))
        {
            session.setAttribute("currentUser", username);
            session.setMaxInactiveInterval(30*60);

            RequestDispatcher rd = request.getRequestDispatcher(
                    "home");
            rd.include(request, response);
        }
        else
        {
            PrintWriter out = response.getWriter();
            out.println("<h1> Wrong credentials </h1>");

            RequestDispatcher rd = request.getRequestDispatcher(
                    "login.jsp");
            rd.include(request, response);
        }
    }
}
