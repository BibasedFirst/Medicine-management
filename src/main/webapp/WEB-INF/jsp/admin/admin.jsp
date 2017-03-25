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
<script src="<%=path%>/bootstrap/js/bootstrap-table.js"></script>
<script src="<%=path%>/bootstrap/js/bootstrap-table-zh-CN.js"></script>
<title>药品管理后台</title>
</head>
<body>
 
 
 <div class="container">
 
   	<ol class="breadcrumb">
	    <li><a href="#">药品管理后台</a></li>
	    <li  class="active">用户管理</li>
	    <li ><a href="<%=path%>/admin/listdrugs?page=1">药品管理</a></li>
	</ol>
 
<!--  用户列表 -->
<div class="container" style=" padding-top: 5%">

		    	会员信息
	<table id="myuser" data-toggle="table" data-url="" data-height=""
		data-click-to-select="true" data-method="get"
		data-query-params="queryParams" data-toolbar="#toolbar"
		data-pagination="true" data-search="true" data-show-refresh="true"
		data-show-toggle="true" data-show-columns="true" data-page-size="5">
	</table>

</div>
 
 </div>
 
 <script type="text/javascript">

	$('#myuser').bootstrapTable(
			{
				data: <%=request.getAttribute("user")%>,
				columns : [
						{
							field : 'state',
							checkbox : true,
						},
						{
							field : 'uName',
							title : '姓名'
						},
						{
							field : 'uPhone',
							title : '电话'
						},
						{
							field : 'isFreezing',
							title : '是否冻结'
						},
						{
							field : 'nickName',
							title : '昵称'
						},
						{
							title : '操作',
							field : 'temp',
							align : 'center',
							formatter : function(value, row, index) {
								var  temp = '<a href="#" mce_href="#" onclick="sc(\'' + row.uID + '\')">删除</a> '; 
								 temp += '&nbsp;<a href="#" mce_href="#" onclick="cz(\'' + row.uID + '\')">重置密码</a> '; 
								 temp += '&nbsp;<a href="#" mce_href="#" onclick="ck(\'' + row.uID + '\')">查看订单</a> '; 
								 temp += '&nbsp;<a href="#" mce_href="#" onclick="dj(\'' + row.uID + '\')">冻结</a> '; 
								 temp += '&nbsp;<a href="#" mce_href="#" onclick="jd(\'' + row.uID + '\')">解冻</a> '; 
								return temp;
							}
						} ]
			});
	
	
	
	 </script>	
</body>
</html>