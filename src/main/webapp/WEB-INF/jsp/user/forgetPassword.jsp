<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0064)http://www.17sucai.com/preview/137615/2015-01-15/demo/index.html -->
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<HTML>

<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<TITLE>登录页面</TITLE>
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/user/index.js"></script>
<link rel="stylesheet" href="<%=path%>/css/user/index.css">
<script>
	$(function(){${request}})
</script>
<META name="GENERATOR">
</HEAD>
<BODY>
<form action="<%=path %>/user/forgetOver" class="indexForm" method="post">
<input class='uName' name='uName' type="hidden" value="${uName }"/>
<input class='question' name='question' type='hidden' value="${question }"/>
<DIV class="top_div"></DIV>
<DIV style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">
    <DIV style="width: 165px;  position: absolute;">
        <DIV class="tou"></DIV>
        <DIV class="initial_left_hand" id="left_hand"></DIV>
        <DIV class="initial_right_hand" id="right_hand"></DIV>
    </DIV>
    <P style="padding: 30px 0px 10px; position: relative;">
    	<center><H2>问题：${question }</H2></center>
    </P>
    <P style="position: relative;" class="pwdP">
        <SPAN class="p_logo"></SPAN>
        <INPUT onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;" class="ipt" name="answer" title="答案" id="password" type="text" placeholder="请输入你的答案">
    </P>
     
    <DIV style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
        <P style="margin: 0px 35px 20px 45px;"><SPAN style="float: left;">
        	<A style="color: rgb(204, 204, 204);" href="javascript :;" onClick="javascript :history.back(-1);">返回</A></SPAN>
            <SPAN style="float: right;">
            	<a class="changeSubmit" style="color: rgb(204, 204, 204); margin-right: 10px;"
                                           href="<%=path%>/user/index">去登录</a>
              <input type="submit" class="submit" style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;"
                 value="提交"></input>
           </SPAN>
        </P>
    </DIV>
</DIV>
</form>
</BODY>
</HTML>
