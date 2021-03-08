<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
    $(document).ready(function() {
        $('#search').keyup(function() {
            var $key = $('#search').val();
            $.ajax({
                type: 'get',
                url: 'ajax_typeofvirus.php',
                data: {
                    key: $key
                },
                dataType: 'json',
                contentType: 'application/json',
                success: function(data) {
                    var result = ``;
                    for (var i = 0; i < data.length; i++) {

                        result += `  <tr id="h${data[i]['id_virus']}">
                                            
                                                <td>
                                                    <a>
                                                        ${data[i].name}
                                                    </a>
                                                    <br />
                                                 
                                                </td>
                                            
                                                <td >
                                                ${data[i]['Total_dead_people']}
                                                </td>
                                             
                                                <td class="project-actions text-right">
                                                 
                                                    <a class="btn btn-info btn-sm" href="dashboard.php?page=typeOfVirus/edit&id=${data[i]['id_virus']}">
                                                        <i class="fas fa-pencil-alt">
                                                        </i> Edit
                                                    </a>
                                                    <input class="btn btn-danger btn-sm delete1 fas fa-trash" type="button" id="${data[i]['name']}" name="${data[i]['id_virus']}" value="Delete">
                                                </td>
                                            </tr>`;

                    };
                    $('#rea').html(result);
                }
            });
        });
    });
</script>

<body class="hold-transition sidebar-mini">
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
							<h1>Type Of Virus</h1>
						</div>
						<div class="col-sm-3">

							<div class="input-group input-group-sm">
								<input id="search" class="form-control" style="top: 5px;"
									type="search" placeholder="Search list virus"
									aria-label="Search">
							</div>


						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="dashboard.php">Home</a></li>
								<li class="breadcrumb-item active"><a
									href="dashboard.php?page=typeofvirus">Type Of Virus</a></li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">

				<!-- Default box -->
				<div class="card">
					<div class="card-header row">
						<div class="col-10 ">
							<h3 class="card-title mt-2 mr-3">Virus</h3>
						</div>
						<a class="w3-button w3-circle w3-large w3-card-4"
							href="dashboard.php?page=typeofvirus/Create">
							<div class="btn"
								style="background-color: #7da2a25c; border-radius: 50%;">
								<i class="fa fa-plus"></i>
							</div>Add Virus
						</a>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								id="dropdownMenuButton" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">Lọc theo Category</button>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								<a class="dropdown-item" href="/admin/product/">All</a> 
								<c:forEach items="${danhmucs }" var="danhmuc">
<a	class="dropdown-item" href="../../admin/product/${danhmuc.getMadanhmuc() }">${danhmuc.getTendanhmuc() }</a> 
									
								</c:forEach>
								
								
							</div>
						</div>

						<div class="card-tools float-right mt-2 ml-3">
							<button type="button" class="btn btn-tool"
								data-card-widget="collapse" data-toggle="tooltip"
								title="Collapse">
								<i class="fas fa-minus"></i>
							</button>
							<button type="button" class="btn btn-tool"
								data-card-widget="remove" data-toggle="tooltip" title="Remove">
								<i class="fas fa-times"></i>
							</button>
						</div>
					</div>

					<div class="card-body p-0">
						<table class="table table-striped projects">
							<thead>
								<tr>

									<th style="width: 20%">Name Product</th>

									<th>Giá Tiền</th>
									<th>Hình sản phẩm</th>

								</tr>
							</thead>
							<tbody id="rea">

								<c:forEach items="${sanphams }" var="sanpham">

									<tr id="h<?= $virus['id_virus'] ?>">

										<td>${sanpham.getTensanpham() }</td>

										<td>${sanpham.getGiatien() }</td>

										<td><img src="blank.gif" data-src='<c:url value="/resource/images/${sanpham.getHinhsanpham()} "/>'
												class="img-thumbnail lazy" alt="" style="width: 25%!important;"></td>
										<td class="project-actions text-right">
											<a	class="btn btn-info btn-sm"		href="../editproduct/${sanpham.getMasanpham() }	">
												<i class="fas fa-pencil-alt"> </i> Edit
											</a>
											<input class="btn btn-danger btn-sm delete1 fas fa-trash"
											id="<?= $virus['name'] ?>" type="button"
											name="<?= $virus['id_virus'] ?>" value="Delete">
										</td>
									</tr>
								</c:forEach>

							</tbody>

						</table>
						<div id="hi"></div>
					</div>

					<!-- /.card-body -->
				</div>
				<!-- /.card -->

			</section>
			<!-- /.content -->
		</div>


		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	<script>
        $(document).ready(function() {
            $(document).on("click", ".delete1", function() {

                var id = $(this).attr('name');
                var name = $(this).attr('id');
                var xn = confirm('Are you remove name virus: ' + name + ' ?');
                if (xn == true) {
                    $('#h' + id + '').remove();
                    $.ajax({
                        type: 'get',
                        url: 'ajax_delete.php',
                        data: {
                            id: id
                        },
                        success: function(data) {

                            setInterval(function() {
                                $('#deleteRe').hide()
                            }, 3000)
                        }
                    });
                }

            });

        });
    </script>