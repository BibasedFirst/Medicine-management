<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap-table.css">
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>
<title>药品管理后台</title>
</head>
<body>
 
 
 <div class="container">
 
   	<ol class="breadcrumb">
	    <li><a href="#">药品管理后台</a></li>
	    <li  class="active">用户管理</li>
	    <li ><a href="<%=path%>/admin/listdrugs?page=1">药品管理</a></li>
	</ol>
 
 </div>
</body>
</html>