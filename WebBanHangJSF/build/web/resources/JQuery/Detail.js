var mousewheelfunction = null;
var scrollfunction = null;
var resizefunction = null;

(function ($) {
   
    jQuery.scrollSpeed = function (step, speed, easing) {

        var $document = $(document),
            $window = $(window),
            $body = $('html, body'),
            option = easing || 'default',
            root = pageYOffset,
            scroll = false,
            scrollY,
            scrollX,
            view;

        if (window.navigator.msPointerEnabled)

            return false;
        
        mousewheelfunction = function (e) {
            var deltaY = e.originalEvent.wheelDeltaY,
                detail = e.originalEvent.detail;
            scrollY = $document.height() > $window.height();
            scrollX = $document.width() > $window.width();
            scroll = true;

            if (scrollY) {

                view = $window.height();

                if (deltaY < 0 || detail > 0)

                    root = (root + view) >= $document.height() ? root : root += step;

                if (deltaY > 0 || detail < 0)

                    root = root <= 0 ? 0 : root -= step;

                $body.stop().animate({

                    scrollTop: root

                }, speed, option, function () {

                    scroll = false;

                });
            }

            if (scrollX) {

                view = $window.width();

                if (deltaY < 0 || detail > 0)

                    root = (root + view) >= $document.width() ? root : root += step;

                if (deltaY > 0 || detail < 0)

                    root = root <= 0 ? 0 : root -= step;

                $body.stop().animate({

                    scrollLeft: root

                }, speed, option, function () {

                    scroll = false;

                });
            }
            return false;


        };
        scrollfunction = function () {
            if (scrollY && !scroll) root = $window.scrollTop();
            if (scrollX && !scroll) root = $window.scrollLeft();
        }
        resizefunction = function () {
            if (scrollY && !scroll) view = $window.height();
            if (scrollX && !scroll) view = $window.width();
        }

        $(window).on('scroll', scrollfunction);
        $(window).on('resize',resizefunction);
        $(window).on('mousewheel DOMMouseScroll', mousewheelfunction);
    };

    jQuery.easing.default = function (x, t, b, c, d) {

        return -c * ((t = t / d - 1) * t * t * t - 1) + b;
    };


})(jQuery);


function openNav(ImageName) {
    document.getElementById("myNav").style.height = "100%";
    $('html,body').css('overflow', 'hidden'); // Tắt scroll
    $('#AnhDetail').attr("src", ImageName);
    $('#close').css('position', 'fixed');
    
   

    //Tắt scroll mượt
    $(window).off('scroll');
    $(window).off('resize');
    $(window).off('mousewheel DOMMouseScroll');

}

function closeNav() {
    document.getElementById("myNav").style.height = "0%";
    $('html,body').css('overflow', 'auto');
    $('#close').css('position', 'absolute');

    

    //Bật scroll mượt
    $(window).on('scroll', scrollfunction);
    $(window).on('resize', resizefunction);
    $(window).on('mousewheel DOMMouseScroll', mousewheelfunction);
}



//Ảnh Detail Animation
function ChangeAnhDetail(ImageName) {
    $('#AnhDetail').attr("src", ImageName);
}

