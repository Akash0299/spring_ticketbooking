<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"">
<link rel="stylesheet" href="/css/bookmovie.css">
<title>AVAILABLE</title>
</head>
<body>
<form>
<table>
<tr>
<td>SHOW TIME</td>
<c:forEach items="${availshows}" var="show">
<td>
<a href="getticket/${movname}/${sdate}/${show.getStime()}/${show.getTicketcount()}" target="_new">${show.getStime()}</a>
</td>
</c:forEach>
</table>
<br><br>
</form>
<br><br>
</body>
</html>