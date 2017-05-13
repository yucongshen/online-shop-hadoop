<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
  
  <body>
	<table id="dg" class="easyui-datagrid" >   
	    <thead>   
	        <tr>   
	            <th data-options="field:'code'" width="300%" align="center">名称</th>   
	            <th data-options="field:'pid'" width="200%" align="center">图片</th>   
	            <th data-options="field:'pname'" width="230%" align="center">价格</th>  
	            <th data-options="field:'pimage'" width="200%" align="center">数量</th>  
	            <th data-options="field:'price'" width="231%" align="center">小计</th> 
	        </tr>   
	    </thead>   
	    <tbody>   
	    	<s:iterator var="orderItem" value="model.orderItems">
				<tr>
					<td align="center">
						<a><s:property value="#orderItem.product.pname"/></a>
					</td>
					<td align="center">
						<img width="60px" height="60px" src="<%=basePath%><s:property value="#orderItem.product.image"/>"/>
					</td align="center">
					<td>
						<s:property value="#orderItem.product.shop_price"/>
					</td>
					<td align="center">
						<s:property value="#orderItem.count"/>
					</td>
					<td>
						￥<s:property value="#orderItem.subtotal"/>
					</td>
				</tr>
				<tr>	
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td colspan="5" align="right">订单总金额:<font color="red"><strong>￥<s:property value="model.total"/></strong></font></td>
				</tr>
			</s:iterator>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td colspan="5"><input type="button" onclick="history.go(-1)" value="返回"/></td>
			</tr>
	    </tbody>   
	</table>  
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
  	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
  	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js" ></script>
  	<script type="text/javascript" src="js/admin.js"></script>
  </body>
</html>
