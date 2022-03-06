package com.example.shoppingcartv2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("signupUsername", request.getParameter("signupUsername"));
        session.setAttribute("signupPassword",request.getParameter("signupPassword"));

        List<ItemBean> itemBeanShop = new ArrayList<ItemBean>();
        DBConnection dbConnection = new DBConnection();
        dbConnection.getData(itemBeanShop);
        dbConnection.signUp( request.getParameter("signupUsername"),request.getParameter("signupPassword"));

        getServletContext().setAttribute("ShopItems", itemBeanShop);
        session.setAttribute("ShopItems", itemBeanShop);

        PrintWriter out = response.getWriter();
        out.println("<h1> Successfully signed up. Log in to continue. </h1>");

        RequestDispatcher rd = request.getRequestDispatcher(
                "login.jsp");
        rd.include(request, response);

    }
}

