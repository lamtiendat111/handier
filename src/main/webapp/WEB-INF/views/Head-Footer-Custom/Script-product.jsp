
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src='<c:url value="/resource/js/product.js"/>'></script>
<script>
	$(function() {

		var $btn = $('#pagination_bar');
		var $home = $('#topSection');
		var startpoint = 300;

		$(window).on('scroll', function() {
			if ($(window).scrollTop() > startpoint) {
				$btn.show();
			} else {
				$btn.hide();
			}
		});
	});
</script>