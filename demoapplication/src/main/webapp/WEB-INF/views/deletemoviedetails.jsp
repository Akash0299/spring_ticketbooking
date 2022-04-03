<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DELETE MOVIE DETAILS</title>
<link rel="stylesheet" href="/css/details.css">
</head>
<body>
<center>
<h2>MOVIES SITE</h2>
<h3>DELETE MOVIE - #${dmovie.getMid()} : ${dmovie.getMname()}</h3>
</center>
<a href="deletemovie">Back</a>
<ul>
<li>Movie Id:${dmovie.getMid()}</li>
<li>Movie Name:${dmovie.getMname()}</li>
<li>Production:${dmovie.getProduction()}</li>
<li>Hero:${dmovie.getHero()}</li>
<li>Heroine:${dmovie.getHeroine()}</li>
<li>Movie Type:${dmovie.getMtype()}</li>
<li>Language:${dmovie.getLang()}</li>
<li>Release Date:${dmovie.getReleasedate()}</li>
</ul>
<form action="delete-movie">
<input type="hidden" name="mid" value="${dmovie.getMid()}"/>
<input type="submit" id="delete" value="Delete"/>
</form>
<br><br>
</body>
</html>