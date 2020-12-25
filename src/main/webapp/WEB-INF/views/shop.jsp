<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>Shop</title>
<%@ include file="head.jsp"%>
</head>
<body>
	<%@ include file="header.jsp"%>
	<!-- short -->
	<div class="using-border py-3">
		<div class="inner_breadcrumb  ml-4">
			<ul class="short_ls">
				<li><a href="./">Home</a> <span>/ /</span></li>
				<li>Shop Now</li>
			</ul>
		</div>
	</div>
	<!-- //short-->
	<section class="contact py-lg-4 py-md-3 py-sm-3 py-3">
		<div class="container-fluid py-lg-5 py-md-4 py-sm-4 py-3">
			<h3 class="title text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">Handier</h3>
			<div class="row">
				<div class="side-bar col-lg-3">
					<div class="search-hotel">
						<h3 class="agileits-sear-head">Search Here..</h3>
						<form action="#" method="post">
							<input type="search" placeholder="Product name..." name="search"
								required="" id="input-search1"> <input type="submit"
								value=" ">
						</form>
					</div>
					<!-- price range -->
					<div class="left-side">
						<h3 class="agileits-sear-head">Sắp Xếp</h3>
						<ul>
							<li><input type="radio" class="checked" name="sapxep" checked="checked" value="0"> <span
								class="span" >Sản phẩm nổi bật</span></li>
							<li><input type="radio" class="checked" name="sapxep" value="1"> <span
								class="span">Giá: Tăng dần</span></li>
							<li><input type="radio" class="checked" name="sapxep" value="2">  <span
								class="span">Giá: Giảm dần</span></li>
							<li><input type="radio" class="checked" name="sapxep" value="3"> <span
								class="span">Tên: A-Z</span></li>
							<li><input type="radio" class="checked" name="sapxep" value="4"> <span
								class="span">Tên: Z-A</span></li>
							<li><input type="radio" class="checked" name="sapxep" value="5"> <span
								class="span">Cũ nhất</span></li>
							<li><input type="radio" class="checked" name="sapxep" value="6"> <span
								class="span">Mới nhất</span></li>
							<li><input type="radio" class="checked" name="sapxep" value="7"> <span
								class="span">Bán chạy nhất</span></li>
						</ul>
					</div>
					<!-- //price range -->
					<!--preference -->
					<div class="left-side">
						<h3 class="agileits-sear-head">Category</h3>
						<ul>
						<li><input type="radio" class="checked" name="category" checked="checked" value="all"> <span
								class="span">All</span></li>
								<c:forEach var="danhmuc" items="${danhmucsanphams }">
								<li><input type="radio" class="checked" name="category" value="${danhmuc.getMadanhmuc() }"> <span
								class="span">${danhmuc.getTendanhmuc() }</span></li>
								</c:forEach>
							
						</ul>
					</div>
					<!-- // preference -->
					<!-- discounts -->
					<div class="left-side">
						<h3 class="agileits-sear-head">Sale</h3>
						<ul>
							<li><input type="checkbox" class="checked"> <span
								class="span">Sale</span></li>

						</ul>
					</div>
					<!-- //discounts -->


				</div>
				<div class="left-ads-display col-lg-9">
					<div class="row" id="container-pagi">

						<c:forEach var="sanpham" items="${sanphams}">
							<div class="col-lg-4 col-md-6 col-sm-6 product-men women_two">
								<div class="product-toys-info">
									<div class="men-pro-item">
										<div class="men-thumb-item">
											<img
												src='<c:url value="/resource/images/${sanpham.getHinhsanpham()}"/>'
												class="img-thumbnail" alt="">

											<div class="men-cart-pro">
												<div class="inner-men-cart-pro">
													<a href="single.html" class="link-product-add-cart">Quick
														View</a>
												</div>
											</div>
											<span class="product-new-top">New</span>
										</div>
										<div class="item-info-product">
											<div class="info-product-price">
												<div class="grid_meta">
													<div class="product_price">
														<h4>
															<a href="single.html">${sanpham.getTensanpham()}</a>
														</h4>
														<div class="grid-price mt-2">
															<span class="money "><c:out
																	value="${sanpham.getGiatien()} VND"></c:out> </span>
														</div>
													</div>
													
												</div>
												<div class="toys single-item hvr-outline-out">
													<form action="#" method="post">
														<input type="hidden" name="cmd" value="_cart"> <input
															type="hidden" name="add" value="1"> <input
															type="hidden" name="toys_item"
															value="${sanpham.getTensanpham()}"> <input
															type="hidden" name="amount"
															value="${sanpham.getGiatien()}">
														
													</form>
												</div>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>


					</div>

				</div>

				<div class="container-fluid">
					<div class="row float-right">
						<nav aria-label="Page navigation example" class="col" id="slmax"
							data-max="${tongsotrang}">
							<ul class="pagination">
								<li class="page-item"><div class="page-link1 page-link"
										aria-label="Previous">
										<span aria-hidden="true">«</span> <span class="sr-only">Previous</span>
										</a></li>
								<c:forEach var="i" begin="1" end="${tongsotrang}">
									<li class="page-item"><div class="page-link page-link1"
											aria-label="${i}">${i}
											</a></li>
								</c:forEach>

								<li class="page-item"><div class="page-link1 page-link"
										aria-label="Next">
										<span aria-hidden="true">»</span> <span class="sr-only ">Next</span>
										</a></li>
							</ul>
						</nav>
					</div>
				</div>

			</div>
		</div>
	</section>

	<%@ include file="subscribe.jsp"%></body>
<%@ include file="footer.jsp"%></ body>
</html>