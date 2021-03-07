<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--subscribe-address-->
<section class="subscribe wow rubberBand" data-wow-duration="2s">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-6 col-md-6 map-info-right px-0">
				<iframe
					src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d3150859.767904157!2d-96.62081048651531!3d39.536794757966845!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sin!4v1408111832978">
				</iframe>
			</div>
			<div class="col-lg-6 col-md-6 address-w3l-right text-center">
				<div class="address-gried ">
					<span class="far fa-map"></span>
					<p>
						25478 Road St.121<br>USA New Hill
					<p>
				</div>
				<div class="address-gried mt-3">
					<span class="fas fa-phone-volume"></span>
					<p>
						+(000)123 4565<br>+(010)123 4565
					</p>
				</div>
				<div class=" address-gried mt-3">
					<span class="far fa-envelope"></span>
					<p>
						<a href="mailto:info@example.com">info@example1.com</a> <br>
						<a href="mailto:info@example.com">info@example2.com</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</section>
<!--//subscribe-address-->
<section class="sub-below-address py-lg-4 py-md-3 py-sm-3 py-3">
	<div class="container py-lg-5 py-md-5 py-sm-4 py-3">
		<h3 class="title clr text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">Get
			In Touch Us</h3>
		<div class="icons mt-4 text-center">
			<ul>
				<li><a href="#"><span class="fab fa-facebook-f"></span></a></li>
				<li><a href="#"><span class="fas fa-envelope"></span></a></li>
				<li><a href="#"><span class="fas fa-rss"></span></a></li>
				<li><a href="#"><span class="fab fa-vk"></span></a></li>
			</ul>
			<p class="my-3">velit sagittis vehicula. Duis posuere ex in
				mollis iaculis. Suspendisse tincidunt velit sagittis vehicula. Duis
				posuere velit sagittis vehicula. Duis posuere</p>
		</div>
		<div class="email-sub-agile">
			<form action="#" method="post">
				<div class="form-group sub-info-mail">
					<input type="email" class="form-control email-sub-agile"
						placeholder="Email">
				</div>
				<div class="text-center">
					<button type="submit" class="btn subscrib-btnn">Subscribe</button>
				</div>
			</form>
		</div>
	</div>
</section>
<!--//subscribe-->
   <!-- Modal 1-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Login</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                    <div class="register-form">
                        <form action="j_spring_security_check?title=${title}" method="post">
                            <div class="fields-grid">
                                <div class="styled-input">
                                    <input type="text" placeholder="Your Name" name="username" required>
                                </div>
                                <div class="styled-input">
                                    <input type="password" placeholder="password" name="password" required>
                                </div>
                                <button type="submit" class="btn subscrib-btnn">Login</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" data-toggle="modal"
									data-target="#exampleModal1">
									<span class="far">Đăng ký</span>
								</button>
                </div>
            </div>
        </div>
    </div>
       <div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel1">Đăng Ký</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                    <div class="register-form">
                        <form name="myForm" onsubmit="return validateForm()" method="post">
                            <div class="fields-grid">
                                <div class="styled-input">
                                    <input type="text" placeholder="Tài khoản đăng nhập" name="username" required>
                                </div>
                                <div class="styled-input">
                                    <input type="password" placeholder="mật khẩu" name="password" required>
                                </div>
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
                                <button type="submit" class="btn subscrib-btnn">Đăng ký</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
   <!-- Load Facebook SDK for JavaScript -->
      <div id="fb-root"></div>
      <script>
        window.fbAsyncInit = function() {
          FB.init({
            xfbml            : true,
            version          : 'v9.0'
          });
        };
        (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = 'https://connect.facebook.net/en_US/sdk/xfbml.customerchat.js';
        fjs.parentNode.insertBefore(js, fjs);
      }(document, 'script', 'facebook-jssdk'));</script>

      <!-- Your Chat Plugin code -->
      <div class="fb-customerchat"
        attribution="setup_tool"
        page_id="1267637840068759">
      </div>
    <!-- //Modal 1-->