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
	// ����֧��ͨ������:
	private String pd_FrpId;

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
	// ���ո���ɹ���Ĳ���:
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
		order.setState(1);//1��δ����  2���Ѹ��û����  3���ѷ�����ûȷ���ջ�  4���������
		User user=(User) session.get("exitUser");
		if(user==null){
			this.addActionError("�ף�����û�е�¼��");
			return "info";
		}
		Cart cart=cartService.findByUid(user.getUserid());
		if(cart==null){
			this.addActionError("�ף����Ĺ��ﳵΪ��~");
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
	// Ϊ��������:
	public String payOrder() throws IOException {
		// 1.�޸�����:
		Order currOrder = orderService.findByOid(order.getOrderid());
		currOrder.setAddr(order.getAddr());
		currOrder.setRealname(order.getRealname());
		currOrder.setPhone(order.getPhone());
		// �޸Ķ���
		orderService.update(currOrder);
		// 2.��ɸ���:
		// ������Ҫ�Ĳ���:
		String p0_Cmd = "Buy"; // ҵ������:
		String p1_MerId = "10001126856";// �̻����:
		String p2_Order = order.getOrderid().toString();// �������:
		String p3_Amt = "0.01"; // ������:
		String p4_Cur = "CNY"; // ���ױ���:
		String p5_Pid = ""; // ��Ʒ����:
		String p6_Pcat = ""; // ��Ʒ����:
		String p7_Pdesc = ""; // ��Ʒ����:
		String p8_Url = "http://localhost:8080/happy-shop/order_callBack.action"; // �̻�����֧���ɹ����ݵĵ�ַ:
		String p9_SAF = ""; // �ͻ���ַ:
		String pa_MP = ""; // �̻���չ��Ϣ:
		String pd_FrpId = this.pd_FrpId;// ֧��ͨ������:
		String pr_NeedResponse = "1"; // Ӧ�����:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // ��Կ
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); // hmac
		// ���ױ���������:
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
		
		// �ض���:���ױ�����:
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
	}

	// ����ɹ�����ת������·��:
	public String callBack(){
		// �޸Ķ�����״̬:
		//Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
		Order currOrder = orderService.findByOid(order.getOrderid());
		// �޸Ķ���״̬Ϊ2:�Ѿ�����:
		currOrder.setState(2);
		orderService.update(currOrder);
		String kafkaMessage="Your order have already submit successfully,orderId: "+order.getOrderid() +",TotalMoney: "+order.getTotal();
		ProducerDemo producer=new ProducerDemo("syc");
		producer.sendMessage(kafkaMessage);
		this.addActionMessage(kafkaMessage);
		return "info";
	}
	
	// �޸Ķ�����״̬:
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
