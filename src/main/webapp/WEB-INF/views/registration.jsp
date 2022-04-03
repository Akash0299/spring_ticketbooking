<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER REGISTRATION</title>
<link href="/css/details.css" rel="stylesheet">
</head>
<body>
<center>
<h2>MOVIES SITE</h2>
<h3>MEMBER REGISTRATION</h3>
</center>
<form action="insert-user" method="post">
   <p>
        <label name="Username">USERNAME</label>
        <input type="text" name="uname"/>
    </p>
    <p>
        <label name="Password">PASSWORD</label>
        <input type="password" name="pswd"/>
    </p>
    <p>
        <label name="Email">EMAIL</label>
        <input type="email" name="email"/>
    </p>
    <p>
        <label name="Phone">PHONE</label>
        <input type="number" name="phone" size="10"/>
    </p>
    <br><br>
    <input type="submit" value="Register" id="add" name="add"/>
</form>
<br>
</body>
</html>