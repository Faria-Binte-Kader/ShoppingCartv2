package com.example.shoppingcartv2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("yesbtn") != null) {
            HttpSession session = request.getSession();
            if(session != null){
                session.setAttribute("currentUser", null);
            }
            response.sendRedirect("login.jsp");
        } else if (request.getParameter("nobtn") != null) {
            response.sendRedirect("homepage.jsp");
        }
    }
}
