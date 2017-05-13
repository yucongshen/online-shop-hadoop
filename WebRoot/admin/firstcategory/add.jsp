<%@ page language="java" pageEncoding="UTF-8"%>
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
	  <form action="firstCategoryManage_save.action" method="post">
		<table>   
		    <tr>
		    	<td height="50px">分类名称：</td>
		    	<td height="50px"><input type="text" name="cname"/></td>
		    </tr> 
		    <tr>
				<td colspan="2">
					<input type="submit" value="添加"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;
					<input type="reset" value="重置"/>
				</td>
			</tr>
		</table>  
	  </form>
	</div>
  </body>
</html>
