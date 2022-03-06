<%@ page import="com.example.shoppingcartv2.ItemBean" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/5/2022
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<h1>Home</h1>
<br/>
<%
    int chairq=0, tableq=0, bedq=0, matq=0;
    int chairp=0, tablep=0, bedp=0, matp=0;
    String chairurl="", tableurl="", bedurl="", maturl="";
    List<ItemBean> myItems = (List<ItemBean>) session.getAttribute("ShopItems");
    for( ItemBean items : myItems) {
        if(items.getName().equals("Chair"))
        {   chairq = items.getQuantity();
            chairp = items.getPrice();
            chairurl = items.getImageurl();}

        if(items.getName().equals("Table"))
        {
            tableq = items.getQuantity();
            tablep = items.getPrice();
            tableurl = items.getImageurl();}
        if(items.getName().equals("Bed"))
        {
            bedq = items.getQuantity();
            bedp = items.getPrice();
            bedurl = items.getImageurl();}
        if(items.getName().equals("Mattress"))
        {
            matq = items.getQuantity();
            matp = items.getPrice();
            maturl = items.getImageurl();}

    }

%>
<h3>Available Items:</h3>
<form method="post" action="gotocart">
    <input type="checkbox" name="item" value="Chair"/>Chair
    <br>
    Available item:<%=chairq%> , Price: <%=chairp%>
    <br>
    <img src=<%=chairurl%> alt="Chair">
    <br>
    <input type="checkbox" name="item" value="Table"/>Table
    <br>
    Available item: <%=tableq%> , Price: <%=tablep%>
    <br>
    <img src=<%=tableurl%> alt="Table">
    <br>
    <input type="checkbox" name="item" value="Bed"/>Bed
    <br>
    Available item: <%=bedq%> , Price: <%=bedp%>
    <br>
    <img src= <%=bedurl%> alt="Bed">
    <br>
    <input type="checkbox" name="item" value="Mattress"/>Mattress
    <br>
    Available item: <%=matq%> , Price: <%=matp%>
    <br>
    <img src= <%=maturl%> alt="Mat">
    <br>
    <input type="submit" value="Add to Cart">
</form>
<form method="post" action="mycart"><input type="submit" value="My Cart"></form>
<br/>
<a href="logout.jsp">Log Out</a>
</body>
</html>
