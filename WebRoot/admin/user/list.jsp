<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title></title>
	<base href="<%=basePath%>">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="css/admin.css" />
	<link href="css/Style1.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="<%=basePath%>/js/public.js"></script>
  </head>
  
  <body style="margin-top: 20px;">
	<table class="easyui-datagrid">   
	    <thead>   
	        <tr>   
	            <th data-options="field:'status'" width="233%" align="center" >序号</th>   
	            <th data-options="field:'username'" width="238%" align="center">用户名</th>   
	            <th data-options="field:'password'" width="238%" align="center">密码</th>  
	            <th data-options="field:'state'" width="226%" align="center">是否被激活</th>  
	            <th data-options="field:'delete'" width="226%" align="center">删除</th>   
	        </tr>   
	    </thead>   
	    <tbody>   
	    	<s:iterator var="u" value="pageBeanUser.list" status="status">
		        <tr>   
		            <td><s:property value="#status.count"/></td> 
		            <td><s:property value="#u.username"/></td> 
		            <td><s:property value="#u.password"/></td> 
		            <td>
		            	<s:if test="#u.state==1">是</s:if>
		            	<s:if test="#u.state==0">否</s:if>
		            </td> 
		            <td>
		            	<a href="userManage_delete.action?uid=<s:property value="#u.uid"/>">
							<img src="<%=basePath%>easyui/themes/icons/delete-new.png">
						</a>
					</td>  
		        </tr>    
	        </s:iterator>
	    </tbody>   
	</table>  
	<div class="pagination" align="right" style="margin-right: 20px;">
		<span>第<s:property value="pageBeanUser.page" />/<s:property value="pageBeanUser.totalPage" />页 </span>
		 <s:iterator var="i" begin="1" end="pageBeanUser.totalPage">
			<s:if test="pageBeanUser.page != #i">
				<a href="userManage_findAll.action?page=<s:property value="#i"/>">
					<s:property value="#i" />	
				</a>
			</s:if>
			<s:else>
				<span class="currentPage"><s:property value="#i" /></span>
			</s:else>
		</s:iterator> 
		</div>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
  	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
  	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js" ></script>
  	<script type="text/javascript" src="js/admin.js"></script>
  </body>
</html>
