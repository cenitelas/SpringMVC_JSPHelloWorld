<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница пользователя</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <style>
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0,0.4);
        }

        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
    </style>


</head>
<body class="w3-light-grey">
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2 >Страница пользователя</h2>
            </div>
<% Map<String,String> map = (HashMap<String,String>) request.getAttribute("user");%>
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
    var modal = document.getElementById('myModal');
    var btn = document.getElementById("myBtn");
    var span = document.getElementsByClassName("close")[0];
    btn.onclick = function() {
        modal.style.display = "block";
        $.post(
            "/repass",
            function( result ) {
                debugger;
                $("#myModal").html(result);
            }
        );
    }

    span.onclick = function() {
        modal.style.display = "none";
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>
</body>
</html>

