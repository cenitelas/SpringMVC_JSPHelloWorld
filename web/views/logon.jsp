<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05.05.2018
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница пользователя</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
<body class="w3-light-grey">

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2 >Страница пользователя</h2>
        </div>
        <%
            if (request.getAttribute("userName") != null) {
                out.println("<ul class=\"w3-ul\">");
                out.println("<li class=\"w3-hover-sand\">" + request.getAttribute("userName") + "</li>");
                out.println("</ui>");
            }
        %>
    </div>
</div>
<div class="w3-card-4">
    <div class="w3-container w3-center w3-green">
        <h2>Вход</h2>
    </div>

    <form action="logon" method="post" class="w3-selection w3-light-grey w3-padding">
        <label>Имя:
            <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
        </label>
        <label>Пароль:
            <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
        </label>
        <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Вход</button>
    </form>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">В главное меню</button>
</div>
</body>
</html>

