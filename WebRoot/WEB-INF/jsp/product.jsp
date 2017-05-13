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
<title>商品详情</title>

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
<script src="js/html5.js"></script>
<script type="text/javascript">
	$(function(){
		var tabContainers=$('section.product-collateral > div.commonContent');
		tabContainers.hide().filter(':first').show();
		$('section.product-collateral ul.tab-block a').click(function(){
			tabContainers.hide();
			tabContainers.filter(this.hash).show();
			$('section.product-collateral ul.tab-block a').removeClass('active');
			$(this).addClass('active');
			return false;
			}).filter(':first').click();
		});
</script>
<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery(".ajax").colorbox();
	});	
                     	jQuery(function() {
		jQuery(".add").click(function() {
			var jQueryadd = jQuery(this);
			var oldValue = jQueryadd.parent().find("input").val();
			var newVal = 0;
		
			if (jQueryadd.text() == "+") {
			   newVal = parseFloat(oldValue) + 1;
			  // AJAX save would go here
			} else {
			  // Don't allow decrementing below zero
			  if (oldValue >= 1) {
				  newVal = parseFloat(oldValue) - 1;
				  // AJAX save would go here
			  }
			  if(oldValue == 0){
				  newVal = parseFloat(oldValue);
				  }
			}
			jQueryadd.parent().find("input").val(newVal);
		});
		
	
	});
</script>
<script>
	function saveCart()
	{
		document.getElementById("cartForm").submit();
	}
</script>
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
		<div class="breadcrum-container">
			<ul>
				<li><a href="" onclick="history.go(-1)">返回</a></li>
				<li><s:property value="model.pname"/></li>
			</ul>
		</div>
		<div class="main">
			
			<div class="product-info-box">
				<div class="product-essential">
					<div class="product-img-box">
						<p class="product-image-zoom">
							<img src="<%=basePath%><s:property value="model.image"/>"  alt="Image" title="Image" />
						</p>
					</div>
					<div class="product-shop">
						<h3 class="product-name"><s:property value="model.pname"/></h3>
						<div class="price-box">
                		    <span class="price">$<s:property value="model.shop_price"/></span>
                		    <br><br>
							<!--<span class="availability">In stock</span>-->
				        </div>
						<div class="model-block">
							<p>
								<span>参 考 价：</span><del>￥<s:property value="model.market_price"/>元</del>
								
							</p>
						</div>
						<br><br><br><br><br><br><br><br><br>
						<div class="add-to-cart-box">
							<form action="cart_add.action" method="post" id="cartForm">
								<input type="hidden" name="pid" value="<s:property value="model.pid"/>"/>
								<span class="qty-box">
									<label for="qty">数量:</label>
									<a href="javascript:void(0)" title="" class="prev add"><img src="images/qty_prev.png" title="" alt="add" />+</a>
									<input  id="count" name="count" type="text" value="1" maxlength="12" class="input-text qty">
									<a href="javascript:void(0)" title="" class="next dec add"><img src="images/qty_next.png" title="" alt="" />-</a>
								</span>
								<input type="button" class="form-button" title="Add to Cart" value="加入购物车" onclick="saveCart()">
							</form>
							<br><br><br><br><br>
							<ul class="add-to-box">
								<li><a href="favorite_add.action?pid=<s:property value="model.pid"/>" title="Add to Wishlist" class="add-wishlist">加入到收藏夹</a></li>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
            <aside class="right">
				<ol class="pro-slider-btn">
					
				</ol>
				<ul class="right-img">
					<li><a title="Image"><img src="images/view_right_img01.png" title="Image" alt="Image" /></a></li>
					<li><a title="Image"><img src="images/view_right_img02.png" title="Image" alt="Image" /></a></li>
					<li><a title="Image"><img src="images/view_right_img03.png" title="Image" alt="Image" /></a></li>
				</ul>
			</aside>
			<section  class="product-collateral">
				<ul class="tab-block">
					<li><a href="#pro-detail" title="Description" class="active">商品描述</a></li>
				</ul>
				<div id="pro-detail" class="pro-detail commonContent">
					<p>
						<s:property value="model.pdesc"/>
					</p>
				</div>
			</section>
			<div class="like-pro-block">
				<div class="title-block">
					<h2>猜你喜欢</h2>
				</div>
				<div class="like-pro">
					<ul id="like-pro" class="product-grid">
						<s:iterator var="pl" value="likeList">
							<li>
								<div class="pro-img"><a href="product_findByPid.action?pid=<s:property value="#pl.pid"/>"><img alt="Freature Product" src="<%=basePath%><s:property value="#pl.image"/>" /></a></div>
								<div class="pro-detail-block">
									<h4 class="pro-name"><s:property value="#pl.pname"/></h4>
									<div class="pro-price">$<s:property value="#pl.shop_price"/></div>
								</div>
							</li>
						</s:iterator>
					</ul>
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