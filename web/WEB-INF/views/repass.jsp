<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Страница пользователя</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
<body class="w3-light-grey" >
<div class="modal-content" >
<form action="pass" method="post" class="w3-selection w3-light-grey w3-padding">
    <label>Старый пароль:
        <input type="password" name="password" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
    </label>
    <label>Новый пароль:
        <input type="password" name="passr" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
        Повторите новый пароль:
        <input type="password" name="passr2" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
    </label>
    <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Сменить пароль</button>
</form>
</div>
</body>
</html>

