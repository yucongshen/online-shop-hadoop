<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>后台登录</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
</head>
<body>


<div id="login">
	<center><s:actionerror /></center>
	<form id="box" method="post" action="adminUser_login.action">
	<p>管理员帐号：<input type="text"  id="manager" name="username" class="easyui-validatebox" data-options="required:true"></p>
	<p>管理员密码：<input type="password"  id="pass" name="pass" class="easyui-validatebox" data-options="required:true"></p>
	<div id="btn"><input type="submit" value="登录"></div>
</form>
</div>

<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>