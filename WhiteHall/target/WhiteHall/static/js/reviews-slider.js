jQuery(function($) {

    $('.swiper-object .swiper-container').each(function(index, value) {

        var mySwiper = new Swiper(value, {
            autoplay: {
                delay: 5000,
            },
            navigation: {
                nextEl: value.nextElementSibling.nextElementSibling,
                prevEl: value.nextElementSibling,
            },
            pagination: {
                el: value.nextElementSibling.nextElementSibling.nextElementSibling,
                clickable: true,
            },
            slidesPerView: 'auto',
        });

    });
});
