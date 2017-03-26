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
<title>个人信息修改</title>
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
	
	更新个人信息
<hr> 
 <div style="width:250px;float: left" >
    <form class="bs-example bs-example-form" role="form" action="<%=path %>/admin/udpatemy" method="post">
         <div class="input-group input-group-sm" style="display: none">
            <input type="hidden" class="form-control" name="uID" placeholder="id"  value="${u.uID }">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <input type="hidden" class="form-control" name="uName" placeholder="药名"  value="${u.uName }">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">电话</span>
            <input type="text" class="form-control" name="uPhone" placeholder="数量，库存量" value="${u.uPhone }">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">问题</span>
            <input type="text" class="form-control" name="question"  value="${u.question }">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">答案</span>
            <input type="text" class="form-control" name="answer" placeholder="生产日期"  value="${u.answer }">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">昵称</span>
            <input type="text" class="form-control"  name="nickName" placeholder="过期时间 格式2017-05-17"  value="${u.nickName }">
        </div> 
        <br>
        <button type="submit" class="btn btn-success" >更新</button>
    </form>
</div>

 <div style="width:250px;float: left;padding-left: 50px;padding-top: 35px" >
    <form class="bs-example bs-example-form" role="form" action="<%=path %>/admin/udpatemymm" method="post">
         <div class="input-group input-group-sm"  >
            <span class="input-group-addon">原密码</span>
            <input type="password" class="form-control" name="uPwd" placeholder="原密码"  >
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">新密码</span>
            <input type="password" class="form-control" name="nickName" placeholder="新密码">
        </div>
        <br>
        <button type="submit" class="btn btn-success" >更新密码</button>
    </form>
</div>
<br>
    

</div>	
 <div style="text-align:center;">
        <p>药品管理系统</p>
  </div> 
 

</body>
</html>