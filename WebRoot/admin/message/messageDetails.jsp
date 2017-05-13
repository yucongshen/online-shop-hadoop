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
  </head>
  
  <body>
  <div align="center" style="margin: 100px;background-color: #f5fafe;">
		<table>   
		    <tr>
		    	<td height="50px">姓名：</td>
		    	<td height="50px"><s:property value="model.name"/></td>
		    </tr> 
		    <tr>
		    	<td height="50px">E-mail：</td>
		    	<td height="50px"><s:property value="model.email"/></td>
		    </tr>
		    <tr>
		    	<td height="50px">联系电话：</td>
		    	<td height="50px"><s:property value="model.phone"/></td>
		    </tr>
		    <tr>
		    	<td height="50px">主题：</td>
		    	<td height="50px"><s:property value="model.title"/></td>
		    </tr>
		    <tr>
		    	<td height="50px">内容：</td>
		    	<td height="50px"><s:property value="model.content"/></td>
		    </tr>
		    <tr>
				<td colspan="2">
					<input type="button" onclick="history.go(-1)" value="返回"/>
				</td>
			</tr>
		</table>  
	</div>
  </body>
</html>
