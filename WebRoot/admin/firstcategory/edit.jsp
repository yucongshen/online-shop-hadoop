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
	  <form action="firstCategoryManage_update.action" method="post">
	  <input type="hidden" name="cid" value="<s:property value="model.cid"/>"/>
		<table>   
		    <tr>
		    	<td height="50px">分类名称：</td>
		    	<td height="50px"><input type="text" name="cname" value="<s:property value="model.cname"/>"/></td>
		    </tr> 
		    <tr>
				<td colspan="2">
					<input type="submit" value="更新"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;
					<input type="button" onclick="history.go(-1)" value="返回"/>
				</td>
			</tr>
		</table>  
	  </form>
	</div>
  </body>
</html>
