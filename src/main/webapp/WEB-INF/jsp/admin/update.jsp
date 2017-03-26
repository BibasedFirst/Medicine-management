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
	    <li><a href="<%=path %>/admin/index">药品管理后台</a></li>
	    <li ><a href="<%=path%>/admin/index">用户管理</a></li>
	    <li  class="active"><a href="<%=path%>/admin/listdrugs?page=1">药品管理</a></li>
	    <li style="float: right;"><a href="<%=path%>/logout">注销</a></li>
	    <li style="float: right;"><a href="<%=path%>/admin/myme">个人信息</a></li>
	</ol>
	
	更新药品&nbsp;${Drugs.dName }
<hr> 
 <div style="width:300px" >
    <form class="bs-example bs-example-form" role="form" action="<%=path %>/admin/udpate" method="post">
         <div class="input-group input-group-sm" style="display: none">
            <span class="input-group-addon">药名</span>
            <input type="text" class="form-control" name="dID" placeholder="id"  value="${Drugs.dID }">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">药名</span>
            <input type="text" class="form-control" name="dName" placeholder="药名"  value="${Drugs.dName }">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">数量</span>
            <input type="text" class="form-control" name="dNumber" placeholder="数量，库存量" value="${Drugs.dNumber }">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">保质期</span>
            <input type="text" class="form-control" name="shelfLife" placeholder="保质期几个月。列如36月填36"  value="${Drugs.shelfLife }">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">生产日期</span>
            <input type="date" class="form-control" name="productionDate" placeholder="生产日期"  value="${Drugs.productionDate }">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">过期时间</span>
            <input type="date" class="form-control"  name="validUntil" placeholder="过期时间 格式2017-05-17"  value="${Drugs.validUntil }">
        </div> 
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">进价</span>
            <input type="text" class="form-control" name="buyPrice" placeholder="进价"  value="${Drugs.buyPrice }">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">售价</span>
            <input type="text" class="form-control" name="price" placeholder="售价"  value="${Drugs.price }">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">会员折扣</span>
            <input type="text" class="form-control" name="discount" placeholder="会员折扣 例如98折填98"  value="${Drugs.discount }">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">处方药</span>
            <input type="text" class="form-control" name="prescription" placeholder="处方药填1非处方填0"  value="${Drugs.prescription }">
        </div>
        <br>
        <button type="submit" class="btn btn-success" >提交</button>
    </form>
</div>
<br>
    

</div>	
 <div style="text-align:center;">
        <p>药品管理系统</p>
  </div> 
 

</body>
</html>