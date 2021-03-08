<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
  <!-- Brand Logo -->
  <a href="dashboard.php" class="brand-link">
    <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
    <span class="brand-text font-weight-light">HANDIER</span>
  </a>

  <!-- Sidebar -->
  <div class="sidebar">
    <!-- Sidebar user panel (optional) -->
    <div class="user-panel mt-3 pb-3 mb-3 row">

      <div class="info col-12">
        <p class=" text-uppercase" style="color: rgba(255,255,255,.8);"><?= $_SESSION['username'] ?></p>
      </div>
      <div class="info">
        <a href="register/register.php"> <span style="color: white;" class="fa fa-plus" aria-hidden="true"></span> <span style="color: white;">Register </span> </a>

      </div>
    </div>

    <!-- Sidebar Menu -->
    <nav class="mt-2">
      <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
        <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->


        <li class="nav-item has-treeview menu-open">
          <a href="#" class="nav-link">
            <i class="nav-icon fas fa-book"></i>
            <p>
              Pages
              <i class="fas fa-angle-left right"></i>
            </p>
          </a>
          <ul class="nav nav-treeview">



            <li class="nav-item">
              <a href="dashboard.php?page=contacts" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>Contact</p>
              </a>
            </li>
            <li class="nav-item">
              <a href="/admin/product/" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>Sản Phẩm</p>
              </a>
            </li>

            <li class="nav-item">
              <a href="dashboard.php?page=year" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                <p>Year Wise Listing</p>
              </a>
            </li>

          </ul>
        </li>

    </nav>
    <!-- /.sidebar-menu -->
  </div>
  <!-- /.sidebar -->
</aside>
<ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
  <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->



  </nav>