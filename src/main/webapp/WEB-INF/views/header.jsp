<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!--headder-->

<div class="header-bar wow bounceInDown">
	<div class="info-top-grid">
		<div class="info-contact-agile">
			<ul>
				<li><span class="fas fa-phone-volume"></span>
					<p>0935 997 123</p></li>
				<li><span class="fas fa-envelope"></span>
					<p>
						<a href="Thehandier.sg@gmail.com">Thehandier.sg@gmail.com</a>
					</p></li>
				<li></li>
			</ul>
		</div>
	</div>
	<div class="container-fluid">
		<div class="hedder-up row">
			<div class="col-lg-3 col-md-3 logo-head">
				<h1>
					<a class="navbar-brand" href="./" style="font-family: 'bungee';">THE
						HANDIER</a>
				</h1>
			</div>
			<div class="col-lg-5 col-md-6 search-right">
				<form class="form-inline my-lg-0" action="single" id="form-search">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" id="input-search" style="color: black;">
					<button class="btn" type="submit">Search</button>
				</form>
			</div>
			<div class="col-lg-4 col-md-3 right-side-cart">
				<div class="cart-icons">
					<ul class="navbar navbar-expand-lg navbar-light">
						

						<li><c:if test="${pageContext['request'].remoteUser == null}">
								<button type="button" data-toggle="modal"
									data-target="#exampleModal">
									<span class="far fa-user"></span>
								</button>

							</c:if> <c:if test="${pageContext['request'].remoteUser != null}">
							 <c:set var = "name" value = "${pageContext['request'].userPrincipal.name}"/>
							 <c:set var = "n1" value = "${fn:toUpperCase(fn:substring(name, 0, 1))}" />
														<div class="dropdown">
									<button class="btn btn-primary " type="button"
										data-toggle="dropdown">
										<span class="far ">${n1}</span>
									</button>
									<ul class="dropdown-menu">
										<li><a class="nav-link" href="/logout" style="color:black">Logout</a></li>
									</ul>
								</div>

							</c:if></li>
						<li class="toyscart toyscart2 cart cart box_1">
							<form action="checkout" method="get" class="last">

								<button class="top_toys_cart" type="submit">
									<span class="fas fa-cart-arrow-down c1"><c:if
											test="${giohang.size() > 0 }">
											<span id="sl-giohang" class="badge-light"
												style="padding: .25em .4em; border-radius: 54%;">${giohang.size()}</span>
										</c:if></span>
								</button>
							</form>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<nav class="navbar navbar-expand-lg navbar-light">
		<span id="logo-hide" style="font-family: 'bungee';">THE HANDIER</span>
		<div class="cart-icons" style="text-align: right" id="cart-mobi">
			<ul class="navbar navbar-expand-lg navbar-light">

				<li><c:if test="${pageContext['request'].remoteUser == null}">
								<button type="button" data-toggle="modal"
									data-target="#exampleModal">
									<span class="far fa-user"></span>
								</button>

							</c:if> <c:if test="${pageContext['request'].remoteUser != null}">
							 <c:set var = "name" value = "${pageContext['request'].userPrincipal.name}"/>
							 <c:set var = "n1" value = "${fn:toUpperCase(fn:substring(name, 0, 1))}" />
														<div class="dropdown">
									<button class="btn btn-primary " type="button"
										data-toggle="dropdown">
										<span class="far ">${n1}</span>
									</button>
									<ul class="dropdown-menu">
										<li><a class="nav-link" href="/logout" style="color:black">Logout</a></li>
										
									</ul>
								</div>

							</c:if></li>
				<li class="toyscart toyscart2 cart cart box_1">
					<form action="checkout" method="get" class="last">

						<button class="top_toys_cart" type="submit">
							<span class="fas fa-cart-arrow-down c2"><c:if
									test="${giohang.size() > 0 }">
									<span id="sl-giohang1" class="badge-light"
										style="padding: .25em .4em; border-radius: 54%;">${giohang.size()}</span>
								</c:if></span>
						</button>
					</form>
				</li>
			</ul>
		</div>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-center"
			id="navbarSupportedContent">
			<div class="col-lg-5 col-md-6 search-right" id="search-hide">
				<form class="form-inline my-lg-0" action="single" id="form-search1">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" id="input-search1" style="color: black;">
					<button class="btn" type="submit">Search</button>
				</form>
			</div>
			<ul class="navbar-nav ">
				<li class="nav-item active"><a class="nav-link" href="./">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a href="./about" class="nav-link">About</a>
				</li>
				<li class="nav-item"><a href="./service" class="nav-link">Size
						Chart</a></li>
				<%--<li class="nav-item"><a href="./shop" class="nav-link">Shop
						Now</a></li> --%>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown1"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Product </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<c:forEach items="${danhmucsanphams }" var="danhmuc">
							<a class="nav-link"
								href="product?maDanhMuc=${danhmuc.getMadanhmuc() }">${danhmuc.getTendanhmuc() }</a>
						</c:forEach>
					</div></li>
				<li class="nav-item"><a href="contact.html" class="nav-link">Contact</a>
				</li>
			</ul>
		</div>
	</nav>
</div>

<!--//headder-->

