<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- footer -->
<footer class="py-lg-4 py-md-3 py-sm-3 py-3 text-center">
	<div class="copy-agile-right">
		<p>
			© 2018 Toys-Shop. All Rights Reserved | Design by <a
				href="http://www.W3Layouts.com" target="_blank">W3Layouts</a>
		</p>
	</div>
</footer>
<!-- <script src='<c:url value="/resource/js/jquery-2.2.3.min.js"/>'></script> -->


<!--//js working-->
<!-- cart-js -->

<script src='<c:url value="/resource/js/minicart.js"/>'></script>
<script src='<c:url value="/resource/js/custom.js"/>'></script>
<script>
	toys.render();

	toys.cart.on('toys_checkout', function(evt) {
		var items, len, i;

		if (this.subtotal() > 0) {
			items = this.items();

			for (i = 0, len = items.length; i < len; i++) {
			}
		}
	});
</script>
<!-- //cart-js -->
<!-- start-smoth-scrolling -->

<script src='<c:url value="/resource/js/move-top.js"/>'></script>

<script src='<c:url value="/resource/js/easing.js"/>'></script>
<script>
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 900);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<!-- here stars scrolling icon -->
<script>
	$(document).ready(function() {

		var defaults = {
			containerID : 'toTop', // fading element id
			containerHoverID : 'toTopHover', // fading element hover id
			scrollSpeed : 1200,
			easingType : 'linear'
		};

		$().UItoTop({
			easingType : 'easeOutQuart'
		});

	});
</script>
<!-- //here ends scrolling icon -->
<!--bootstrap working-->
<script src='<c:url value="/resource/js/bootstrap.min.js"/>' ></script>
<!-- //bootstrap working-->
<!-- //OnScroll-Number-Increase-JavaScript -->