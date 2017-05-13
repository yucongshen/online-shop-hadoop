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
		spanNode.innerHTML="*密码必须为五位".fontcolor("white");
		return false;
	}
} 
 function checkRepsw()
 {
	 var spanNode=document.getElementById("repswspan");
	 if(document.getElementById("password").value!=document.getElementById("repswId").value)
	 {
		 
		 spanNode.innerHTML="*密码不一致".fontcolor("white");
		 return false;
	 }
	 else{
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
	 var form=document.getElementById("registerForm");
	 if(checkUser(form.user)&&checkPsw(form.psw)&&checkRepsw(form.repsw)&&checkMail(form.mail)&&checkUsername()&&checkEMailName())
		 return true;
	 else
		 return false;
 }
 function checkUsername(){
		// 获得文件框值:
		var username = document.getElementById("username").value;
		// 1.创建异步交互对象
		var xhr = createXmlHttp();
		// 2.设置监听
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					document.getElementById("span1").innerHTML = xhr.responseText;
				}
			}
		}
		// 3.打开连接
		xhr.open("GET","${pageContext.request.contextPath}/user_findByName.action?time="+new Date().getTime()+"&username="+username,true);
		// 4.发送
		xhr.send(null);
	}
 function checkEMailName(){
		// 获得文件框值:
		var email = document.getElementById("email").value;
		// 1.创建异步交互对象
		var xhr = createXmlHttp();
		// 2.设置监听
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					document.getElementById("spanmail").innerHTML = xhr.responseText;
				}
			}
		}
		// 3.打开连接
		xhr.open("GET","${pageContext.request.contextPath}/user_findByEMail.action?time="+new Date().getTime()+"&email="+email,true);
		// 4.发送
		xhr.send(null);
	}
	function createXmlHttp(){
		   var xmlHttp;
		   try{ // Firefox, Opera 8.0+, Safari
		        xmlHttp=new XMLHttpRequest();
		    }
		    catch (e){
			   try{// Internet Explorer
			         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			      }
			    catch (e){
			      try{
			         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			      }
			      catch (e){}
			      }
		    }

			return xmlHttp;
		 }
	
	
	function change(){
			var img1 = document.getElementById("checkImg");
			img1.src="<%=basePath%>checkImg.action?"+new Date().getTime();
		}
</script>
<title>新用户注册</title>
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
		<form class="dark-matter" id="registerForm" action="user_regist.action" method="post" novalidate="novalidate" onsubmit="return checkForm();">
			<h1 align="left" style="font-size: 20px;font-family: 华文行楷;">用户注册
				<span></span>
			</h1>
			<label>
				<span>用&nbsp;&nbsp;户&nbsp;&nbsp;名 :</span>
				<input id="username" type="text" name="username" placeholder="" onblur="checkUser(this);checkUsername()"/><span id="userspan"></span>
				<span id="span1"></span>
				<span class="error"><s:fielderror fieldName="username"/></span>
			</label>
		
			<label>
				<span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 :</span>
				<input id="password" type="password" name="pass" placeholder="" onblur="checkPsw(this)"/><span id="pswspan"></span>
				<span class="error"><s:fielderror fieldName="password"/></span>
			</label>
		
			<label>
				<span>确认密码 :</span>
				<input type="password" id="repswId" name="repassword" placeholder="" onblur="checkRepsw()"/><span id="repswspan"></span>
			</label>
		
			<label>
				<span>电子邮箱 :</span>
				<input type="text" id="email" name="email" placeholder="" onblur="checkMail(this);checkEMailName()"/><span id="mailspan"></span>
				<span id="spanmail"></span>
				<span class="error"><s:fielderror fieldName="email"/></span>
			</label>
		
			<label>
				<span>收&nbsp;&nbsp;货&nbsp;&nbsp;人 :</span>
				<input type="text" name="realname" placeholder=""/>
				<span class="error"><s:fielderror fieldName="name"/></span>
			</label>
		
			<label>
				<span>收货地址 :</span>
				<input type="text" name="addr" placeholder="" />
			</label>
		
			<label>
				<span>联系电话:</span>
				<input type="text" name="phone" placeholder="" />
			</label>
		
			<label>
				<span>验&nbsp;&nbsp;证&nbsp;&nbsp;码 :</span>
				<input type="text" id="checkcode" name="checkcode" placeholder=""/>
				<img id="checkImg" class="captchaImage" src="<%=basePath%>checkImg.action" onclick="change()" title="点击更换验证码"/>
				<div class="error"><s:actionerror/></div>
			</label>
		
			<label>
				<span>&nbsp;</span>
				<input type="submit" class="button" value="注册" />
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