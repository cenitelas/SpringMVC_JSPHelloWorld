<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%session.setAttribute("userName",request.getAttribute("userName"));
      session.setAttribute("id", request.getAttribute("id"));%>
<html>
<head>
    <title>Страница пользователя</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <style>
        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 80%; /* Could be more or less, depending on screen size */
        }

        /* The Close Button */
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
        <ul class="w3-ul">
        <li class="w3-hover-sand">Ваше имя - ${userName}</li>
            <li class="w3-hover-sand">Ваш возраст - ${year}</li>
            <li class="w3-hover-sand">Дата регистрации - ${date}</li></ul>
    </div>

</div>
<button class="w3-btn w3-hover-light-blue w3-round-large" id="myBtn">Сменить пароль</button>
<!-- The Modal -->
<div id="myModal" class="modal">

    <!-- Modal content -->

    <span class="close">&times;</span>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">В главное меню</button>
</div>
<script>
    // Get the modal
    var modal = document.getElementById('myModal');

    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks on the button, open the modal
    btn.onclick = function() {
        modal.style.display = "block";
        $.ajax({
            type: "POST",
            url: 'views/repass.jsp',
            success: function (result) {
                debugger;
                $("#myModal").html(result);
            },
            error: function (e) {
                alert('Errore');
            }
        });
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>
</body>
</html>

