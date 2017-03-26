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
<TITLE>修改详细信息</TITLE>
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/user/index.js"></script>
<link rel="stylesheet" href="<%=path%>/css/user/index.css">
<script>
	$(function(){
		if(${sessionScope.user eq  null }){
			alert("你还没登录呢！");
			window.location.href="<%=path%>/user/index";
		}
		${request}})
	
</script>
<META name="GENERATOR">
</HEAD>
<BODY>
<form action="<%=path %>/user/updateUser" class="indexForm" method="post">
<input type="hidden" name="Token" value =""/>
<DIV class="top_div"></DIV>
<DIV style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; text-align: center;">
    <DIV style="width: 165px; height: 96px; position: absolute;">
        <DIV class="tou"></DIV>
        <DIV class="initial_left_hand" id="left_hand"></DIV>
        <DIV class="initial_right_hand" id="right_hand"></DIV>
    </DIV>
    <P style="padding: 30px 0px 10px; position: relative;"><SPAN
            class="u_logo"></SPAN> <INPUT onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;" class="ipt uName" title="帐号" name="uName" type="text" readonly placeholder="请输入用户名或邮箱" value="${sessionScope.user.uName}">
    </P>
    <P style="position: relative;padding: 0px 0px 10px" >
        <SPAN class="p_logo"></SPAN>
        <INPUT onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;" class="ipt" name="uPwd" title="密码" id="password" type="password" placeholder="请输入密码" value="">
    </P>
    <P style="position: relative;padding: 0px 0px 10px" >
        <SPAN class="p_logo"></SPAN>
        <INPUT class="ipt" name="uPhone" title="电话号码" type="text" placeholder="请输入电话号码" value="${sessionScope.user.uPhone}">
    </P>
    <P style="position: relative;padding: 0px 0px 10px" >
        <SPAN class="p_logo"></SPAN>
        <INPUT class="ipt" name="question" title="问题" type="text" placeholder="请输入找回密码的问题" value="${sessionScope.user.question}">
    </P>
    <P style="position: relative;padding: 0px 0px 10px" >
        <SPAN class="p_logo"></SPAN>
        <INPUT class="ipt" name="answer" title="答案" type="text" placeholder="请输入找回密码的答案" value="${sessionScope.user.answer}">
    </P>
    <P style="position: relative;padding: 0px 0px 10px" >
        <SPAN class="p_logo"></SPAN>
        <INPUT class="ipt" name="nickName" title="姓名" type="text" placeholder="真实姓名" value="${sessionScope.user.nickName}">
    </P>
     
    <DIV style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
        <P style="margin: 0px 35px 20px 45px;">
        <SPAN style="float: left;">
        <A class="forget" style="color: rgb(204, 204, 204);" href="#">忘记密码?</A>
        </SPAN>
        <SPAN style="float: right;">
              <input type="submit" class="submit" style="margin-top:10px;background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;"
                value="修改"></input>
           </SPAN>
        </P>
    </DIV>
</DIV>
</form>
</BODY>
</HTML>
