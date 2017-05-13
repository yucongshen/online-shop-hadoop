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
  
  <body>
	<table class="easyui-datagrid" >   
	    <thead>   
	        <tr>   
	            <th data-options="field:'code'" width="80%" align="center">序号</th>   
	            <th data-options="field:'pid'" width="162%" align="center">订单编号</th>   
	            <th data-options="field:'pname'" width="88%%" align="center">订单总金额</th>  
	            <th data-options="field:'pimage'" width="150%" align="center">订单生成时间</th>  
	            <th data-options="field:'price'" width="100%" align="center">收货人</th> 
	            <th data-options="field:'is_hot'" width="237%" align="center">收货地址</th> 
	            <th data-options="field:'time'" width="160%" align="center">联系电话</th> 
	            <th data-options="field:'category'" width="100%" align="center">订单所属用户</th> 
	            <th data-options="field:'edit'" width="80%" align="center">订单状态</th>    
	            
	        </tr>   
	    </thead>   
	    <tbody>   
	    	<s:iterator var="o" value="pageBeanOrder.list" status="status">
		        <tr>   
		            <td><s:property value="#status.count"/></td> 
		            <td>
		            	<a href="orderManage_findOrderByOid.action?orderid=<s:property value="#o.orderid"/>" style="color: blue;text-decoration: underline;"><s:property value="#o.orderid"/></a>
		            </td> 
		            <td><s:property value="#o.total"/></td> 
		            <td><s:property value="#o.ordertime"/></img></td> 
		            <td><s:property value="#o.realname"/></td>
		            <td><s:property value="#o.addr"/></td>
		            <td><s:property value="#o.phone"/></td>
		            <td><s:property value="#o.user.username"/></td>
		            <td>
		            <s:if test="#o.state==1">未付款</s:if>
						<s:if test="#o.state==2"><a href="orderManage_updateState.action?oid=<s:property value="#o.oid"/>" style="color: blue;text-decoration: underline;">发货</a></s:if>
						<s:if test="#o.state==3"><font color="red">未确认收货</font></s:if>
						<s:if test="#o.state==4"><font color="green">交易完成</font></s:if>
					</td>
		        </tr>    
	        </s:iterator>
	    </tbody>   
	</table>  
	<div class="pagination" align="right" style="margin-right: 20px;">
		<span>第<s:property value="pageBeanOrder.page" />/<s:property value="pageBeanOrder.totalPage" />页 </span>
		 <s:iterator var="i" begin="1" end="pageBeanOrder.totalPage">
			<s:if test="pageBeanOrder.page != #i">
				<a href="orderManage_findOrderList.action?page=<s:property value="#i"/>">
					<font color="blue" size="2"><s:property value="#i"/></font>
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
