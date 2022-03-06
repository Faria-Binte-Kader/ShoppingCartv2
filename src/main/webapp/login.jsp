<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/5/2022
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h3>Enter your name and password to log in</h3>
<form method="post" action="login">
    <h3>Name</h3>
    <input type="text" name="username">
    <br>
    <h3>Password</h3>
    <input type="password" name="password">
    <br>
    <input type="submit" value="Log in">
</form>
<br>
<h4>No account? <a href="signup.jsp">Sign up here</a></h4>
</body>
</html>
