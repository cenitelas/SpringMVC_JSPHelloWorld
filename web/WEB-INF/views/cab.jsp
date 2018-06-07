<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница пользователя</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css">
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
    %>
        <ul class="w3-ul">
            <li class="w3-hover-sand">Ваш id - ${user.userId}</li>
        <li class="w3-hover-sand">Ваше имя - ${user.name}</li>
            <li class="w3-hover-sand">Ваш возраст - ${user.year}</li>
            <li class="w3-hover-sand">Дата регистрации - ${user.date}</li></ul>
    </div>

</div>
<button class="w3-btn w3-hover-light-blue w3-round-large" id="myBtn">Сменить пароль</button>
<div id="myModal" class="modal">
    <jsp:include page="repass.jsp">
    <jsp:param name="user" value="${user}"/>
    </jsp:include>
    <span class="close">&times;</span>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='..'">В главное меню</button>
</div>
<script>
    var name=${user.name};
    var id='${user.userId}';
</script>
<script src="<c:url value="/js/cab.js" />"></script>
</body>
</html>

