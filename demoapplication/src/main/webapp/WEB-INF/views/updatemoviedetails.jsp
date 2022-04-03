<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Movie</title>
<link rel="stylesheet" href="/css/details.css">
</head>
<body>
<center>
<h2>MOVIES SITE</h2>
<h3>EDIT MOVIE - #${movie.getMid()} : ${movie.getMname()}</h3>
</center>
<form action="update-movie" method="post">
    <p>
        <input type="hidden" name="mid" value="${movie.getMid()}"/>
    </p>
    <p>
        <label>MOVIE NAME</label>&emsp;
        <input type="text" name="mname" value="${movie.getMname()}"/>
    </p>
    <p>
        <label>PRODUCTION</label>&emsp;
        <input type="text" name="production" value="${movie.getProduction()}"/>
    </p>
    <p>
        <label>HERO</label>&emsp;
        <input type="text" name="hero" value="${movie.getHero()}"/>
    </p>
    <p>
        <label>HEROINE</label>&emsp;
        <input type="text" name="heroine" value="${movie.getHeroine()}"/>
    </p>
    <p>
        <label>MOVIE TYPE</label>&emsp;
        <select name="mtype" id="mtype">
            <option value="Action">Action</option>
            <option value="Thriller">Thriller</option>
            <option value="Comedy">Comedy</option>
            <option value="Drama">Drama</option>
        </select>
    </p>
    <p>
        <label>LANGUAGE</label>&emsp;
        <input type="text" name="lang" value="${movie.getLang()}"/>
    </p>
    <p>
        <label>RELEASE DATE(YYYY-MM-DD)</label>&emsp;
        <input type="date" name="releaseDate" format="yyyy-MM-dd" value="${movie.getReleasedate()}"/>
    </p>
    <br><br>
    <input type="submit" value="EDIT" id="edit" name="edit"/>
</form>
<br><br>
</body>
</html>