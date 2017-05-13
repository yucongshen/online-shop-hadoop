<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <!--Header Block-->
<div class="header-wrapper">
  <header class="container">
    <div class="head-right">
          <ul class="top-nav">
          	<s:if test="#session.exitUser==null">
                <li class=""><a href="user_loginPage.action" title="Login">登录</a></li>
                <li class="my-wishlist"><a href="user_registPage.action" title="Regist">注册</a></li>
            </s:if>
            <s:else>
            	<li class=""><a href="favorite_list.action?page=1" title="My Favorite">我的收藏</a></li>
            	<li class=""><a href="order_list.action?page=1" title="My Orders">我的订单</a></li>
                <li class="my-wishlist"><a href="user_quit.action" title="Quit">退出</a></li>
            </s:else>
                <li class="contact-us"><a href="message_page.action" title="Suggest">意见建议</a></li>
                <li class="checkout"><a href="user_service.action" title="Online Customer service">在线客服</a></li>
                <li class="log-in"><a href="user_attention.action" title="Pay attention to us">关注我们</a></li>
          </ul>
          <s:if test="#session.exitUser!=null">
	        <ul class="currencyBox">
		            <li id="header_currancy" class="currency"> <a class="mainCurrency" href="user_personal.action?uid=<s:property value="#session.exitUser.uid"/>">当前用户: <s:property value="#session.exitUser.username"/></a>
		              <div id="currancyBox" class="currency_detial"> 
		              	<a href="#"><s:property value="#session.exitUser.name"/></a> 
		              	<a href="#"><s:property value="#session.exitUser.addr"/></a> 
		              	<a href="#"><s:property value="#session.exitUser.phone"/></a> 
		              </div>
		            </li>
	        </ul>
          </s:if>
      <section class="header-bottom">
        <div class="cart-block">
			<ul>
				<li><a href="cart_list.action?page=1" title="Cart"><img title="购物车" alt="Item" src="images/item_icon.png" /></a></li>
				<li>购物车</li>
			</ul>
		</div>
                <div class="search-block">
                 <form action="product_search.action?page=1" method="post">
	                  <input type="text" value="Search" name="match" onfocus="if (value =='Search'){value =''}" onblur="if (value ==''){value='Search'}"/>
	                  <input type="submit" title="Search" />
                 </form>
                </div>
              </section>
            </div>
            <h1 class="logo"><a href="index-2.html" title="Logo">
              <img title="Logo" alt="Logo" src="images/logo.jpg" />
              </a></h1>
            <nav id="smoothmenu1" class="ddsmoothmenu mainMenu">
              <ul id="nav">
                <li class="active"><a href="index.action" title="Home">首页</a></li>
                <s:iterator value="#session.clist" var="category">
					<li><a href="product_findByCid.action?cid=<s:property value="#category.cid"/>&page=1"><s:property value="#category.cname"/></a></li>
				</s:iterator>
              </ul>
            </nav>
        <h1>
    </div>
        
      </header>
    </div>