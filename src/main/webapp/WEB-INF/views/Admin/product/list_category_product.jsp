<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!-- Site wrapper -->
    <div class="wrapper">
        <!-- Navbar -->
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-3">
                            <h1>Product</h1>
                        </div>
                        <div class="col-sm-3">
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="dashboard.php">Home</a></li>
                                <li class="breadcrumb-item active"><a href="dashboard.php?page=typeofvirus">Product</a></li>
                            </ol>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </section>

            <!-- Main content
             -->
            <div class="wrapper">
                <div class="row">
				     <c:forEach items="${danhmucsanphams}" var="danhmucsanpham">
				     <a href="product/${danhmucsanpham.getMadanhmuc()}">
					<div class="col-12 btn btn-danger mr-2 ml-2 mt-3 pl-2"
						style="text-align: left;">
						
						<h5>
							<c:out value=" ${danhmucsanpham.getTendanhmuc()}"></c:out>
						</h5>
						
						
					</div>  
					</a>
					</br>   
				</c:forEach>
		
                </div>
            </div>
            </ul>
            <!-- /.content -->
        </div>


        <!-- Control Sidebar -->
        <aside class="control-sidebar control-sidebar-dark">
            <!-- Control sidebar content goes here -->
        </aside>
        <!-- /.control-sidebar -->
    </div>
    <!-- ./wrapper -->


