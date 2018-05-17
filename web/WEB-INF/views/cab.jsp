<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница пользователя</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2 >Страница пользователя</h2>
            </div>
       <% if (request.getAttribute("repass")=="true") {
        out.print("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n"
        +
        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
        "   <h5>Пароль изменен!</h5>\n" +
        "</div>");
    }
Map<String,String> map = (HashMap<String,String>) request.getAttribute("user");%>
        <ul class="w3-ul">
            <li class="w3-hover-sand">Ваш id - <% out.print(map.get("id"));%></li>
        <li class="w3-hover-sand">Ваше имя - <% out.print(map.get("name"));%></li>
            <li class="w3-hover-sand">Ваш возраст - <% out.print(map.get("year"));%></li>
            <li class="w3-hover-sand">Дата регистрации - <% out.print(map.get("date"));%></li></ul>
    </div>

</div>
<button class="w3-btn w3-hover-light-blue w3-round-large" id="myBtn">Сменить пароль</button>
<div id="myModal" class="modal">

    <span class="close">&times;</span>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='..'">В главное меню</button>
</div>
<script>
    var name='<% out.print(map.get("name"));%>';
    var id='<% out.print(map.get("id"));%>';
</script>
<script src="<c:url value="/resources/js/cab.js" />"></script>
</body>
</html>

