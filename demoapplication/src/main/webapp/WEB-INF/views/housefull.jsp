<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"">
<link rel="stylesheet" href="/css/bookmovie.css">
<title>HOUSEFULL</title>
</head>
<body>
<table>
<c:forEach items="${hfshows.entrySet()}" var="showdate">
<tr>
<td><c:out value="${showdate.getKey()}"/></td>
<c:forEach items="${showdate.getValue()}" var="showtimes">
<td><c:out value="${showtimes}"/></td>
</c:forEach>
</tr>
</c:forEach>
</table>
</body>
</html>