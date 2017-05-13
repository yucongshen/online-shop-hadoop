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
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>商品列表</title>

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
<link href="css/product.css" rel="stylesheet" type="text/css"/>
<link href="css/pagination.css" rel="stylesheet" type="text/css"/>
<script src="js/html5.js"></script>
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<script>
	function saveCart(cartForm)
	{
		document.getElementById(cartForm).submit();
	}
</script>  
</head>
<body>
<div class="mainContainer sixteen container">
<!--Header Block-->
<%@ include file="header.jsp" %>
<!--Content Block-->
<section class="content-wrapper">
	<div class="content-container container">
		<div class="breadcrum-container">
			<ul>
				<li><a><s:property value="#session.firstCategory.cname"/>>></a></li>
			</ul>
		</div>
		<div class="col-left">
			<div class="block man-block">
				<div class="block-title"><s:property value="#session.firstCategory.cname"/></div>
				<ul>
					<s:iterator var="cs" value="#session.firstCategory.secondCategorys">
						<li>
							<a href="product_findByCsid.action?csid=<s:property value="#cs.csid"/>&page=1" style="">
								<s:property value="#cs.csname"/>
							</a>
						</li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div class="col-main">
			<%--<div class="category-banner"><img src="images/sunglass.jpg" title="Banner" alt="Banner" /></div>
			--%><%--<div class="pager-container">
				<div class="view-by-block">
					<ul class="view-by">
						<li>手机数码类</li>
						<li><a href="#" title="Grid" class="grid">Grid</a></li>
						<li><a href="#" title="List" class="list">List</a></li>
						
					</ul>
					<div class="short-by">
						<label>Sort By</label><select><option>Position</option></select>
					</div>
				
				</div>
			</div>--%>
			<div class="new-product-block">
			<div class="container productList">
				<ul class="product-grid">
					<s:iterator var="p" value="pageBean.list">
					<li>
						<div class="pro-img"><img title="" alt="Freature Product" src="<%=basePath%><s:property value="#p.image"/>" /></div>
						<div class="pro-content"><p><s:property value="#p.pname"/></p></div>
						<div class="pro-price">$<s:property value="#p.shop_price"/></div>
						<div class="pro-btn-block">
							<%--<a class="add-cart left" href="#" title="Add to Cart">加入购物车</a>--%>
							<form action="cart_add.action" method="post" id="<s:property value="#p.pid"/>">
								<input type="hidden" name="pid" value="<s:property value="#p.pid"/>"/>
								<input type="hidden" id="count" name="count" type="text" value="1" class="input-text qty">
								<input type="button" class="add-cart left" style="background-color: #FE6732; color: white;border: none;width: 66px;height: 35px;font-size: 11px;" title="Add to Cart" value="加入购物车" onclick="saveCart(<s:property value="#p.pid"/>)">
							</form>
							<a class="add-cart right" href="product_findByPid.action?pid=<s:property value="#p.pid"/>" title="商品详情">商品详情</a>
						</div>
						<div class="pro-link-block">
							<a class="add-wishlist left" href="favorite_add.action?pid=<s:property value="#p.pid"/>" title="Add to wishlist">加入收藏夹</a>
							<div class="clearfix"></div>
						</div>
					</li>
					</s:iterator>
				</ul>
				</div>
				<div class="pagination">
		<span>第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页</span>
		<s:if test="cid!=null">
			<s:if test="pageBean.page!=1">
				<a class="firstPage" href="product_findByCid.action?cid=<s:property value="cid"/>&page=1">&nbsp;</a>
				<a class="previousPage" href="product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page-1"/>">&nbsp;</a>
			</s:if>
			<s:iterator var="i" begin="1" end="pageBean.totalPage">
				<s:if test="pageBean.page!=#i">
					<a href="product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="#i"/>"><s:property value="#i"/></a>
				</s:if>
				<s:else>
					<a href="product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="#i"/>" class="currentPage"><s:property value="#i"/></a>
				</s:else>
			</s:iterator>
			<s:if test="pageBean.page!=pageBean.totalPage">
				<a class="nextPage" href="product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
				<a class="lastPage" href="product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
			</s:if>
		</s:if>
		<s:if test="csid!=null">
			<s:if test="pageBean.page!=1">
				<a class="firstPage" href="product_findByCsid.action?csid=<s:property value="csid"/>&page=1">&nbsp;</a>
				<a class="previousPage" href="product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page-1"/>">&nbsp;</a>
			</s:if>
			<s:iterator var="i" begin="1" end="pageBean.totalPage">
				<s:if test="pageBean.page!=#i">
					<a href="product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="#i"/>"><s:property value="#i"/></a>
				</s:if>
				<s:else>
					<a href="product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="#i"/>" class="currentPage"><s:property value="#i"/></a>
				</s:else>
			</s:iterator>
			<s:if test="pageBean.page!=pageBean.totalPage">
				<a class="nextPage" href="product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
				<a class="lastPage" href="product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
			</s:if>
		</s:if>
	</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<%@ include file="common.jsp" %>
		</div>	
	</div>
</section>
</div>
<!--Footer Block-->
<%@include file="footer.jsp" %>
</body>
</html>