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
  <div align="center" style="background-color: #f5fafe;">
	  <form action="productManage_update.action" method="post" enctype="multipart/form-data">
	  	<input type="hidden" name="pid" value="<s:property value="model.pid"/>"/>
		<input type="hidden" name="image" value="<s:property value="model.image"/>"/>
		<table>   
		    <tr>
		    	<td height="50px">商品名称：</td>
		    	<td height="50px"><input type="text" name="pname" value="<s:property value="model.pname"/>"/></td>
		    </tr> 
		    <tr>
		    	<td height="50px">市场价格：</td>
		    	<td height="50px"><input type="text" name="market_price" value="<s:property value="model.market_price"/>"/></td>
		    </tr> 
		    <tr>
		    	<td height="50px">happpy购~价格：</td>
		    	<td height="50px"><input type="text" name="shop_price" value="<s:property value="model.shop_price"/>"/></td>
		    </tr> 
		    <tr>
		    	<td height="50px">是否热销：</td>
		    	<td height="50px">
		    		<select name="is_hot">
						<option value="1" <s:if test="model.is_hot==1">selected</s:if>>是</option>
						<option value="0" <s:if test="model.is_hot==0">selected</s:if>>否</option>
					</select>
		    	</td>
		    </tr> 
		    <tr>
		    	<td height="50px">所属的分类：</td>
		    	<td height="50px">
		    		<select name="secondCategory.csid">
						<s:iterator var="cs" value="csList">
							<option value="<s:property value="#cs.csid"/>" <s:if test="#cs.csid==model.secondCategory.csid">selected</s:if>><s:property value="#cs.csname"/></option>
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
		    	<td height="50px"><textarea rows="6" cols="26" name="pdesc"><s:property value="model.pdesc"/></textarea></td>
		    </tr>
		    <tr>
				<td colspan="2">
					<input type="submit" value="更新"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
