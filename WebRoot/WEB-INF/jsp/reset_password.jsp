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
<title>密码重置</title>
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
<script type="text/javascript">
function checkPsw(pswNode)
{
	var pass=pswNode.value; 
	var passreg=/^\d{5}$/;
	var spanNode=document.getElementById("pswspan");
	if((pass.match(passreg)))
	{
		spanNode.innerHTML="";
		return true;
	}
	else
	{
		spanNode.innerHTML="*密码必须为五位".fontcolor("red");
		return false;
	}
} 
function checkRepsw()
{
	 var spanNode=document.getElementById("repswspan");
	 if(document.getElementById("newPassword").value!=document.getElementById("repnewPassword").value)
	 {
		 
		 spanNode.innerHTML="*密码不一致".fontcolor("red");
		 return false;
	 }
	 else{
		 spanNode.innerHTML="";
		 return true;
	 }
}
</script>
</head>
<body>
	<div class="mainContainer sixteen container">
<!--Header Block-->
<%@ include file="header.jsp" %>
<!--Content Block-->
<section class="content-wrapper">
	<div class="content-container container">
		<form class="dark-matter" style="max-width: 400px;font-size: 15px;font-family:楷体; " id="registerForm" action="user_reset.action" method="post" novalidate="novalidate" onsubmit="return checkForm();">
			<h1 align="left" style="font-size: 20px;font-family: 华文行楷;">用户密码-重置
				<span></span>
			</h1>
			<input type="hidden" name="uid" value="<s:property value="model.uid"/>"/>
			<input type="hidden" name="username" value="<s:property value="model.username"/>"/>
			<input type="hidden" name="password" value="<s:property value="model.password"/>"/>
			<input type="hidden" name="state" value="<s:property value="model.state"/>"/>
			<input type="hidden" name="name" value="<s:property value="model.name"/>"/>
			<input type="hidden" name="addr" value="<s:property value="model.addr"/>"/>
			<input type="hidden" name="email" value="<s:property value="model.email"/>"/>
			<input type="hidden" name="phone" value="<s:property value="model.phone"/>"/>
			<label>
				<span>新&nbsp;密&nbsp;码 :</span>
				<input type="password" name="newPassword" onblur="checkPsw(this)"/>
				<br/><br/>
			</label>
			<label>
				<span>确认密码 :</span>
				<input type="password" name="renewPassword"/><span id="repswspan" onblur="checkRepsw()"></span>
				<br/><br/>
			</label>
			<label>
				<span>&nbsp;</span>
				<input type="submit" class="button" value="确定"/>
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