<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><tiles:getAsString name="title" ignore="true" /></title>
	<tiles:insertAttribute name="head" ignore="true"/>

</head>
<body>
	<div class="header-outs " id="home">
		<tiles:insertAttribute name="header" />
		<!-- Slideshow 4 -->
		<div class="slider text-center">
			<div class="callbacks_container">
				<ul class="rslides" id="slider4">
					<li>
						<div class="slider-img one-img">
							<div class="container wow shake">
								<div class="slider-info ">
									<h5>
										Pick The Best Toy For <br>Your Kid
									</h5>
									<div class="bottom-info">
										<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
											elit.Aenean commodo ligula eget dolorL orem ipsum dolor sit
											amet eget dolor</p>
									</div>
									<div class="outs_more-buttn">
										<a href="about.html">Read More</a>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="slider-img two-img">
							<div class="container wow bounce">
								<div class="slider-info ">
									<h5>
										Sort Toys And Teddy bears<br>For Kids
									</h5>
									<div class="bottom-info">
										<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
											elit.Aenean commodo ligula eget dolorL orem ipsum dolor sit
											amet eget dolor</p>
									</div>
									<div class="outs_more-buttn">
										<a href="about.html">Read More</a>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="slider-img three-img">
							<div class="container">
								<div class="slider-info">
									<h5>
										Best Toys And Dolls<br> For Kids
									</h5>
									<div class="bottom-info">
										<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
											elit.Aenean commodo ligula eget dolorL orem ipsum dolor sit
											amet eget dolor</p>
									</div>
									<div class="outs_more-buttn">
										<a href="about.html">Read More</a>
									</div>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<!-- This is here just to demonstrate the callbacks -->
			<!-- <ul class="events">
               <li>Example 4 callback events</li>
               </ul>-->
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //about -->
	<tiles:insertAttribute name="body1" />
	<tiles:insertAttribute name="body" />
	<!-- //about -->
	<!--new Arrivals -->

	<!--//about -->

	<!-- Product-view -->
	
	<tiles:insertAttribute name="subscribe" />
	<tiles:insertAttribute name="footer" />
	<script src='<c:url value="/resource/js/responsiveslides.min.js"/>'></script>
	<script src='<c:url value="/resource/js/jquery.flexisel.js"/>'></script>
<script>
	$(function() {
		// Slideshow 4
		$("#slider4").responsiveSlides({
			auto : true,
			pager : false,
			nav : true,
			speed : 900,
			namespace : "callbacks",
			before : function() {
				$('.events').append("<li>before event fired.</li>");
			},
			after : function() {
				$('.events').append("<li>after event fired.</li>");
			}
		});

	});
</script>


<script>
	$(window).load(function() {
		$("#flexiselDemo1").flexisel({
			visibleItems : 3,
			animationSpeed : 3000,
			autoPlay : true,
			autoPlaySpeed : 2000,
			pauseOnHover : true,
			enableResponsiveBreakpoints : true,
			responsiveBreakpoints : {
				portrait : {
					changePoint : 480,
					visibleItems : 1
				},
				landscape : {
					changePoint : 640,
					visibleItems : 2
				},
				tablet : {
					changePoint : 768,
					visibleItems : 2
				}
			}
		});

	});
</script>



</body>
</html>