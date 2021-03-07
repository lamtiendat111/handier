<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../head.jsp"%>
<title><tiles:getAsString name="title" ignore="true" /></title>
	<tiles:insertAttribute name="head" ignore="true"/>
</head>
<body>
	<div class="header-outs " id="home">
		<tiles:insertAttribute name="header" />
	</div>
	<!-- banner -->
	<div class="inner_page-banner one-img"></div>
	<!--//banner -->
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="subscribe" />
	<tiles:insertAttribute name="footer" />
	<tiles:insertAttribute name="script-custom"  ignore="true"/>
</body>
</html>
