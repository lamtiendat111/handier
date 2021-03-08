<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Site wrapper -->
<div class="wrapper">



  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Product Edit</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="../../">Home</a></li>
              <li class="breadcrumb-item active"><a href="../product">Product</a></li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    
    <!-- Main content -->
    <section class="content">
      <form action="" method="post" enctype="multipart/form-data" id="formUpload">
        <div class="row">
          <div class="col-md-6">
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title"></h3>

                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                    <i class="fas fa-minus"></i></button>
                </div>
              </div>
              
              <div class="card-body">
                <div class="form-group">
                  <label for="inputName">Tên sản phẩm</label>
                  
                  <input type="text" id="inputName" name=tensanpham class="form-control" value="${sanpham.getTensanpham() }" required><span id="check" class=" text-danger"></span>
                  <input type="hidden" name="id" value="${sanpham.getMasanpham() }">

                </div>
                <div class="form-group">
                  <label for="inputYear">Thuộc danh mục</label>
                  <select class="form-control custom-select" name="madanhmuc" style="width:auto" required>
					<c:forEach items="${danhmucs }" var="danhmuc">
					 <option value="${danhmuc.getMadanhmuc() }"  
						 <c:if test="${danhmuc.getMadanhmuc() ==  sanpham.getDanhmucsanpham().getMadanhmuc() }"> 
						 		<c:out value = "selected" />
						 </c:if>
					  > ${danhmuc.getTendanhmuc() }
					</c:forEach>
                   
                  </select>


                </div>


                <div class="form-group">
                  <label for="inputPre">Precautions required</label>
                  <textarea id="inputPre" class="form-control" rows="4" name="precaution" required><?= $virus['Precautions_required'] ?></textarea><span id="checkP" class=" text-danger"></span>
                </div>

       

                <div class="form-group">
                  <label for="inputClientCompany">Total dead people</label>
                  <input type="number" id="inputClientCompany" class="form-control" name="Total" value="<?= $virus['Total_dead_people'] ?>" required><span id="checkT" class=" text-danger"></span>
                </div>
                <div class="form-group">
                  <label for="inputDescription">Description</label>
                  <textarea id="inputDescription" class="form-control" rows="4" name="description"><?= $virus['description'] ?></textarea><span id="checkD" class=" text-danger"></span>
                </div>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <div class="col-md-6">
            <div class="card card-secondary">
              <div class="card-header">
                <h3 class="card-title"></h3>

                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                    <i class="fas fa-minus"></i></button>
                </div>
              </div>

              <div class=" card-body">

                <div class="form-group">
                  <label for="inputLocal">Loacation Origin</label>
                  <textarea id="inputLocal" class="form-control" rows="4" name="Location" required><?= $virus['Location_Origin'] ?></textarea><span id="checkL" class=" text-danger"></span>
                </div>
                <div class="form-group">
                 
                  <label for="inputImage">Image</label>
                  <br>
                  <input type="text" id="InputImage" name="inputImage" value="Total number of images : <?= mysqli_num_rows($sqli) ?>" readonly>

                  <span>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                      Detail
                    </button>
                    <br>
                    <span id="output1" class=" text-danger"></span>
                    <!-- The Modal -->
                    <div class="modal" id="myModal">
                      <div class="modal-dialog">
                        <div class="modal-content">

                          <!-- Modal Header -->
                          <div class="modal-header">
                            <h4 class="modal-title text-capitalize">Virus of Image</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                          </div>

                          <!-- Modal body -->
                          <div class="modal-body">
                           
                              <table>
                                <tr>
                                  <th class=" text-center">Image</td>
                                  <td></td>
                                </tr>

                               
                              </table>
                              <input type="file" name="img_file[]" multiple="true" onchange="previewImg(event);" id="img_file" accept="image/*">
                                          <div class="box-preview-img"></div>
                                     
                                                    
                          </div>
                          <!-- button delete -->
                          <script>
                            $(document).ready(function() {
                              $('.delete1').click(function() {

                                var id = $(this).attr('name');
                                var xn = confirm('ban muon xoa id: ' + id);
                                if (xn == true) {
                                  $('#h' + id + '').remove();

                                  $.ajax({
                                    type: 'get',
                                    url: 'typeOfVirus/ajax_delete_image.php',
                                    data: {
                                      id: id
                                    },
                                    success: function(data) {
                                      $('#InputImage').val("Total number of image: " + data)
                                    }
                                  });
                                }

                              });

                            });
                          </script>
                          <!-- button delete -->
                          <!-- Modal footer -->
                          <div class="modal-footer">
                            <input type="reset" class="btn btn-default btn-reset" value="Reset ">
                           
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                          </div>
     
  </div>
</div>
</div>


</span>

</div>
            
<div class="form-group">
  <label for="inputLocal">Spread of Virus</label>
  <div class="row">
    <div class="col-6"> Virus-infected Country :</div>
    <div class="col-6">Country:</div>
  </div>
  <div class="row">

    <div class="col-6">


      <span> <input type="text" id="inputSpread" class="form-control " placeholder="Add New country here..."><span id="" class=" text-danger"></span></span>
      <input type="button" id="add" value="Add Country" class="mt-2">
    </div>
    <!-- function add element -->


    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.9.0.min.js"></script>
    <script>
      $(document).ready(function() {
        var arr = [];
        var country1 = document.getElementsByClassName('country');
        // neu co gia tri luc dau thi cho vao mang

        if (country1.length != 0) {
          for (var i = 0; i < country1.length; i++) {
            var item = country1[i].value.toLowerCase()
            arr.push(item);

          }
        }

        $("#add").click(function() {

          input = document.createElement('input');
          label = document.createElement('label');
          br = document.createElement('br');
          div = document.createElement('div');
          $(div).addClass("col-4");

          $country = $('#inputSpread').val().toLowerCase().trim().match(/[a-z]+/gi); // bo ki tu dat biet va bo mang thanh kieu string   
          if ($country !== null) {
            $country = $country.join(" ");
          }
          $(input).addClass("country text-capitalize").val($country);
          $(label).addClass("text-capitalize").text($country);

          // gan bien dem de kiem tra country ton tai
          var count = 0;
          if ($country !== null) {
            if (!arr.length) {
              arr.push($country);
              //tao div col 4


              $(div).append(input);
              $('.country').prop('name', 'spread[]');
              input.setAttribute("type", "checkbox");
              $(div).append(label);
              $(div).append(br);
              $('#containerA div.row').append(div);

            } else {
              //check country exist
              for (var item in arr) {

                if ($country == arr[item]) {
                  alert('This virus-infected country already exists');
                  return false;
                } else {
                  count++
                }
              };
              if (count != 0) {

                $(div).append(input);
                $('.country').prop('name', 'spread[]');
                input.setAttribute("type", "checkbox");
                $(div).append(label);
                $(div).append(br);
                arr.push($country);
                $('#containerA div.row').append(div);
                $.ajax({
                  type: 'post',
                  url: 'insert_country.php',
                  data: {
                    country: $country
                  },
                  success: function(data) {

                    $('#checkCountry').text("Add success");
                    $('#checkCountry').show();
                  }
                });
                setInterval(function() {
                  $('#checkCountry').hide();
                }, 2000);
              }
              //check country exist
            }

          };
          // reset input country
          $('#inputSpread').val('');
          // reset input country


          // gan gia tri cho mang array
        });
      });
    </script>
    <!-- function add element -->

    <div class="col-6" style="overflow: auto;  height: 150px;  width: 250px;border:1px solid #ced4da !important;" id="containerA">
      <div class="row">
        
      </div>
    </div>
         <span id="checkCountry" class=" text-danger text-right w-75"></span>
  </div>

</div>
        

<!-- muc category -->
<div class="form-group">
  <label for="inputCategory">Category</label>
  <div class="row">
    <div class="col-4"> </div>
    <div class="col-8">Symptoms:</div>
  </div>
  <div class="row">

    <div class="col-4">


      <span> <input type="text" id="inputCategory" class="form-control" style="font-size: small;" placeholder="Add New symptom here..."><span id="" class=" text-danger"></span></span>
      <input type="button" id="add1" value=" Enter " class="mt-2">
    </div>
    <!-- function add element -->

    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.9.0.min.js">
    </script>
    <script>
      $(document).ready(function() {
        var arr1 = [];
        var category1 = document.getElementsByClassName('category');
        // neu co gia tri luc dau thi cho vao mang

        if (category1.length != 0) {
          for (var i = 0; i < category1.length; i++) {
            var item = category1[i].value.toLowerCase()
            arr1.push(item);

          }
        }

        $("#add1").click(function() {

          input = document.createElement('input');
          label = document.createElement('label');
          br = document.createElement('br');
          div = document.createElement('div');
          $(div).addClass("col-6");

          $category = $('#inputCategory').val().toLowerCase().trim().match(/[a-z]+/gi); // bo ki tu dat biet va bo mang thanh kieu string   
          if ($category !== null) {
            $category = $category.join(" ");
          }
          $(input).addClass("category text-capitalize").val($category);
          $(label).addClass("text-capitalize").text($category);

          // gan bien dem de kiem tra country ton tai
          var count1 = 0;
          if ($category !== null) {
            if (!arr1.length) {
              arr1.push($category);
              //tao div col 4


              $(div).append(input);
              $('.category').prop('name', 'category[]');
              input.setAttribute("type", "checkbox");
              $(div).append(label);
              $(div).append(br);
              $('#containerB div.row').append(div);

            } else {
              //check country exist
              for (var item in arr1) {

                if ($category == arr1[item]) {
                  alert('This name symptom already exists');
                  return false;
                } else {
                  count1++
                }
              };
              if (count1 != 0) {

                $(div).append(input);
                $('.category').prop('name', 'category[]');
                input.setAttribute("type", "checkbox");
                $(div).append(label);
                $(div).append(br);
                arr1.push($category);
                $('#containerB div.row').append(div);
                $.ajax({
                  type: 'post',
                  url: 'insert_category.php',
                  data: {
                    category: $category
                  },
                  success: function(data) {

                    $('#checkCategory').text("Add success");
                    $('#checkCategory').show();
                  }
                });
                setInterval(function() {
                  $('#checkCategory').hide();
                }, 2000);
              }
              //check country exist
            }

          };
          // reset input country
          $('#inputCategory').val('');
          // reset input country


          // gan gia tri cho mang array
        });
      });
    </script>
    <!-- function add element -->

    <div class="col-8" style="overflow: auto;  height: 150px;  width: 250px;border:1px solid #ced4da !important;" id="containerB">
      <div class="row">

      
      </div>
    </div>
         <span id="checkCategory" class=" text-danger text-right w-75"></span>
  </div>

</div>


<!-- muc_category -->
</div>
<!-- /.card-body -->
</div>
<!-- /.card -->
</div>
</div>
<div class="row">
  <div class="col-12">
    <a href="dashboard.php?page=typeofvirus_list" class="btn btn-secondary">Cancel</a>
                <input class="btn-submit btn btn-primary" name="update" value="Update" readonly>


  </div>
</div>
</form>
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->


<!-- Control Sidebar -->

<!-- /.control-sidebar -->
</div>
