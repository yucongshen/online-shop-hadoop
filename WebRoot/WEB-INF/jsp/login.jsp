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
<title>用户登录</title>

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
		<div class="main">
			<div class="account-login">
				<div class="col-1 new-users">
					<div class="content" style="background-image: url('images/bg.jpg');">
					</div>
				</div>
				<div class="col-2 registered-users">
					<div class="content">
						<h2>用户登录</h2>
						<p>If you have an account with us, please log in.</p>
						<div style="color: red;"><s:actionerror/></div>
						<form id="loginForm" action="user_login.action" method="post" novalidate="novalidate">
							<ul class="form-list">
								<li>
									<label class="required" for="email">用户名<em>*</em></label>
									<div class="input-box">
										<input type="text" id="username" name="username" title="Email Address" class="input-text required-entry validate-email" value="" />
									</div>
									<div class="clear"></div>
								</li>
								<li>
									<label class="required" for="pass">密码<em>*</em></label>
									<div class="input-box">
										<input type="password" id="pass" name="pass" title="Password" class="input-text required-entry validate-password" />
									</div>
									<div class="clear"></div>
								</li>
								<li>
									<!--  <a class="orange-btn"  title="Login" ><span><span>登录</span></span></a>-->
									<input type="submit" class="orange-btn" value="登 录">
								</li>
							</ul>
						</form>
					</div>
					<div class="buttons-set">
						<a class="f-left" href="user_verifyPage.action">忘记密码？</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="f-left" href="user_registPage.action">新用户注册</a>
						<div class="clear"></div>
					</div>
            	</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="clearfix"></div>
		<%@ include file="common.jsp" %>
	</div>
</section>
</div>
	<%@include file="footer.jsp" %>
</body>
</html>