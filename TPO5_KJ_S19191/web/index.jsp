<%--
  Created by IntelliJ IDEA.
  User: kfaffu
  Date: 03.06.2020
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--  <title>Moja baza danych książek</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--  <h1>Moja baza danych książek</h1>--%>
<%--  <div class="topnav">--%>
<%--    <a class="active" href="index.jsp">Home</a>--%>
<%--    <a href="http://localhost:8081/TPO5_KJ_S19191/allBooks">Wszystkie książki</a>--%>
<%--    <a href="http://localhost:8081/TPO5_KJ_S19191/search">Wyszukiwarka</a>--%>
<%--    <a href="#about">About</a>--%>
<%--  </div>--%>
<%--  <p align="left">Witam, to moja aplikacja, głównie bazuje na wykładach, bo:</p>--%>
<%--  <p align="left">Baza danych jest z wykładów</p>--%>
<%--  <p align="left">Sposób użycia mvc również jest taki jak zaprezentował Pan Barteczko</p>--%>
<%--</body>--%>
<%--</html>--%>

<html>
<head>
  <meta http-equiv="content-type" content="text/html" />
  <link rel="stylesheet" href="style.css" type="text/css" media="screen,projection" />
</head>
<body>
<div id="container">
  <div id="wrapper">
    <div id="header">
      <h1><a>Moja baza danych książek</a></h1>
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