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
<table>
<tr>
<td>SHOW DATE</td>
<td>
<c:forEach items="${dates}" var="date">
<a href="getmovietime/${movname}/${date}">${date}</a><br>
</c:forEach> 
</td>
</tr>
</table>
<br><br>
<br><br>
</body>
</html>