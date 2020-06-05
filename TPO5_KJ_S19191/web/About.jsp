<%--
  Created by IntelliJ IDEA.
  User: kfaffu
  Date: 05.06.2020
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>The Old Forest</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="style.css" type="text/css" media="screen,projection" />
</head>
<body>
<div id="container">
    <div id="wrapper">
        <div id="header">
            <h1><a href="#">Moja baza danych książek</a></h1>
        </div>
        <div id="content">
            <ul id="nav">
                <li><a href="index.jsp" accesskey="h"><em>H</em>ome</a></li>
                <li><a href="About.jsp" accesskey="a"><em>A</em>bout</a></li>
                <li><a href="http://localhost:8081/TPO5_KJ_S19191/allBooks" accesskey="e"><em>W</em>szystkie książki</a></li>
                <br>
                <br>
                <li><a href="http://localhost:8081/TPO5_KJ_S19191/search" accesskey="c"><em>W</em>yszukiwarka w formie zapytań SQL</a></li>
                <li><a href="http://localhost:8081/TPO5_KJ_S19191/searchTitle" accesskey="c"><em>W</em>yszukiwarka po tytule</a></li>
            </ul>
            <div id="content_main">
                <h2><a>Introduction</a></h2>
                <p>Program został wykonany przez Jana Kwasowskiego. Wyszukiwanie w formie zapytań SQL jest zrobione w architekturze MVC, reszta niestety nie. Baza danych używana przeze mnie jest to baza danych używana na wykłądach. Wykdląd strony z strony:</p>
                <br>
                <li><a href="https://www.free-css.com/free-css-templates/page18/the-old-forest">Link do strony</a></li>
            </div>
            <div id="footer">
                <p class="validate"><a href="http://validator.w3.org/check?uri=referer">XHTML</a> | <a href="http://jigsaw.w3.org/css-validator/">CSS</a><br />
                    <a href="#content">Top</a></p>
                <p>Template design by <a href="http://www.sixshootermedia.com">Six Shooter Media</a>.<br />
                    © All your copyright information here.</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>