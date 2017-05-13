package cn.ssh.shop.order.action;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import cn.ssh.shop.cart.service.CartService;
import cn.ssh.shop.cart.vo.Cart;
import cn.ssh.shop.cart.vo.CartItem;
import cn.ssh.shop.order.service.OrderService;
import cn.ssh.shop.order.vo.Order;
import cn.ssh.shop.order.vo.OrderItem;
import cn.ssh.shop.test.ProducerDemo;
import cn.ssh.shop.user.vo.User;
import cn.ssh.shop.utils.PageBean;
import cn.ssh.shop.utils.PaymentUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderAction extends ActionSupport implements ModelDriven<Order>,SessionAware{
	private OrderService orderService;
	private Order order=new Order();
	private Map<String,Object> session;
	private Integer page;
	private CartService cartService;
	
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	// 接收支付通道编码:
	private String pd_FrpId;

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
	// 接收付款成功后的参数:
	private String r3_Amt;
	private String r6_Order;
		
	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Order getModel() {
		return order;
	}
	public String saveOrder(){
		order.setOrdertime(new Date());
		order.setState(1);//1：未付款  2：已付款，没发货  3：已发货，没确认收货  4：交易完成
		User user=(User) session.get("exitUser");
		if(user==null){
			this.addActionError("亲！您还没有登录！");
			return "info";
		}
		Cart cart=cartService.findByUid(user.getUserid());
		if(cart==null){
			this.addActionError("亲，您的购物车为空~");
			return "info";
		}
		order.setTotal(cart.getTotal());
		for(CartItem cartItem:cart.getCartItems()){
			OrderItem orderItem=new OrderItem();
			orderItem.setCountnumber(cartItem.getCountnumber());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		
		order.setUser(user);
		order.setRealname(user.getRealname());
		order.setAddr(user.getAddr());
		order.setPhone(user.getPhone());
		orderService.save(order);
		cartService.delete(cart);
		return "saveOrder";
		
	}
	public String list(){
		User user=(User) session.get("exitUser");
		PageBean<Order> pageBean=orderService.findByPageUid(user.getUserid(),page);
		
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "list";
	}
	public String findByOid(){
		order=orderService.findByOid(order.getOrderid());
		return "findByOid";
	}
	// 为订单付款:
	public String payOrder() throws IOException {
		// 1.修改数据:
		Order currOrder = orderService.findByOid(order.getOrderid());
		currOrder.setAddr(order.getAddr());
		currOrder.setRealname(order.getRealname());
		currOrder.setPhone(order.getPhone());
		// 修改订单
		orderService.update(currOrder);
		// 2.完成付款:
		// 付款需要的参数:
		String p0_Cmd = "Buy"; // 业务类型:
		String p1_MerId = "10001126856";// 商户编号:
		String p2_Order = order.getOrderid().toString();// 订单编号:
		String p3_Amt = "0.01"; // 付款金额:
		String p4_Cur = "CNY"; // 交易币种:
		String p5_Pid = ""; // 商品名称:
		String p6_Pcat = ""; // 商品种类:
		String p7_Pdesc = ""; // 商品描述:
		String p8_Url = "http://localhost:8080/happy-shop/order_callBack.action"; // 商户接收支付成功数据的地址:
		String p9_SAF = ""; // 送货地址:
		String pa_MP = ""; // 商户扩展信息:
		String pd_FrpId = this.pd_FrpId;// 支付通道编码:
		String pr_NeedResponse = "1"; // 应答机制:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); // hmac
		// 向易宝发送请求:
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		
		// 重定向:向易宝出发:
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
	}

	// 付款成功后跳转回来的路径:
	public String callBack(){
		// 修改订单的状态:
		//Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
		Order currOrder = orderService.findByOid(order.getOrderid());
		// 修改订单状态为2:已经付款:
		currOrder.setState(2);
		orderService.update(currOrder);
		String kafkaMessage="Your order have already submit successfully,orderId: "+order.getOrderid() +",TotalMoney: "+order.getTotal();
		ProducerDemo producer=new ProducerDemo("syc");
		producer.sendMessage(kafkaMessage);
		this.addActionMessage(kafkaMessage);
		return "info";
	}
	
	// 修改订单的状态:
	public String updateState(){
		Order newOrder= orderService.findByOid(order.getOrderid());
		newOrder.setState(4);
		orderService.update(newOrder);
		return "updateState";
	}
	public String delete(){
		order=orderService.findByOid(order.getOrderid());
		orderService.delete(order);
		return "delete";
	}
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
}
