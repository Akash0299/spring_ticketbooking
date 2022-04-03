<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERT MOVIE</title>
<link rel="stylesheet" href="/css/details.css">
</head>
<body>
<center>
<h2>MOVIES SITE</h2>
<h3>ADD A MOVIE</h3>
</center>
<form action = "insert-movie"  method = "post">
    <p>
        <label>MOVIE NAME</label>&emsp;
        <input type="text" name="mname"/>
    </p>
    <p>
        <label>PRODUCTION</label>&emsp;
        <input type="text" name="production"/>
    </p>
    <p>
        <label>HERO</label>&emsp;
        <input type="text" name="hero"/>
    </p>
    <p>
        <label>HEROINE</label>&emsp;
        <input type="text" name="heroine"/>
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
        <input type="text" name="lang"/>
    </p>
    <p>
        <label>RELEASE DATE(YYYY-MM-DD)</label>&emsp;
        <input type="date" name="releaseDate" format="yyyy-MM-dd"/>
    </p>
    <br><br>
    <input type="submit" value="ADD" id="add" name="add"/>
</form>
<br>
</body>
</html>