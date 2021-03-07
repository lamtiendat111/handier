<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Locale,java.text.NumberFormat"%>


	<!-- short -->
	<div class="using-border py-3">
		<div class="inner_breadcrumb  ml-4">
			<ul class="short_ls">
				<li><a href="./">Home</a> <span>/ /</span></li>
				<li>Shop Now</li>
			</ul>class="side-bar col-lg-3"
		</div>
	</div>
	<!-- //button sap xep mobi-->
	<nav class="navbar navbar-expand-lg navbar-light"
		style="position: fixed; z-index: 10; bottom: 0px;
	/* border-radius: 18px; */ padding: inherit;margin: 5px" id="menu-2">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#button-left" aria-controls="button-left"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>	<span >     </span>

		</button>
		<div
			class="side-bar col-lg-3 collapse navbar-collapse justify-content-center"
			id="button-left">
			<div id="button-left2">

				<!-- price range -->
				<div class="left-side col-md-6 col-sm-6 col-6">
					<h3 class="agileits-sear-head">Sắp Xếp</h3>
					<ul>
						<li><input type="radio" class="checked" name="sapxep1"
							checked="checked" value="0"> <span class="span">Sản
								phẩm nổi bật</span></li>
						<li><input type="radio" class="checked" name="sapxep1"
							value="1"> <span class="span">Giá: Tăng dần</span></li>
						<li><input type="radio" class="checked" name="sapxep1"
							value="2"> <span class="span">Giá: Giảm dần</span></li>
						
						<li><input type="radio" class="checked" name="sapxep1"
							value="5"> <span class="span">Cũ nhất</span></li>
						<li><input type="radio" class="checked" name="sapxep1"
							value="6"> <span class="span">Mới nhất</span></li>
						<!--<li><input type="radio" class="checked" name="sapxep1"
							value="7"> <span class="span">Bán chạy nhất</span></li>  -->
					</ul>
					<h3 class="agileits-sear-head">Sale</h3>
					<ul>
						<li><input type="checkbox" class="checked" name="sale1"
							value="sale"> <span class="span">Sale</span></li>

					</ul>
				</div>
				<!-- //price range -->
				<!--preference -->
				<div class="left-side col-md-6 col-sm-6 col-6">
					<h3 class="agileits-sear-head">Category</h3>
					<ul>
						<li><input type="radio" class="checked" name="category1"
							checked="checked" value="all"> <span class="span">All</span></li>
						<c:forEach var="danhmuc" items="${danhmucsanphams }">
							<li><input type="radio" class="checked" name="category1"
								value="${danhmuc.getMadanhmuc() }"> <span class="span">${danhmuc.getTendanhmuc() }</span></li>
						</c:forEach>

					</ul>
					
				</div>
				<!-- // preference -->
				<!-- discounts -->
				
				<!-- //discounts -->
			</div>

		</div>

	</nav>
	<!-- // end button sap xep mobi-->
	<!-- //short-->
	<section class="contact py-lg-4 py-md-3 py-sm-3 py-3">
		<div class="container-fluid py-lg-5 py-md-4 py-sm-4 py-3">
			<h3 class="title text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3" style="font-family: bungee">THE HANDIER</h3>
			<div class="row">
				<div class="side-bar col-lg-3" id="button-left3" style="max-width: 14%!important;">

					<!-- price range -->
					<div class="left-side">
						<h3 class="agileits-sear-head">Sắp Xếp</h3>
						<ul>
							<li><input type="radio" class="checked" name="sapxep"
								checked="checked" value="0"> <span class="span">Sản
									phẩm nổi bật</span></li>
							<li><input type="radio" class="checked" name="sapxep"
								value="1"> <span class="span">Giá: Tăng dần</span></li>
							<li><input type="radio" class="checked" name="sapxep"
								value="2"> <span class="span">Giá: Giảm dần</span></li>
							
							<li><input type="radio" class="checked" name="sapxep"
								value="5"> <span class="span">Cũ nhất</span></li>
							<li><input type="radio" class="checked" name="sapxep"
								value="6"> <span class="span">Mới nhất</span></li>
							<!-- <li><input type="radio" class="checked" name="sapxep"
								value="7"> <span class="span">Bán chạy nhất</span></li> -->
						</ul>
						<h3 class="agileits-sear-head">Sale</h3>
					<ul>
						<li><input type="checkbox" class="checked" name="sale"
							value="sale"> <span class="span">Sale</span></li>

					</ul>
					</div>
					<!-- //price range -->
					<!--preference -->
					<div class="left-side ">
					<h3 class="agileits-sear-head">Category</h3>
					<ul>
						<li><input type="radio" class="checked" name="category"
							checked="checked" value="all"> <span class="span">All</span></li>
						<c:forEach var="danhmuc" items="${danhmucsanphams }">
							<li><input type="radio" class="checked" name="category"
								value="${danhmuc.getMadanhmuc() }"> <span class="span">${danhmuc.getTendanhmuc() }</span></li>
						</c:forEach>

					</ul>
					
				</div>
					<!-- // preference -->
					<!-- discounts -->
					
					<!-- //discounts -->


				</div>
				<div class="left-ads-display col-lg-9">
					<div class="row" id="container-pagi">
						<%
							Locale lc = new Locale("nv", "VN");
						NumberFormat nf = NumberFormat.getInstance(lc);
						%>
						<c:forEach var="sanpham" items="${sanphams}">
							<div class="col-lg-4 col-md-6 col-sm-6 product-men women_two">
								<div class="product-toys-info wow zoomIn">
									<div class="men-pro-item">
										<div class="men-thumb-item">
											<img src="blank.gif" data-src='<c:url value="/resource/images/${sanpham.getHinhsanpham()} "/>'
												class="img-thumbnail lazy" alt="">

											<div class="men-cart-pro">
												<div class="inner-men-cart-pro">
													<a href="single?masanpham=${ sanpham.getMasanpham()}" class="link-product-add-cart">Quick
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
															<a href="single?masanpham=${ sanpham.getMasanpham()}">${sanpham.getTensanpham()}</a>
														</h4>
														<div class="grid-price mt-2">
															<span class="money "> <c:catch var="exception">
																	<c:when test="${sanpham.getDanhsachkhuyenmai().size()}"></c:when>
																</c:catch> <c:choose>
																	<c:when test="${exception == null }">
																		<span style="text-decoration: line-through;"> <fmt:formatNumber
																				type="number" maxFractionDigits="0"
																				value="${Integer.parseInt(sanpham.getGiatien())  }" />VND

																		</span>
																		<fmt:parseNumber var="i" type="number"
																			integerOnly="true"
																			value="${Integer.parseInt(sanpham.getGiatien())  }" />

																		</br>
																		<fmt:formatNumber type="numer" maxFractionDigits="0"
																			value="${i* 0.8}" currencySymbol="VND" />



																	</c:when>


																	<c:when test="${exception != null }">
																		<fmt:setLocale value="vi_VN" />
																		<fmt:formatNumber value="${sanpham.getGiatien()  }"
																			type="currency" currencySymbol="VND" />
																		<p>&nbsp;</p>
																	</c:when>
																</c:choose>
															</span>
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

				<div  id="pagination_bar"
					style="position: fixed; bottom: 0; right: 84px; z-index: 999;margin-bottom: 5px;">
					<div class="row float-right">
						<nav aria-label="Page navigation example" class="col" id="slmax"
							data-max="${tongsotrang}">
							<ul class="pagination">
								<li class="page-item"><div class="page-link1 page-link"
										aria-label="Previous">
										<span aria-hidden="true">«</span> <span class="sr-only">Previous</span>
										</div></li>
								<c:forEach var="i" begin="1" end="${tongsotrang}">
									<li class="page-item"><div class="page-link page-link1"
											aria-label="${i}">${i}
											</div></li>
								</c:forEach>

								<li class="page-item"><div class="page-link1 page-link"
										aria-label="Next">
										<span aria-hidden="true">»</span> <span class="sr-only ">Next</span>
										</div></li>
							</ul>
						</nav>
					</div>
				</div>

			</div>
		</div>
	</section>

