<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOK TICKET</title>
<link rel="stylesheet" href="/css/bookmovie.css">
</head>
<body>
<center>
<h2>MOVIES SITE</h2>
<h3>BOOK TICKET</h3>
<h3>MOVIE : ${movname}</h3>
</center>
<a href="bookticket">Back</a>
<nav>
<a href="showhousefull/${movname}/${tdate}" target="showiframe"><input type="button" value="HOUSEFULL SHOWS"/></a>&emsp;
<a href="showavailable/${movname}/${tdate}" target="showiframe"><input type="button" value="AVAILABLE SHOWS"/></a>
</nav>
<br><br>
<iframe name="showiframe" id="sif" src="showavailable/${movname}/${tdate}"></iframe>
</body>
</html>