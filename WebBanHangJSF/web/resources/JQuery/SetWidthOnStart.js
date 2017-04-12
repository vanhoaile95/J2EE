
function AutoWidth()
{
      var w = window.innerWidth
            || document.documentElement.clientWidth
            || document.body.clientWidth;

          var h = window.innerHeight
            || document.documentElement.clientHeight
            || document.body.clientHeight;
    
          $('#Anh').attr("width", w - 18);
          $('#topbackground').css('width', w - 18);
          $('#header').css('width', w - 18);
          $('#footer').css('width', w - 18);
}
//Set động rộng với device
$(document).ready(function () {
   
 inverval = setInterval(AutoWidth, 1);
 
});