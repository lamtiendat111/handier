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
				<li>Checkout</li>
			</ul>
		</div>
	</div>
	<!-- //short-->
	<section class="checkout py-lg-4 py-md-3 py-sm-3 py-3">
		<div class="container py-lg-5 py-md-4 py-sm-4 py-3">
			<div class="shop_inner_inf">
				<div class="privacy about">
					<h3>
						<span>Checkout</span>
					</h3>
					<div class="checkout-right" style="text-align: center;">

						<div class="row timetable_sub">
							<div class="col-4 col-md-6">Product</div>
							<div class="col-2 col-md-3">Quality</div>
							<div class="col-2 col-md-1">Price</div>
							<div class="col-2 col-md-1">Size</div>
							<div class="col-2 col-md-1">Remove</div>
						</div>


						<c:set var="i" value="1" />
						<c:forEach var="item" items="${giohang }">
							<div class="row rem${i}">

								<div class="col-4 col-md-6 thumb-cart"
									style="border: 1px solid #CDCDCD;">
									<a href="single?masanpham=${item.value.getMasanpham() }"><img
										src="<c:url value='/resource/images/a1.jpg' />" alt=" "
										class="img-responsive"
										style="width: 50px; margin-right: 15px; float: left;">
										
										<h4	style="font-size: 16px; color: #000; text-align: left; margin: 0; margin-bottom: 10px;">${item.value.getTensp() }(
											${item.value.getTenmau() })</h4> </a>
								</div>

								<div class="col-2 col-md-3 quantity"
									style="border: 1px solid #CDCDCD; text-align: center;">
									<div class="quantity-select">
										<div class="entry value-minus"
											data-mamau="${item.value.getMamau() }"
											data-masp="${item.value.getMasanpham() }"
											data-machitiet="${item.value.getMachitiet() }"
											data-tensp="${item.value.getTensp() }"
											data-giatien="${item.value.getGiatien() }"
											data-tenmau="${item.value.getTenmau()  }"
											data-tensize="${item.value.getTensize()}"
											data-soluong="${item.value.getSoluong() }">&nbsp;</div>
										<div class="entry value">
											<span>${item.value.getSoluong() }</span>
										</div>
										<div class="entry value-plus active"
											data-mamau="${item.value.getMamau() }"
											data-masp="${item.value.getMasanpham() }"
											data-machitiet="${item.value.getMachitiet() }"
											data-tensp="${item.value.getTensp() }"
											data-giatien="${item.value.getGiatien() }"
											data-tenmau="${item.value.getTenmau()  }"
											data-tensize="${item.value.getTensize()}"
											data-soluong="${item.value.getSoluong() }">&nbsp;</div>
									</div>
								</div>
								<div class="col-2 col-md-1 invert"
									style="border: 1px solid #CDCDCD;">${item.value.getGiatien() }</div>
								<div class="col-2 col-md-1 invert"
									style="border: 1px solid #CDCDCD;">${item.value.getTensize() }</div>
								<div class="col-2 col-md-1 rem"
									style="border: 1px solid #CDCDCD;">
									<div class="close${i} button-delete"
										data-machitiet="${item.value.getMachitiet() }"></div>
								</div>
							</div>

							<c:set var="i" value="${i+1}" />
						</c:forEach>


					</div>
					<div class="checkout-left">
						<div class="col-md-5 col-12 checkout-left-basket">
							<h4>Continue to basket</h4>
							<ul id="total-card">
								<c:forEach var="item" items="${giohang }">
									<li>${item.value.getTensp() }(${item.value.getTenmau() })
										<i>-</i> <span>${item.value.getGiatien()*item.value.getSoluong() }
									</span>
									</li>
								</c:forEach>
								<li>Total <i>-</i> <span>${total }</span></li>
							</ul>
						</div>
						<div class="col-md-7 col-12 address_form">
							<h3>Thông tin giao hàng</h3>
							<c:if test="${pageContext['request'].remoteUser == null}">
							<p class="section-content-text">
								Bạn đã có tài khoản? 
							</p>
								<button type="button" data-toggle="modal"
									data-target="#exampleModal">
									<a	style="text-decoration: none; color: #338dbc; transition: color 0.2s ease-in-out; display: inline-block;"
									>Đăng nhập</a>
								</button>

							</c:if>
							
							<form action="payment.html" method="post"
								class="creditly-card-form agileinfo_form">
								<section class="creditly-wrapper wrapper">
									<div class="information-wrapper">
										<div class="first-row form-group">
											<div class="controls">
												<input class="billing-address-name form-control" type="text"
													name="name" placeholder="Full name" value="${pageContext['request'].userPrincipal.principal.fullname}">
											</div>
											<div class="card_number_grids">
												<div class="card_number_grid_left">
													<div class="controls">
														<input class="form-control" type="text"
															placeholder="Mobile number" value="${pageContext['request'].userPrincipal.principal.phone}">
													</div>
												</div>
												<div class="card_number_grid_right">
													<div class="controls">
														<input class="form-control" type="email"
															placeholder="Email" value="${pageContext['request'].userPrincipal.principal.email}">
													</div>
												</div>
												<div class="clear"></div>
											</div>
											<div class="controls">
												<input class="form-control" type="text"
													placeholder="Address" value="${pageContext['request'].userPrincipal.principal.diachi}">
											</div>
											<div class="controls">
												<label class="control-label">Address type: </label> <select
													class="form-control option-w3ls">
													<option>Office</option>
													<option>Home</option>
													<option>Commercial</option>
												</select>
											</div>
										</div>
										<button class="submit check_out">Delivery to this
											Address</button>
									</div>
								</section>
							</form>
							<div class="checkout-right-basket">
								<a href="payment.html">Make a Payment </a>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!-- //top products -->
		</div>
	</section>
