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
<body class="w3-light-grey" >
<div class="modal-content" >
<form action="repasslc" method="post" class="w3-selection w3-light-grey w3-padding">
    <label>Смена пароля:
        <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
        <input type="hidden" name="id" value="${id}">
    </label>
    <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Сменить пароль</button>
</form>
</div>
</body>
</html>

