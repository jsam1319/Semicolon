/**  */
jQuery(function($) {
	var mySwiper = new Swiper('.swiper-container', {
		pagination : '.swiper-pagination',
		nextButton : '.swiper-button-next',
		prevButton : '.swiper-button-prev',
		paginationClickable : true,
		spaceBetween : 30,
		centeredSlides : true,
		autoplay : 3000,
		autoplayDisableOnInteraction : true, 
		loop : true
	});
 
	/** 웹에서의 자동 슬라이드 */
	$(".swiper-container").on("focusout", function() {
		setTimeout(function() {
			if ($(this).find(":focus").length === 0) {
				mySwiper.startAutoplay();
				console.log("focusout, startAutoplay");
			}
		}, 100);
	});

	/** 모바일에서의 자동 슬라이드 */
	$(document).on("touchmove", function() {
		mySwiper.startAutoplay();
		console.log("touchmove, startAutoplay");
	});

});
