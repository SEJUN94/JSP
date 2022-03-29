<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>



<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>

<style>
ul{
   list-style:none;
   }
</style>


  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

	<title><decorator:title default="Rundering Korea"/>Rundering Korea</title>
	
   <!--파비콘-->
  <link rel="shortcut icon" href="Favicon8.ico" />
  <link rel="icon" href="./Favicon8.png" />
  
  <!--Google Material Icons-->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
  
  <!-- main.js -->
  <script defer src="<%=request.getContextPath() %>/resources/js/main.js"></script>
  
  <!-- main.css -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/main.css" />
  
  
<decorator:head />
</head>
<body>

<%@ include file="/header.jsp" %>
	decorator.jsp<br/>
	header.jsp : message : ${message }
	<hr/>
	
<decorator:body />

<%@ include file="/footer.jsp" %>

<script>
	$('div.wrapper').css({
		"max-width":"1280px",
		"margin":"0 auto"		
	});
</script>  
</body>




</html>