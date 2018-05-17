var modal = document.getElementById('myModal');
var btn = document.getElementById("myBtn");
var span = document.getElementsByClassName("close")[0];

btn.onclick = function() {
   modal.style.display = "block";
   $.ajax({
        type: "POST",
        url: "/repass",
        data: {'name':name, 'id':id},
        success: function (result) {
            $("#myModal").html(result);
        }
    });
}

span.onclick = function() {
    modal.style.display = "none";
}

window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}