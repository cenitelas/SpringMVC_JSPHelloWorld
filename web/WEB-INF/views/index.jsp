<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>База аккаунтов</title>
</head>
<body class="w3-light-grey">
<!-- header -->
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>База аккаунтов</h1>
</div>

<div class="w3-container w3-center">       <!-- content -->
    <div class="w3-bar w3-padding-large w3-padding-24">    <!-- buttons holder -->
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/list'">Список пользователей</button>
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/add'">Регистрация</button>
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/logon'">Вход</button>
    </div>
</div>
</body>
</html>