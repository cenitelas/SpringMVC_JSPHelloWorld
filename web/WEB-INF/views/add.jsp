<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05.05.2018
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">

<div class="w3-container w3-padding">

    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Регистрация</h2>
            ${message}
        </div>

        <form action="add" method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Имя:
                <input type="text" name="name" required pattern="[0-9A-Za-zА-Яа-я]{4,12}" placeholder="Login" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Пароль:
                <input type="password" name="pass" required pattern="[0-9A-Za-zА-Яа-я]{4,12}" placeholder="Password" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Возраст:
                <input type="text" name="year" required placeholder="Years" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Регистрация</button>
        </form>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='..'">В главное меню</button>
</div>
</body>
</html>
