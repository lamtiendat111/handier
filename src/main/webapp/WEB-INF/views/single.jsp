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
				<li>Service</li>
			</ul>
		</div>
	</div>
	<!-- //short-->
	<!--service -->
	<section class="banner-bottom py-lg-5 py-3">
		<div class="container">
			<div class="inner-sec-shop pt-lg-4 pt-3">
				<div class="row">
					<div class="col-lg-4 single-right-left col-md-6 col-12">
						<div class="grid images_3_of_2">
							<div class="flexslider1">
								<ul class="slides">
									<li data-thumb="blank.gif">
										<div class="thumb-image">
											<img src="blank.gif" data-imagezoom="true" class="img-fluid"
												alt=" ">
										</div>
									</li>
									<li data-thumb="blank.gif">
										<div class="thumb-image">
											<img src="blank.gif" data-imagezoom="true" class="img-fluid"
												alt=" ">
										</div>
									</li>

								</ul>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<div
						class="col-lg-8 single-right-left simpleCart_shelfItem col-md-6 col-12">
						<h3>${sanpham.getTensanpham() }VND</h3>
						<p>
							<span class="item_price "> <c:catch var="exception">
									<c:when test="${sanpham.getDanhsachkhuyenmai().size()}"></c:when>
								</c:catch> <c:choose>
									<c:when test="${exception == null }">
										<span style="text-decoration: line-through;"> <fmt:formatNumber
												type="number" maxFractionDigits="0"
												value="${Integer.parseInt(sanpham.getGiatien())  }" />VND

										</span>
										<fmt:parseNumber var="i" type="number" integerOnly="true"
											value="${Integer.parseInt(sanpham.getGiatien())  }" />

									
										<fmt:formatNumber type="numer" maxFractionDigits="0"
											value="${i* 0.8}" currencySymbol="VND" />



									</c:when>


									<c:when test="${exception != null }">
										<fmt:setLocale value="vi_VN" />
										<fmt:formatNumber value="${sanpham.getGiatien()  }"
											type="currency" currencySymbol="VND" />

									</c:when>
								</c:choose>
							</span>
							<!-- <del>$1,199</del> -->
						</p>
						<input type="hidden" name="masanpham" value="${masanpham}">


						<div class="" style="padding: 0px 10px;">
							<span class="mb-2">Types: </span><span><c:forEach
									var="mau" items="${ danhsachmau }">

									<label class="radio"> <input type="radio" name="color"
										value="${mau.key }"><i> </i> ${mau.value }
									</label>

								</c:forEach></span>



						</div>
						<div class="container">
							<div class="row  mt-3 "
								style="padding: 10px 0px; margin-bottom: -1px; background-color: #fff;">
								<div class="col-4 mt-1">Size</div>
								<div class="col-4 mt-1 ">Quantity</div>
								<div class="col-2 "></div>
							</div>
						</div>
						<div class="container" id="list-single">
							<c:forEach var="sp" items="${sanpham.getChitietsanpham() }">
								<div class="row  mt-3">
									<div class="col-4 mt-1">${sp.getSizesanpham().getSize() }
									</div>
									<div class="col-4 mt-1">${sp.getMausanpham().getTenmau() }
									</div>
									<div class="col-2 mt-1">${sp.getSoluong()}</div>
									<div class="col-1 ">
										<button class="btn-info hi add-card" data-machitiet="${sp.getMachitietsanpham() }"
											data-tensp="${sp.getSanpham().getTensanpham() }"
											data-giatien="${sp.getSanpham().getGiatien() }"
											data-tenmau="${sp.getMausanpham().getTenmau()  }"
											data-tensize="${sp.getSizesanpham().getSize()}"
											data-soluong="${sp.getSoluong() }" data-toggle="modal" data-target="#myModal">Add</button>

									</div>
								</div>
							</c:forEach>
						</div>



						<ul class="footer-social text-left mt-lg-4 mt-3">
							<li>Share On :</li>
							<li class="mx-1"><a href="#"> <span
									class="fab fa-facebook-f"></span>
							</a></li>
							<li class=""><a href="#"> <span class="fab fa-twitter"></span>
							</a></li>
							<li class="mx-1"><a href="#"> <span
									class="fab fa-google-plus-g"></span>
							</a></li>
							<li class=""><a href="#"> <span
									class="fab fa-linkedin-in"></span>
							</a></li>
							<li class="mx-1"><a href="#"> <span class="fas fa-rss"></span>
							</a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
					<!-- mota -->

					<div class="responsive_tabs">
						<div id="horizontalTab"
							style="display: block; width: 100%; margin: 0px;">
							<ul class="resp-tabs-list">
								<li class="resp-tab-item resp-tab-active"
									aria-controls="tab_item-0" role="tab">Description</li>

							</ul>
							<div class="resp-tabs-container">
								<!--/tab_one-->
								<h2 class="resp-accordion resp-tab-active" role="tab"
									aria-controls="tab_item-0">
									<span class="resp-arrow"></span>
								</h2>
								<div class="tab1 resp-tab-content resp-tab-content-active"
									style="display: block" aria-labelledby="tab_item-0">
									<div class="single_page">


										<p class="para">Lorem ipsum dolor sit amet, consectetur
											adipisicing elPellentesque vehicula augue eget nisl
											ullamcorper, molestie blandit ipsum auctor. Mauris volutpat
											augue dolor.Consectetur adipisicing elit, sed do eiusmod
											tempor incididunt ut lab ore et dolore magna aliqua. Ut enim
											ad minim veniam, quis nostrud exercitation ullamco. labore et
											dolore magna aliqua.</p>
									</div>
								</div>
								<!--//tab_one-->


							</div>
						</div>
					</div>
					<script type="text/javascript">
						$(document)
								.ready(
										(function() {
											$(
													'.resp-accordion[aria-controls="tab_item-1"]')
													.remove()
										}));
					</script>
					<!-- end mota -->
				</div>
			</div>
		</div>
		<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
           <h4 class="modal-title" style="text-align:center;width: 100%;">Thông Báo</h4>
          <button type="button" class="close" data-dismiss="modal" >&times;</button>
        </div>
        <div class="modal-body" style="text-align:center">
          <p>Thêm vào giỏ hàng thành công</p>
          
        </div>
        <div class="modal-footer">
        	<a href="checkout" class="btn btn-primary">Xem giỏ hàng</a>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
	</section>

