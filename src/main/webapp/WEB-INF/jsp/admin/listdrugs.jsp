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
	    <li  class="active">药品管理</li>
	    <li style="float: right;"><a href="<%=path%>/logout">注销</a></li>
	    <li style="float: right;"><a href="<%=path%>/admin/myme">个人信息</a></li>
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
		      <th>处方药</th>
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
		       <td><c:if test="${drugs.prescription eq 1 }">是</c:if><c:if test="${drugs.prescription eq 0 }">否</c:if></td> 
		       <td><a href="<%=path%>/admin/deletedrugsbyid?id=${drugs.dID}">删除</a><a href="<%=path%>/admin/updatebyid?id=${drugs.dID}">更新</a></td>
		    </tr>
		  </c:forEach>
		   
		  </tbody>
	</table>
	             总共 <font color="red"> ${sum}</font> 条记录   &nbsp; &nbsp; &nbsp;当前页 <font color="red"> ${page}</font>   &nbsp; &nbsp; &nbsp;<span style="padding-right: 20%;float: right;" id="page"> </span>
       <hr> 
 <div style="width:300px" >
    <form class="bs-example bs-example-form" role="form" action="<%=path %>/admin/postyp" method="post">
        <div class="input-group input-group-sm">
            <span class="input-group-addon">药名</span>
            <input type="text" class="form-control" name="dName" placeholder="药名">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">数量</span>
            <input type="text" class="form-control" name="dNumber" placeholder="数量，库存量">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">保质期</span>
            <input type="text" class="form-control" name="shelfLife" placeholder="保质期几个月。列如36月填36">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">生产日期</span>
            <input type="date" class="form-control" name="productionDate" placeholder="生产日期">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">过期时间</span>
            <input type="date" class="form-control"  name="validUntil" placeholder="过期时间 格式2017-05-17">
        </div> 
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">进价</span>
            <input type="text" class="form-control" name="buyPrice" placeholder="进价">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">售价</span>
            <input type="text" class="form-control" name="price" placeholder="售价">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">会员折扣</span>
            <input type="text" class="form-control" name="discount" placeholder="会员折扣 例如98折填98">
        </div>
        <br>
        <div class="input-group input-group-sm">
            <span class="input-group-addon">处方药</span>
            <input type="text" class="form-control" name="prescription" placeholder="处方药填1非处方填0">
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
 <script type="text/javascript">
 $(function(){
 	var page = '${page}',sum = '${sum}';
	    var ret = showPages(page,Math.ceil(sum/20));  
	    $("#page").html(ret); 	
	});


function showPages (page, total) {  //pag当前页码，文章total总数
		var str = '<a style="color:red" href=\"listdrugs?page='+page+'\">' + page + '</a>';  
		   
     for (var i = 1; i <= 3; i++) {  
         if (page - i > 1) {  
             str = '<a  href=\"listdrugs?page='+(page-i)+'\">' + (page - i) + '</a> ' + str;  
         }  
         if (page + i < total) {  
             str = str + ' ' + '<a href=\"listdrugs?page='+(page+i)+'\">'+(page + i)+'</a>';  
         }  
     }  

      if (page - 4 > 1) {  
         str = '... ' + str;  
     }  

     if (page > 1) {  
         str = '<a href=\"listdrugs?page='+(parseInt(page)-1)+'\">上一页</a> ' + '<a href=\"listdrugs?page=1\">1 </a>'+ ' ' + str;  
     }  

    if (page + 4 < total) {  
         str = str+ ' ...';  
     }  

     if (page < total) {  
         str = str + ' ' + '<a href=\"listdrugs?page='+total+'\">'+total+'</a>' + '<a href=\"listdrugs?page='+(parseInt(page)+1)+'\"> 下一页</a>';  
     }  
     return str;
 } 
	
/* //提交药品
function tj(){
	
	
} */
 
 </script>
</body>
</html>