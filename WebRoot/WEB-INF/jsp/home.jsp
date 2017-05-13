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
<title>Happy购~</title>

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

<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<script type="text/javascript">
jQuery (function(){
	var tabContainers=jQuery('div.tabs > div');
	tabContainers.hide().filter(':first').show();
	jQuery('div.tabs ul.tabNavigation a').click(function(){
		tabContainers.hide();
		tabContainers.filter(this.hash).show();
		jQuery('div.tabs ul.tabNavigation a').removeClass('selected');
		jQuery(this).addClass('selected');
		return false;
		}).filter(':first').click();
	});
</script>
<script type="text/javascript">
jQuery (function(){
	var tabContainers=jQuery('div.tabs > div');
	tabContainers.hide().filter(':first').show();
	jQuery('div.tabs ul.tabNavigation a').click(function(){
		tabContainers.hide();
		tabContainers.filter(this.hash).show();
		jQuery('div.tabs ul.tabNavigation a').removeClass('selected');
		jQuery(this).addClass('selected');
		return false;
		}).filter(':first').click();
	});
</script>
<script>
	function saveCart(cartForm)
	{
		document.getElementById(cartForm).submit();
	}
</script>
</head>
<body>
	<div class="mainContainer sixteen container">
	
		<%@include file="header.jsp" %>
		
		<!--Banner Block-->
        <section class="banner-wrapper">
          <div class="banner-block container">
            <div class="flexslider">
              <ul class="slides">
              	<s:iterator var="p" value="bestList">
					<li>
						<a href="product_findByPid.action?pid=<s:property value="#p.pid"/>" target="_blank"><img src="<%=basePath%><s:property value="#p.image"/>"></a>
					</li>
				</s:iterator>
              
                <!--<li><img title="Banner" alt="Banner" src="products/1/nvbao001.jpg" /></li>
                <li><img title="Banner" alt="Banner" src="products/1/nanyi001.jpg" /></li>
                <li><img title="Banner" alt="Banner" src="products/1/nanxie001.jpg" /></li>
                <li><img title="Banner" alt="Banner" src="products/1/iphone5.jpg" /></li>
              -->
              </ul>
            </div>
            <ul class="banner-add">
              <li class="add1"><a href="product_findByPid.action?pid=80" title=""><img  alt="add1" src="products/home/yundongxie001.png" /></a></li>
              <li class="add2"><a title=""><img title="add2" alt="add2" src="images/banner_add2.png" /></a></li>
            </ul>
          </div>
        </section>
        
        <!--Content Block-->
        <section class="content-wrapper">
          <div class="content-container container">
          
          <div class="heading-block">
	           <h1>热门商品</h1>
	           <ul class="pagination">
	             <li class="grid"><a href="#" title="Grid">Grid</a></li>
	           </ul>
	         </div>
	         <div class="feature-block">
	           <ul id="mix" class="product-grid">
	           		<s:iterator var="p" value="hotList">
			             <li>
			               <div class="pro-img"><img title="" alt="Freature Product" src="<%=basePath%><s:property value="#p.image"/>"/></div>
			               <div class="pro-hover-block">
			                 <h4 class="pro-name"><s:property value="#p.pname"/></h4>
			                 <div class="link-block"> 
			                 <a href="#quick-view-container" class="quickllook inline" title="快速查看商品信息">快速查看商品信息</a> 
			                 <a href="product_findByPid.action?pid=<s:property value="#p.pid"/>" class="quickproLink" title="商品详情">商品详情</a></div>
			                 <div class="pro-price">$<s:property value="#p.shop_price"/></div>
			               </div>
			             </li>
	             	</s:iterator>
	           </ul>
	         </div>
	         <div class="heading-block">
	         <h1>最新商品</h1>
	         </div>
	         <div class="new-product-block">
		           <ul class="product-grid">	
		           	<s:iterator var="n" value="newList">	
		             <li>
		               <div class="pro-img">
		                 <img title="Freature Product" alt="Freature Product" src="<%=basePath%><s:property value="#n.image"/>" />
		               </div>
		               <div class="pro-content">
		                 <p><s:property value="#n.pname"/></p>
		               </div>
		              
		               <div class="pro-price">$<s:property value="#n.shop_price"/></div>
		               <div class="pro-btn-block"> 
		               <%--<a class="add-cart left" href="#" title="Add to Cart">加入购物车</a>--%> 
		               <form action="cart_add.action" method="post" id="<s:property value="#n.pid"/>">
							<input type="hidden" name="pid" value="<s:property value="#n.pid"/>"/>
							<input type="hidden" id="count" name="count" type="text" value="1" >
							<input type="button" class="add-cart left" style="background-color: #FE6732; color: white;border: none;width: 66px;height: 35px;font-size: 11px;" title="加入购物车" value="加入购物车" onclick="saveCart(<s:property value="#n.pid"/>)">
						</form>
		               <a class="add-cart right" href="product_findByPid.action?pid=<s:property value="#n.pid"/>" title="商品详情">商品详情</a> </div>
		               <div class="pro-link-block"> <a class="add-wishlist left" href="favorite_add.action?pid=<s:property value="#n.pid"/>" title="收藏夹">加入收藏夹</a> 
		                 <div class="clearfix"></div>
		               </div>
		             </li>
		             </s:iterator>
		           </ul>
	         </div>
          
            <%@include file="common.jsp" %>
            
          </div>
          
        </section>
    </div> 
	<%@include file="footer.jsp" %>
</body>
</html>