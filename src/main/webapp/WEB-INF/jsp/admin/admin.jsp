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
	    <li><a href="<%=path %>/admin/index">药品管理后台</a></li>
	    <li  class="active">用户管理</li>
	    <li ><a href="<%=path%>/admin/listdrugs?page=1">药品管理</a></li>
	    <li ><a href="#" onclick="fwq()">用户分布</a></li>
	    <li style="float: right;"><a href="<%=path%>/logout">注销</a></li>
	    <li style="float: right;"><a href="<%=path%>/admin/myme">个人信息</a></li>
	</ol>
 
<!--  用户列表 -->
<div class="container" id="d1" style=" padding-top: 5%">

		    	会员信息,冻结信息表示用户正常，0表示用户已冻结不能登录
	<table id="myuser" data-toggle="table" data-url="" data-height=""
		data-click-to-select="true" data-method="get"
		data-query-params="queryParams" data-toolbar="#toolbar"
		data-pagination="true" data-search="true" data-show-refresh="true"
		data-show-toggle="true" data-show-columns="true" data-page-size="5">
	</table>

</div>
 
	             <iframe id="mainFrame" name="mainFrame" scrolling="no" src=""
                  frameborder="0" style="padding: 0px; width: 100%; "></iframe>
 </div>
 
 <div style="text-align:center;">
        <p>药品管理系统</p>
  </div>
 
 
 <script type="text/javascript">
 $(function(){
	   startInit('mainFrame', 560);
 });
  
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
							field : 'nickName',
							title : '昵称'
						},
						{
							title : '是否冻结',
							field : 'temp',
							align : 'center',
							formatter : function(value, row, index) {
								var  temp = "";
								if(row.isFreezing=="1"){
									temp="正常";
								}else{
									temp="冻结";
								}
								return temp;
							}
						} ,
						{
							title : '冻结截止时间',
							field : 'temp',
							align : 'center',
							formatter : function(value, row, index) {
								var  temp = "";
								if(row.isFreezing=="1"){
									temp="";
								}else{
									temp=row.freezingTime;
								}
								return temp;
							}
						} ,
						{
							title : '操作',
							field : 'temp',
							align : 'center',
							formatter : function(value, row, index) {
								var  temp = '<a href="#" mce_href="#" onclick="sc(\'' + row.uID + '\')">删除</a> '; 
								 temp += '&nbsp;<a href="#" mce_href="#" onclick="ck(\'' + row.uID + '\')">查看订单</a> '; 
								 temp += '&nbsp;<a href="#" mce_href="#" onclick="dj(\'' + row.uID + '\')">冻结</a> '; 
								 temp += '&nbsp;<a href="#" mce_href="#" onclick="jd(\'' + row.uID + '\')">解冻</a> '; 
								return temp;
							}
						} ]
			});
	
	function sc(id){
		window.location.href="<%=path%>/admin/sc?id="+id;
	}
	function ck(id){
		window.location.href="<%=path%>/admin/ck?id="+id;
	}
	function dj(id){
		window.location.href="<%=path%>/admin/dj?id="+id;
	}
	function jd(id){
		window.location.href="<%=path%>/admin/jd?id="+id;
	}
	
	   var browserVersion = window.navigator.userAgent.toUpperCase();
	   var isOpera = false, isFireFox = false, isChrome = false, isSafari = false, isIE = false;
	   var maxHeight = 0;
	    function reinitIframe(iframeId, minHeight) {
	       try {
	         var iframe = document.getElementById(iframeId);
	          var bHeight = 0;
	          if (isChrome === false && isSafari === false)
	               bHeight = iframe.contentWindow.document.body.scrollHeight;
	           var dHeight = 0;
	           if (isFireFox === true)
	               dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
	           else if (isIE === false && isOpera === false)
	               dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
	           else if (isIE === true && !-[1, ] === false) {
	           } //ie9+
	           else
	              bHeight += 3;
	           var height = Math.max(bHeight, dHeight);
	           if (height < minHeight){
	               height = minHeight;
	           }
	               
	           iframe.style.minHeight = height + "px";
	       } catch (ex) {
	       }
	   }
	   function startInit(iframeId, maxHeight) {
	       isOpera = browserVersion.indexOf("OPERA") > -1 ? true : false;
	       isFireFox = browserVersion.indexOf("FIREFOX") > -1 ? true : false;
	      isChrome = browserVersion.indexOf("CHROME") > -1 ? true : false;
	       isSafari = browserVersion.indexOf("SAFARI") > -1 ? true : false;
	      if (!!window.ActiveXObject || "ActiveXObject" in window)
	           isIE = true;
	       window.setInterval("reinitIframe('" + iframeId + "'," + maxHeight + ")", 100);
	   }

	   function iFrameHeight() {
	          var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;   
	          if(ifm != null && subWeb != null) {
	             ifm.height = subWeb.body.scrollHeight;
	             ifm.width = subWeb.body.scrollWidth;
	           }   
	   }   
		

		
		function fwq(){
			 $("#d1").hide();
			 $('#mainFrame').attr("src","<%=path%>/admin/list");  
		}
	
	 </script>	
</body>
</html>