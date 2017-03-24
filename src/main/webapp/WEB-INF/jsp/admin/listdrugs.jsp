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
	    <li ><a href="<%=path%>/admin/index">用户管理</a></li>
	    <li  class="active">药品管理</li>
	</ol>
 
    <table class="table table-hover table-bordered">
	  <caption>所有药品</caption>
		  <thead>
		    <tr>
		      <th>药名</th>
		      <th>数量</th>
		      <th>保质期</th>
		      <th>生产日期</th>
		      <th>过期时间</th>
		      <th>进价</th>
		      <th>售价</th>
		      <th>会员折扣</th>
		      <th>操作</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${list }" var="drugs">
		   	  <tr>
		       <td>${drugs.dName }</td>
		       <td>${drugs.dNumber }</td>
		       <td>${drugs.shelfLife}月</td>
		       <td><fmt:formatDate value="${drugs.productionDate}"  pattern="yyyy-MM-dd HH:mm:ss"/></td>
		       <td><fmt:formatDate value="${drugs.validUntil }"  pattern="yyyy-MM-dd HH:mm:ss"/></td> 
		       <td><fmt:formatNumber type="number" value="${drugs.buyPrice }" pattern="0.00" maxFractionDigits="2"/> </td>
		       <td><fmt:formatNumber type="number" value="${drugs.price }" pattern="0.00" maxFractionDigits="2"/></td>
		       <td>${drugs.discount }</td> 
		       <td><a href="<%=path%>/admin/deletedrugsbyid?id=${drugs.dID}">删除</a><a>更新</a></td>
		    </tr>
		  </c:forEach>
		   
		  </tbody>
	</table>
 </div>
 
 <script type="text/javascript">
 
 
 </script>
</body>
</html>