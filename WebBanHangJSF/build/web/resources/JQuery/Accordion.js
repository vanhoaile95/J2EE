var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
    acc[i].onclick = function () {
        this.classList.toggle("kichhoat");
        this.nextElementSibling.classList.toggle("show");
    }
}

//Tự click section Đồ nữ
$(document).ready(function () {
    for (i = 0; i < acc.length; i++) {
        acc[i].onclick();
    }

});


$('#Anhhover').mouseenter(function () {
    $('#Anhhover').animate({
        opacity: '0.8'
    });
});
$('#Anhhover').mouseleave(function () {
    $('#Anhhover').animate({
        opacity: '1'
    });
});