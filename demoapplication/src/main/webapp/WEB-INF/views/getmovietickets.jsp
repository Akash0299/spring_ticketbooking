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
<form action="bookmovieshow">
<table>
<tr>
<td>NUMBER OF TICKETS</td>
<td><input type="range" id="tc" name="tickets" min="1" max="${tcount}"/></td>
<td><span id="demo"></td>
<tr>
<td>CIRCLE TYPE</td>
<td><input type="radio" name="ctype" value="Economy"/>ECONOMY</td>
<td><input type="radio" name="ctype" value="Platinum"/>PLATINUM</td>
</table>
<br><br>
<input type="submit" value="BOOK" id="add"/>
<br><br>
</form>
<script>
var slider = document.getElementById("tc");
var output = document.getElementById("demo");
output.innerHTML = slider.value;

slider.oninput = function() {
  output.innerHTML = this.value;
}
</script>
</body>
</html>