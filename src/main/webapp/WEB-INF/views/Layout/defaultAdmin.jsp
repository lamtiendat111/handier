<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" ignore="true" /></title>
	<tiles:insertAttribute name="head" ignore="true"/>
</head>
<body>
  <div class="hold-transition sidebar-mini layout-fixed">
    <!-- Control Sidebar -->
<tiles:insertAttribute name="navbar" />
<tiles:insertAttribute name="sidebar" />
<tiles:insertAttribute name="body" />
    <aside class="control-sidebar control-sidebar-dark">
      <!-- Control sidebar content goes here -->
    </aside>
<tiles:insertAttribute name="footer" />
  </div>
</body>
</html>