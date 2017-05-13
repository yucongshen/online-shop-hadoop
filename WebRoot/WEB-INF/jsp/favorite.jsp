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
<title>收藏夹</title>

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
	<s:if test="pageBeanFavorite.list.size()!=0">
		<div class="span24">
			<div class="step step1">
			</div>
				<table>
					<tr>
						<th>商品名称</th>
						<th>图片</th>
						<th>价格</th>
						<th>删除</th>
					</tr>
					<s:iterator var="f" value="pageBeanFavorite.list">
						<tr>
							<td align="center">
								<a href="product_findByPid.action?pid=<s:property value="#f.product.pid"/>" style="text-decoration: underline;">
									<s:property value="#f.product.pname"/>
								</a>
							</td>
							<td width="60">
								<img src="<s:property value="#f.product.image"/>" width="60px" height="60px">
							</td>
							<td align="center">
								￥<s:property value="#f.product.shop_price"/>
							</td>
							<td align="center">
								<a href="favorite_delete.action?pid=<s:property value="#f.product.pid"/>">
									<img src="<%=basePath%>easyui/themes/icons/delete-new.png" width="16px" height="16px">
								</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
				</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="bottom">
					<a href="favorite_clear.action">清空收藏夹</a>	
				</div>
				<div class="pagination">
						<span>第<s:property value="pageBeanFavorite.page"/>/<s:property value="pageBeanFavorite.totalPage"/>页 </span>
						<s:if test="pageBeanFavorite.page != 1">
							<a href="favorite_list.action?page=1" class="firstPage">&nbsp;</a>
							<a href="favorite_list.action?page=<s:property value="pageBeanFavorite.page-1"/>" class="previousPage">&nbsp;</a>	
						</s:if> 
						<s:iterator var="i" begin="1" end="pageBeanFavorite.totalPage">
							<s:if test="pageBeanFavorite.page != #i">
								<a href="favorite_list.action?page=<s:property value="#i"/>"><s:property value="#i"/></a>
							</s:if>
							<s:else>
								<span class="currentPage"><s:property value="#i" /></span>
							</s:else>
						</s:iterator> <s:if test="pageBeanFavorite.page != pageBeanFavorite.totalPage">
							<a class="nextPage"
								href="favorite_list.action?page=<s:property value="pageBeanFavorite.page+1"/>">&nbsp;</a>
							<a class="lastPage"
								href="favorite_list.action?page=<s:property value="pageBeanFavorite.totalPage"/>">&nbsp;</a>
						</s:if>
					</div>
		</div>
		</s:if>
		<s:else>
			<div class="span24">
				<div align="center">
				<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
				您的收藏夹还是空的！
				<br/><br/><br/><br/></div><br/><br/><br/><br/><br/><br/>
			</div>
		</s:else>
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