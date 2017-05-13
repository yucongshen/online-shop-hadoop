<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title>我的订单</title>

<!--js-->
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/ddsmoothmenu.js"></script>
<script src="js/jquery.flexslider.js"></script>
<script src="js/jquery.elastislide.js"></script>
<script src="js/jquery.jcarousel.min.js"></script>
<script src="js/jquery.accordion.js"></script>
<script src="js/light_box.js"></script>
<script type="text/javascript">$(document).ready(function(){$(".inline").colorbox({inline:true, width:"50%"});});</script>
<!--end js-->

<!-- Mobile Specific Metas ================================================== -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS ================================================== -->

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/orange.css">
<link rel="stylesheet" href="css/skeleton.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/ddsmoothmenu.css"/>
<link rel="stylesheet" href="css/elastislide.css"/>
<link rel="stylesheet" href="css/home_flexslider.css"/>
<link rel="stylesheet" href="css/light_box.css"/>
<link href="css/cart.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<script src="js/html5.js"></script>

<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

</head>
<body>
<div class="mainContainer sixteen container">
<!--Header Block-->
<%@ include file="header.jsp" %>
<!--Content Block-->
<section class="content-wrapper">
	<div class="content-container container">
		<div class="container cart">
		  <div class="span24">
			<s:if test="pageBean.list.size==0">
				<div align="center">
				<table>
					<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
					您还没有下单~
					<br/><br/><br/><br/></div><br/><br/><br/><br/><br/><br/>
					</table>
				</div>
			</s:if>
			<s:else>
				<table>
					<tbody>
						<s:iterator var="order" value="pageBean.list">
							<tr>
								<th colspan="5">
									订单编号：<s:property value="#order.orderid"/>&nbsp;&nbsp;&nbsp;&nbsp;
									订单总金额：￥<font color="red"><strong><s:property value="#order.total"/></strong></font>&nbsp;&nbsp;&nbsp;&nbsp;
									订单状态：
									<s:if test="#order.state==1">
										<a href="order_findByOid.action?orderid=<s:property value="#order.orderid"/>"><font color="red">待付款</font></a>
									</s:if>
									<s:if test="#order.state==2">
										<font color="red">待发货</font>
									</s:if>
									<s:if test="#order.state==3">
										<a href="order_updateState.action?orderid=<s:property value="#order.orderid"/>" style="color: blue;text-decoration: underline;"><font color="blue">确认收货</font></a>
									</s:if>
									<s:if test="#order.state==4">
										<font color="green">交易完成</font>
									</s:if>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="order_delete.action?orderid=<s:property value="#order.orderid"/>">
										<img src="<%=basePath%>easyui/themes/icons/delete-new.png" width="16px" height="16px">
									</a>
								</th>
							</tr>
							<tr>
								<td>商品名称</td>
								<td>图片</td>
								<td>价格</td>
								<td>数量</td>
								<td>小计</td>
							</tr>
							<s:iterator var="orderItem" value="#order.orderItems">
								<tr>				
									<td>
										<a target="_blank"><s:property value="#orderItem.product.pname"/></a>
									</td>
									<td width="60">
										<input type="hidden" name="id" value="22"/>
										<img src="<%=basePath%><s:property value="#orderItem.product.image"/>" width="60px" height="60px"/>
									</td>
									<td>
										<s:property value="#orderItem.product.shop_price"/>
									</td>
									<td class="quantity" width="60">
										<s:property value="#orderItem.count"/>
									</td>
									<td width="140">
										<span class="subtotal">￥<s:property value="#orderItem.subtotal"/></span>
									</td>
								</tr>
							</s:iterator>
						</s:iterator>
						<tr>
							<th colspan="5">
							</th>
						</tr>
					</tbody>
				</table>
				<div class="pagination">
					<span>第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页 </span>
					<s:if test="pageBean.page != 1">
						<a href="order_list.action?page=1" class="firstPage">&nbsp;</a>
						<a href="order_list.action?page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>	
					</s:if> 
					<s:iterator var="i" begin="1" end="pageBean.totalPage">
						<s:if test="pageBean.page != #i">
							<a href="order_list.action?page=<s:property value="#i"/>"><s:property value="#i"/></a>
						</s:if>
						<s:else>
							<span class="currentPage"><s:property value="#i" /></span>
						</s:else>
					</s:iterator> <s:if test="pageBean.page != pageBean.totalPage">
						<a class="nextPage"
							href="order_list.action?page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
						<a class="lastPage"
							href="order_list.action?page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
					</s:if>
				</div>
			</s:else>
		  </div>
		</div>
		<div class="clearfix"></div>
		<%@ include file="common.jsp" %>
	</div>
</section>
</div>
<!--Footer Block-->
<%@include file="footer.jsp" %>
</body>
</html>