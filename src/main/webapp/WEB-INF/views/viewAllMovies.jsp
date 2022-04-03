<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LIST MOVIES</title>
<link rel="stylesheet" href="/css/Viewmovies.css">
</head>
<body>
<center>
<h2>MOVIES SITE</h2>
<h3>VIEW MOVIES</h3>
</center>
<a href="main">Home</a>
<br><br>&ensp;
<div style="overflow-x:auto;">
<table>
<tr>
<th>Movie ID</th>
<th>Movie Name</th>
<th>Production</th>
<th>Hero</th>
<th>Heroine</th>
<th>Language</th>
<th>Movie Type</th>
<th>Release Date</th>
</tr>
<c:forEach items = "${movies}" var = "movie">
<tr>
<td><c:out value="${movie.getMid()}"/></td>
<td><c:out value="${movie.getMname() }"/></td>
<td><c:out value="${movie.getProduction() }"/></td>
<td><c:out value="${movie.getHero() }"/></td>
<td><c:out value="${movie.getHeroine() }"/></td>
<td><c:out value="${movie.getMtype() }"/></td>
<td><c:out value="${movie.getLang() }"/></td>
<td><c:out value="${movie.getReleasedate() }"/></td>
</tr>
</c:forEach>
</table>
<br><br>
</body>
</html>