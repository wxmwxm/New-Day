$(function() {
		$(".currencyBox").hover(function() {
			$(this).addClass('active');
			$(".currency_detial").stop(true, true).delay(300).slideDown(500, "easeOutBounce");
			},  
			function() {
			$(".currency_detial").stop(true, true).delay(300).fadeOut(100, "easeInCubic");
		});
		$(".cart-block").hover(function() {
			$(this).addClass('active');
			$("#minicart").stop(true, true).delay(300).slideDown(500, "easeOutBounce");
			},  
			function() {
			$("#minicart").stop(true, true).delay(300).fadeOut(100, "easeInCubic");
		});
});
jQuery(function() {
	var jQueryallVideos = jQuery("iframe[src^='http://player.vimeo.com']"),jQueryfluidEl = jQuery(".about-banner");
	jQueryallVideos.each(function() {
		jQuery(this)
			.data('aspectRatio', this.height / this.width)
			.removeAttr('height')
			.removeAttr('width');
	});
	jQuery(window).resize(function() {
		var newWidth = jQueryfluidEl.width();
		jQueryallVideos.each(function() {
			var jQueryel = jQuery(this);
			jQueryel
				.width(newWidth)
				.height(newWidth * jQueryel.data('aspectRatio'));
		});
		if($(window).width() <= 1000){
			$('#smoothmenu1').hide();
			$('.mobMenu').show();
		}else{
			$('#smoothmenu1').show();
			$('.mobMenu').hide();
			}
	}).resize();

});
