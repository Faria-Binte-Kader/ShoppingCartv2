package com.example.shoppingcartv2;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GoToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] itemname = request.getParameterValues("item");
        if (itemname == null) {
            PrintWriter out = response.getWriter();
            out.println("<h1> Please select items to add. </h1>");

            RequestDispatcher rd = request.getRequestDispatcher(
                    "homepage.jsp");
            rd.include(request, response);
        } else {
            List<ItemBean> itemBeanList = new ArrayList<ItemBean>();
            List<ItemBean> itemBeanShop = new ArrayList<ItemBean>();
            itemBeanShop = (List<ItemBean>) getServletContext().getAttribute("ShopItems");
            PrintWriter out = response.getWriter();

            for (String s : itemname) {
                for(ItemBean i: itemBeanShop) {
                    if (i.getName().equals(s)) {
                        String name = i.getName();
                        int quantity = 1;
                        int price = i.getPrice();
                        ItemBean itemBean = new ItemBean(name, quantity, price);
                        itemBeanList.add(itemBean);
                    }
                }
            }

            HttpSession session = request.getSession();

            if (session.getAttribute("currentUser") == null) {
                response.sendRedirect("login.jsp");
            } else {
                List<ItemBean> myItems = (List<ItemBean>) session.getAttribute("CartItems");
                if (myItems == null) {
                    myItems = new ArrayList<ItemBean>();
                }
                for (ItemBean items : itemBeanList) {
                    myItems.add(items);
                }
                session.setAttribute("CartItems", myItems);
            }

            RequestDispatcher rd = request.getRequestDispatcher("mycart");
            rd.include(request, response);

        }
    }
}
