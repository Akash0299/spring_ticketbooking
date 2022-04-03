<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/index.css">
<title>LANGUAGES</title>
<style>
input[type="button"]{
border-radius:2px;
}
</style>
</head>
<body>
<nav>
<c:forEach var="l" items="${languages}">
<a href="lres?lang=<c:out value="${l}"/>" target="iframe2"><input type="button" value="<c:out value="${l}"/>"/></a><br>
</c:forEach>
</nav>
<iframe name="iframe2" id="i2" width="1000" height="500"></iframe>
</body>
</html>