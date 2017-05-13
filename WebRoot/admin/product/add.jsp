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
  <div align="center" style="background-color: #f5fafe;margin-top: 20px;">
	  <form action="productManage_save.action" method="post" enctype="multipart/form-data">
		<table>   
		    <tr>
		    	<td height="50px">商品名称：</td>
		    	<td height="50px"><input type="text" name="pname"/></td>
		    </tr> 
		    <tr>
		    	<td height="50px">市场价格：</td>
		    	<td height="50px"><input type="text" name="market_price"/></td>
		    </tr> 
		    <tr>
		    	<td height="50px">happpy购~价格：</td>
		    	<td height="50px"><input type="text" name="shop_price"/></td>
		    </tr> 
		    <tr>
		    	<td height="50px">是否热销：</td>
		    	<td height="50px">
		    		<select name="is_hot">
						<option value="1">是</option>
						<option value="0">否</option>
					</select>
		    	</td>
		    </tr> 
		    <tr>
		    	<td height="50px">所属的分类：</td>
		    	<td height="50px">
		    		<select name="secondCategory.csid">
						<s:iterator var="cs" value="csList">
							<option value="<s:property value="#cs.csid"/>"><s:property value="#cs.csname"/></option>
						</s:iterator>
					</select>
		    	</td>
		    </tr> 
		    <tr>
		    	<td height="50px">上传商品图片：</td>
		    	<td height="50px"><input type="file" name="pimage"/></td>
		    </tr> 
		    <tr>
		    	<td height="50px">商品描述：</td>
		    	<td height="50px"><input type="text" name="pdesc"/></td>
		    </tr>
		    <tr>
				<td colspan="2">
					<input type="submit" value="添加"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置"/>
				</td>
			</tr>
		</table>  
	  </form>
	</div>
  </body>
</html>
