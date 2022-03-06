<%@ page import="com.example.shoppingcartv2.ItemBean" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/5/2022
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Cart</title>
</head>
<body>
<%
    List<ItemBean> myItems = (List<ItemBean>) session.getAttribute("CartItems");
    int price = 0;
    if(myItems!=null)
    {
        for( ItemBean items : myItems)
    {
        out.println("<h3>Item name: " + items.getName()+"</h3>");
        out.println("<h3>Quantity : " + items.getQuantity()+"</h3>");
        out.println("<h3>Price: " + items.getPrice()*items.getQuantity()+"</h3>");
        price = price +  items.getPrice()*items.getQuantity();
        out.println("<form method=\"post\" action=\"quantity\"><input type=\"hidden\" name=\"itemName\" value=\""+ items.getName()+"\">");
        out.println("<input type=\"hidden\" name=\"itemQuantity\" value=\""+ items.getQuantity()+"\">");
        out.println("<input type=\"submit\" name=\"add\" value=\"+\"><input name=\"subtract\" type=\"submit\" value=\"-\"></form>");
        out.println("<form method=\"post\" action=\"delete\"><input type=\"hidden\" name=\"itemName\" value=\""+ items.getName()+"\">");
        out.println("<input type=\"submit\" value=\"Delete\"></form>");
        out.println("<br>");
    }

    out.println("<form method=\"post\" action=\"checkout\"><input type=\"submit\" value=\"Check Out\"></form>");
    out.println("<h3>Total Bill: "+ price+ "</h3>");
    }
%>
<a href="homepage.jsp">Home</a>
<br/>
<a href="logout.jsp">Log Out</a>
<br/>
</body>
</html>
