<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOK TICKET</title>
<link rel="stylesheet" href="/css/details.css">
</head>
<body>
<center>
<h2>MOVIES SITE</h2>
<h3>BOOK TICKET</h3>
</center>
<form action = "ticket-moviename"  method = "post">
    <p>
        <label>MOVIE NAME</label><br>
              <c:forEach items="${movlist}" var="m">
               <b><input type="radio" name="mname" value="<c:out value="${m}"/>"><c:out value="${m}"/></b><br>
              </c:forEach>
    </p>
    <br><br>
    <input type="submit" value="NEXT" id="add" name="add"/>
</form>
<br>
</body>
</html>