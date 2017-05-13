package cn.ssh.shop.order.action;

import cn.ssh.shop.order.service.OrderService;
import cn.ssh.shop.order.vo.Order;
import cn.ssh.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderManageAction extends ActionSupport implements ModelDriven<Order>{
	private Order order=new Order();
	private OrderService orderService;
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String findOrderList(){
		PageBean<Order> pageBeanOrder=orderService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBeanOrder", pageBeanOrder);
		return "findOrderList";
	}
	public String findOrderByOid(){
		order=orderService.findByOid(order.getOrderid());
		return "findOrderByOid";
	}
	public String updateState(){
		order=orderService.findByOid(order.getOrderid());
		order.setState(3);
		orderService.update(order);
		return "updateState";
	}
	public Order getModel() {
		return order;
	}
}
