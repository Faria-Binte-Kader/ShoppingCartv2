<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/5/2022
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<h3>Enter your name and password to Sign Up to shop!</h3>
<form method="post" action="signup">
    <h3>Name</h3>
    <input type="text" name="signupUsername">
    <br>
    <h3>Password</h3>
    <input type="password" name="signupPassword">
    <br>
    <input type="submit" value="Sign Up">
</form>
<br/>
<a href="login.jsp">Login</a>
</body>
</html>
