<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- footer -->
<footer
	class="py-lg-4 py-md-3 py-sm-3 py-3 text-center woo jackInTheBox"
	data-wow-duration="2s">
	<div class="copy-agile-right">
		<p>Copyright © 2020 HANDIER, LLC. All Rights Reserved | Design by
			DD Team</p>
	</div>
</footer>
<script src='<c:url value="/resource/js/minicart.js"/>'></script>
<script src='<c:url value="/resource/js/move-top.js"/>'></script>
<script src='<c:url value="/resource/js/lazyload.js"/>'></script>
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
		$('#input-search').click(function() {
			$('#input-search').autocomplete({
				source : 'api/search'
			});
		});
		$('#input-search1').click(function() {
			$('#input-search1').autocomplete({
				source : 'api/search'
			});
		});
	});
</script>
<script type="text/javascript">
						$('#form-search').on("submit", function(event) {
						    event.preventDefault();
						    var name = $('#input-search').val();
						    $.ajax({
						        type: 'get',
						        url: 'api/searchSanPham',
						        data: {
						            name: name
						        },
						        dataType: 'json',
						        contentType: 'application/json',

						        success: function(data) {
						            if ($('#form-search input[type="hidden"]').val()) {
						                $('#form-search input[type="hidden"]').remove();
						            }
						            $('#form-search').append(data["id"]);
									var status = true;
									if(data["id"] == " "){
										status = false;}
									if(status){
										$('#form-search').unbind();
									$('#form-search').submit();
										}	else{
										alert("Don't find product");
										}
						        }
						    });
						
						});
						</script>
						<script type="text/javascript">
						$('#form-search1').on("submit", function (event) {
						    event.preventDefault();
						    var name = $('#input-search1').val();
						    $.ajax({
						        type: 'get',
						        url: 'api/searchSanPham',
						        data: {
						            name: name
						        },
						        dataType: 'json',
						        contentType: 'application/json',

						        success: function(data) {
						            if ($('#form-search1 input[type="hidden"]').val()) {
						                $('#form-search1 input[type="hidden"]').remove();
						            }
						            $('#form-search1').append(data["id"]);
									var status = true;
									if(data["id"] == " "){
										status = false;
										}
									
									if(status){
										$('#form-search1').unbind();
									$('#form-search1').submit();
										}
									else{
										alert("Don't find product");
										}
						        }
						    });
						
						});
						</script>

<script src='<c:url value="/resource/js/bootstrap.min.js"/>'></script>

<!-- //bootstrap working-->
<!-- //OnScroll-Number-Increase-JavaScript -->
<script src='<c:url value="/resource/js/wow.min.js"/>'></script>

<script>
	new WOW().init();
	function validateForm() {
	  var x = document.forms["myForm"]["fname"].value;
	  if (x == "") {
	    alert("Name must be filled out");
	    return false;
	  }
	}

</script>