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
	<table class="easyui-datagrid">   
	    <thead>   
	        <tr>   
	            <th data-options="field:'code'" width="80%" align="center">序号</th>   
	            <th data-options="field:'pid'" width="80%" align="center">商品编号</th>   
	            <th data-options="field:'pname'" width="300%" align="center">商品名称</th>  
	            <th data-options="field:'pimage'" width="80%" align="center">商品图片</th>  
	            <th data-options="field:'price'" width="100%" align="center">商品价格</th> 
	            <th data-options="field:'is_hot'" width="80%" align="center">是否热门</th> 
	            <th data-options="field:'time'" width="160%" align="center">上架日期</th> 
	            <th data-options="field:'category'" width="100%" align="center">所属分类</th> 
	            <th data-options="field:'edit'" width="80%" align="center">编辑</th> 
	            <th data-options="field:'delete'" width="80%" align="center">删除</th>   
	        </tr>   
	    </thead>   
	    <tbody>   
	    	<s:iterator var="p" value="pageBeanProduct.list" status="status">
		        <tr>   
		            <td><s:property value="#status.count"/></td> 
		            <td><s:property value="#p.pid"/></td> 
		            <td><s:property value="#p.pname"/></td> 
		            <td><img width="40" height="45" src="<s:property value="#p.image"/>"></img></td> 
		            <td><s:property value="#p.shop_price"/></td>
		            <td>
		            	<s:if test="#p.is_hot==1">是</s:if>
						<s:else>否</s:else>
		            </td>
		            <td><s:property value="#p.pdate"/></td>
		            <td><s:property value="#p.secondCategory.csname"/></td>
		            <td>
		            	<a href="productManage_edit.action?pid=<s:property value="#p.pid"/>">
							<img src="<%=basePath%>easyui/themes/icons/edit-new.png">
						</a>
					</td>  
					<td align="center" style="HEIGHT: 22px">
						<a href="productManage_delete.action?pid=<s:property value="#p.pid"/>">
							<img src="<%=basePath%>easyui/themes/icons/delete-new.png">
						</a>
					</td>
		        </tr>    
	        </s:iterator>
	    </tbody>   
	</table>  
	<div class="pagination" align="right" style="margin-right: 20px;">
		<span>第<s:property value="pageBeanProduct.page" />/<s:property value="pageBeanProduct.totalPage" />页 </span>
		<s:iterator var="i" begin="1" end="pageBeanProduct.totalPage">
			<s:if test="pageBeanProduct.page != #i">
				<a href="productManage_list.action?page=<s:property value="#i"/>">
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
