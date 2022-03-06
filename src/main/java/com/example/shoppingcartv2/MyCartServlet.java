package com.example.shoppingcartv2;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MyCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = null;
        int i = 0;
        HttpSession session = request.getSession();

        if (session.getAttribute("currentUser")==null)
        {
            response.sendRedirect("login.jsp");
        }
        else
        {
            user = session.getAttribute("currentUser").toString();
        }
        PrintWriter out = response.getWriter();
        out.println("<h1>" + user + "\'s cart</h1>");
        RequestDispatcher rd = request.getRequestDispatcher("addtocart.jsp");
        rd.include(request, response);

    }
}
