<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
    
    <title>后台首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="css/admin.css" />
  </head>
  
  <body class="easyui-layout">
<!--  
<div data-options="region:'north',title:'header',split:true,noheader:true" style="height:60px;">
	<div class="logo">后台管理</div>
	<div>您好，<font color="blue"><s:property value="#session.exitAdminUser.username"/></font> | <a href="adminUser_logout">退出</a></div>
</div> 
-->  
<div data-options="region:'south',title:'footer',split:true,noheader:true" style="height:35px;line-height:30px;text-align:center;">
	&copy;2015-2016 happy购~. Powered by EasyUI.
</div>    
<div data-options="region:'west',title:'导航',split:true,iconCls:'icon-world'" style="width:180px;padding:10px;">
	<ul id="tree"></ul>
</div>   
<div data-options="region:'center'" style="overflow:hidden;">
	<div class="easyui-tabs" fit="true" border="false" id="tabs">
		<div align="center" title="主页" style="padding:150px;display:block;font-family:楷体;font-size: 30px;" iconCls="icon-house">
			<div><font color="#0099FF" face="楷体"><s:property value="#session.exitAdminUser.username"/></font>，您好，欢迎来到&nbsp;&nbsp;<font color="orange" face="Calibri">happy购~</font>&nbsp;&nbsp;后台管理系统！</div>
			<div align="center" style="margin-top: 280px;"><a href="adminUser_logout" style="font-size: 20;color: #0099FF;text-decoration: underline;">退出登录</a></div>
		</div>
	</div>
</div> 
<div id="tabsMenu" class="easyui-menu" style="width:120px;">  
    <div name="close">关闭</div>  
    <div name="Other">关闭其他</div>  
    <div name="All">关闭所有</div>
  </div>  


<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" src="js/admin.js"></script>
</body>
</html>
