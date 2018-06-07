<%@ page import="app.entities.UserEntity" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        </div>
        <% if (request.getAttribute("message")=="true") {
            out.print("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n"
                    +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "   <h5>Пользователь " + request.getAttribute("name") + " успешно зарегистрирован!</h5>\n" +
                    "</div>");
        } else if(request.getAttribute("message")=="false") {
            out.print("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                    +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                    "   <h5>Пользователь " + request.getAttribute("name") + " сушествует!</h5>\n" +
                    "</div>");
        }%>
        <% UserEntity user = new UserEntity()%>
            <form:form method="POST"
                       action="add" modelAttribute="user">
                <!-- create an html table row -->
                <tr>
                    <!-- create cells of row -->
                    <td>${resultDisplay.date}</td>
                    <td>${resultDisplay.documentDisplays[0].idNumber}</td>
                    <td>${resultDisplay.siret}</td>
                    <td align="center">

                        <input type="submit"
                               class="btn btn-success" value="Rechercher" name="sync"
                               id="monSubmit" /></td>

                    <!-- close row -->
                </tr>
                <!-- close the loop -->
            </form:form>
        </>
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
