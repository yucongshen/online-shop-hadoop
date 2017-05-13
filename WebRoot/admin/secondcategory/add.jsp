<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
	  <form action="secondCategoryManage_save.action" method="post">
		<table>   
		    <tr>
		    	<td height="50px">分类名称：</td>
		    	<td height="50px"><input type="text" name="csname"/></td>
		    </tr> 
		    <tr>
		    	<td height="50px">所属一级分类：</td>
		    	<td height="50px">
		    		<select name="firstCategory.cid">
						<s:iterator var="c" value="cList">
							<option value="<s:property value="#c.cid"/>"><s:property value="#c.cname"/></option>
						</s:iterator>
					</select>
		    	</td>
		    </tr>
		    <tr>
				<td colspan="2">
					<input type="submit" value="添加"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
