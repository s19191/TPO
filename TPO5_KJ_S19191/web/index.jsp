<%--
  Created by IntelliJ IDEA.
  User: kfaffu
  Date: 03.06.2020
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
  <title>The Book App</title>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2" />
  <link rel="stylesheet" type="text/css" media="screen" href="style.css" />
</head>
<body>
<div id="container">
  <div id="header">
    <h1>THE BOOK APP</h1>
  </div>
  <div id="sideheader"></div>
  <div id="left_column">
    <div class="left_column_boxes">
      <h4>Menu</h4>
      <div id="navcontainer">
        <ul id="navlist">
          <li id="active"><a href="index.jsp" id="current">Home</a></li>
          <li><a href="http://localhost:8081/TPO5_KJ_S19191/search">Search</a></li>
          <li><a href="http://localhost:8081/TPO5_KJ_S19191/allBooks">All Books</a></li>
        </ul>
      </div>
    </div>
    <p class="center">Created by <b>Kacper Dobosz</b></p>
  </div>
  <div id="content">

    <h3>Basic Info</h3>
    <p> This is my book search web application. It contains all my favourite books that I've read so far. To navigate easily through this application you need to click in the menu on "Guide" section. All technologies that I used while building this application are listed here: <br/>
      <b>- Java 8, Java EE, Servlets(backend)</b><br/>
      <b>- HTML, CSS (frontend)</b><br/>
      <b>- Apache Tomcat(server)</b>
    <p/>
    <div id="empty"></div>
  </div>
  <div id="footer"></div>
</div>
</body>
</html>