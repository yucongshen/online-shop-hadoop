<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<script>
function checkUser(userNode)
{
	var spanNode=document.getElementById("userspan");
	if(userNode.value=="")
	{
		spanNode.innerHTML="*用户名不能为空".fontcolor("white");
		return false
	}
	else
	{
		spanNode.innerHTML="";
		return true;
	}
}
 function checkMail(mailNode)
 {
	 var mail=mailNode.value;
	 var mailreg=/^\w+@\w+(\.\w+)+$/;
	 var spanNode=document.getElementById("mailspan");
	 if((mail.match(mailreg)))
	 {
		spanNode.innerHTML="";
		return true;
	 }
	 else
	 {
		spanNode.innerHTML="*邮箱格式不正确".fontcolor("white");
		return false;
	 }
 }
 function checkForm()
 {
	 var form=document.forms[0];
	 if(checkUser(form.user)&&checkPsw(form.psw)&&checkRepsw(form.repsw)&&checkMail(form.mail)&&checkUsername())
		 return true;
	 else
		 return false;
 }
	
	function change(){
			var img1 = document.getElementById("checkImg");
			img1.src="<%=basePath%>checkImg.action?"+new Date().getTime();
		}
</script>
<title>修改个人信息</title>
<link href="css/register.css" rel="stylesheet" type="text/css"/>
<link href="css/common.css" rel="stylesheet" type="text/css"/>
<!--js-->
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/ddsmoothmenu.js"></script>
<script src="js/jquery.flexslider.js"></script>
<script src="js/jquery.elastislide.js"></script>
<script src="js/jquery.jcarousel.min.js"></script>
<script src="js/jquery.accordion.js"></script>
<script src="js/light_box.js"></script>
<script type="text/javascript">$(document).ready(function(){$(".inline").colorbox({inline:true, width:"50%"});});</script>
<!--end js-->

<!-- Mobile Specific Metas ================================================== -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS ================================================== -->

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/orange.css">
<link rel="stylesheet" href="css/skeleton.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/ddsmoothmenu.css"/>
<link rel="stylesheet" href="css/elastislide.css"/>
<link rel="stylesheet" href="css/home_flexslider.css"/>

<link rel="stylesheet" href="css/light_box.css"/>
<script src="js/html5.js"></script>

<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

</head>
<body>
	<div class="mainContainer sixteen container">
<!--Header Block-->
<%@ include file="header.jsp" %>
<!--Content Block-->
<section class="content-wrapper">
	<div class="content-container container">
		<form class="dark-matter" style="max-width: 400px;font-size: 15px;font-family:楷体; " id="registerForm" action="user_updatePersonal.action" method="post" novalidate="novalidate" onsubmit="return checkForm();">
			<h1 align="left" style="font-size: 20px;font-family: 华文行楷;">用户信息-修改
				<span></span>
			</h1>
			<input type="hidden" name="uid" value="<s:property value="model.uid"/>"/>
			<input type="hidden" name="state" value="<s:property value="model.state"/>"/>
			<input type="hidden" name="code" value="<s:property value="model.code"/>"/>
			<input type="hidden" name="password" value="<s:property value="model.password"/>"/>
			<label>
				<span>用&nbsp;户&nbsp;名 :</span>
				<input readonly="readonly" type="text" name="username" value="<s:property value="model.username"/>" onblur="checkUser(this);checkUsername()"/><span id="userspan"></span>
			</label>
			<label>
				<span>电子邮箱 :</span>
				<input type="text" readonly="readonly" name="email" id="email" value="<s:property value="model.email"/>" onblur="checkMail(this)"/><span id="mailspan"></span>
			</label>
		
			<label>
				<span>收&nbsp;货&nbsp;人 :</span>
				<input type="text" name="name" value="<s:property value="model.name"/>"/>
				<br/><br/>
			</label>
		
			<label>
				<span>收货地址 :</span>
				<input type="text" name="addr" value="<s:property value="model.addr"/>"/>
				<br/><br/>
			</label>
		
			<label>
				<span>联系电话 :</span>
				<input type="text" name="phone" value="<s:property value="model.phone"/>"/>
				<br/><br/>
			</label>
			<label>
				<span>&nbsp;</span>
				<input type="submit" class="button" value="更新"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="user_personal.action?uid=<s:property value="model.uid"/>" style="color:white;text-decoration: underline;">返回</a>
				<br/>
			</label>
  </form>
		<div class="clearfix"></div>
		<%@ include file="common.jsp" %>
	</div>
</section>
</div>
<!--Footer Block-->
<%@include file="footer.jsp" %>
</body>
</html>