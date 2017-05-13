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
	<table class="easyui-datagrid" style="margin-top: 200px;">   
	    <thead>   
	        <tr>   
	            <th data-options="field:'code'" width="290%" align="center">序号</th>   
	            <th data-options="field:'pid'" width="292%" align="center">一级分类名称</th>    
	            <th data-options="field:'edit'" width="290%" align="center">修改</th> 
	            <th data-options="field:'delete'" width="290%" align="center">删除</th>   
	        </tr>   
	    </thead>   
	    <tbody>   
	    	<s:iterator var="c" value="pageBeanCategory.list" status="status">
		        <tr>   
		            <td><s:property value="#status.count"/></td> 
		            <td><s:property value="#c.cname"/></td> 
					<td>
						<a href="firstCategoryManage_edit.action?cid=<s:property value="#c.cid"/>">
							<img src="<%=basePath%>easyui/themes/icons/edit-new.png">
						</a>
					</td>
			
					<td>
						<a href="firstCategoryManage_delete.action?cid=<s:property value="#c.cid"/>">
							<img src="<%=basePath%>easyui/themes/icons/delete-new.png">
						</a>
					</td>
		        </tr>    
	        </s:iterator>
	    </tbody>   
	</table>  
	<div class="pagination" align="right" style="margin-right: 20px;">
		<span>第<s:property value="pageBeanCategory.page" />/<s:property value="pageBeanCategory.totalPage" />页 </span>
		 <s:iterator var="i" begin="1" end="pageBeanCategory.totalPage">
			<s:if test="pageBeanCategory.page != #i">
				<a href="firstCategoryManage_list.action?page=<s:property value="#i"/>">
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
