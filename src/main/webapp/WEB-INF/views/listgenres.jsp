<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/index.css">
<style>
input[type="button"]{
border-radius:2px;
}
</style>
<title>LANGUAGES</title>
</head>
<body>
<nav>
<c:forEach var="g" items="${genres}">
<a href="gres?genre=<c:out value="${g}"/>" target="iframe2"><input type="button" value="<c:out value="${g}"/>"/></a><br>
</c:forEach>
</nav>
<iframe name="iframe2" id="i2" width="1000" height="500"></iframe>
</body>
</html>