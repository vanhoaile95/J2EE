
     
     
       
//Hàm chuyển ảnh
function ChangeAnh() {
   
    if ($('#Anh').attr('src') == "./resources/Image/Image.png") {
        $('#Anh').attr('src', './resources/Image/Image2.png');
        //Thay đổi class màu cho thanh 'dot'
        $('#dot2').addClass('active').removeClass('dot');
        $('#dot1').addClass('dot').removeClass('active');

    }

    else if ($('#Anh').attr('src') == "./resources/Image/Image2.png") {
        $('#Anh').attr('src', './resources/Image/Image3.png');
        $('#dot3').addClass('active').removeClass('dot');
        $('#dot2').addClass('dot').removeClass('active');
    }

    else {
        $('#Anh').attr('src', './resources/Image/Image.png');
        $('#dot1').addClass('active').removeClass('dot');
        $('#dot3').addClass('dot').removeClass('active');
    }
}
//Hàm tự thay đổi ảnh
function ChuyenAnhAnimation() {
    $("#Anh").animate({ opacity: '0' }, "slow", function () {
        ChangeAnh();
        $("#Anh").animate({ opacity: '1' }, "slow");
    });

}
//Set tự thay đổi ảnh sau 3s
var inverval = null;
$(document).ready(function () {
    inverval = setInterval(ChuyenAnhAnimation, 5000);

});

//Click nút next or previous
function Click() {
    clearInterval(inverval);

    ChangeAnh();

    inverval = setInterval(ChuyenAnhAnimation, 5000);

};







    




