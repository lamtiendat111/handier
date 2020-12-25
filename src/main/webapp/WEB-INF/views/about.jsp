<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="head.jsp"%>
</head>
<body>
	<%@ include file="header.jsp"%>
	<!-- short -->
	<div class="using-border py-3">
		<div class="inner_breadcrumb  ml-4">
			<ul class="short_ls">
				<li><a href="./">Home</a> <span>/ /</span></li>
				<li>About</li>
			</ul>
		</div>
	</div>
	<!-- //short-->
	<section class="about py-lg-4 py-md-3 py-sm-3 py-3" id="about">
		<div class="container py-lg-5 py-md-5 py-sm-4 py-4">
			<h3 class="title text-center mb-lg-5 mb-md-4  mb-sm-4 mb-3">Best
				Products</h3>
			<div class="row banner-below-w3l">
				<div
					class="col-lg-4 col-md-6 col-sm-6 text-center banner-agile-flowers">
					<img src='<c:url value="/resource/images/a1.jpg"/>'
						class="img-thumbnail" alt="">

					<div class="banner-right-icon">
						<h4 class="pt-3">Baby Toys</h4>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-6 text-center banner-agile-flowers">
					<img src='<c:url value="/resource/images/a2.jpg"/>'
						class="img-thumbnail" alt="">

					<div class="banner-right-icon">
						<h4 class="pt-3">Lite-Brite</h4>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-6 text-center banner-agile-flowers">
					<img src='<c:url value="/resource/images/a3.jpg"/>'
						class="img-thumbnail" alt="">
					<div class="banner-right-icon">
						<h4 class="pt-3">Key Toys</h4>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-6 mt-3 text-center banner-agile-flowers">
					<img src='<c:url value="/resource/images/a4.jpg"/>'
						class="img-thumbnail" alt="">
					<div class="banner-right-icon">
						<h4 class="pt-3">Play Toys</h4>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-6 mt-3 text-center banner-agile-flowers">
					<img src='<c:url value="/resource/images/a5.jpg"/>'
						class="img-thumbnail" alt="">
					<div class="banner-right-icon">
						<h4 class="pt-3">Gift Toys</h4>
					</div>
				</div>
				<div
					class="col-lg-4 col-md-6 col-sm-6 mt-3 text-center banner-agile-flowers">
					<img src='<c:url value="/resource/images/a6.jpg"/>'
						class="img-thumbnail" alt="">
					<div class="banner-right-icon">
						<h4 class="pt-3">Soft Toys</h4>
					</div>
				</div>
				<div class="toys-grids-upper">
					<div class="about-toys-off">
						<h2>
							Get Up to <span>70% Off </span>On Selected Toys
						</h2>
					</div>
				</div>
			</div>
		</div>
	</section>
		<%@ include file="subscribe.jsp"%></body>
	<%@ include file="footer.jsp"%>
</body>
</html>