<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login User</title>
<link href="/css/details.css" rel="stylesheet">
</head>
<body>
<center>
<h2>MOVIES SITE</h2>
<h3>LOGIN MEMBER</h3>
</center>
<form action = "userDetail">
    <p>
        <label name="Username">USERNAME</label>
        <input type="text" name="uname"/>
    </p>
    <p>
        <label name="Password">PASSWORD</label>
        <input type="password" name="pswd"/>
    </p>
    <br><br>
    <input type="submit" value="Login" id="add" name="add"/>
</form>
<br>
</body>
</html>