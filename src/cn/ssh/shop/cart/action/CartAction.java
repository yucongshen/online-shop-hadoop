package cn.ssh.shop.cart.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.ssh.shop.cart.service.CartItemService;
import cn.ssh.shop.cart.service.CartService;
import cn.ssh.shop.cart.vo.Cart;
import cn.ssh.shop.cart.vo.CartItem;
import cn.ssh.shop.product.service.ProductService;
import cn.ssh.shop.product.vo.Product;
import cn.ssh.shop.user.vo.User;
import cn.ssh.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CartAction extends ActionSupport implements ModelDriven<Cart>,SessionAware{
	private Map<String, Object> session;
	private Cart cart=new Cart();
	private CartService cartService;
	private CartItemService cartItemService;
	private ProductService productService;
	private Integer pid;
	private Integer count;
	private Integer page;
	private Integer cartitemid;
	
	
	public void setCartitemid(Integer cartitemid) {
		this.cartitemid = cartitemid;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setCartItemService(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public String add()
	{
		User user=(User) session.get("exitUser");
		if(user==null){
			this.addActionError("亲！您还没有登录！");
			return "info";
		}
		Cart cart1=cartService.findByUid(user.getUserid());
		
		if(cart1==null)
		{
			cart1=new Cart();
			CartItem cartItem =new CartItem();
			Product product=productService.findByPid(pid);
			cartItem.setCountnumber(count);
			cartItem.setProduct(product);
			cartItem.setSubtotal(cartItem.getCountnumber()*product.getShop_price());
			cartItem.setCart(cart1);
			cart1.getCartItems().add(cartItem);
			cart1.setUser(user);
			float total=0;
			for(CartItem c:cart1.getCartItems())
			{
				total+=c.getSubtotal();
			}
			cart1.setTotal(total);
			cartService.save(cart1);
		}
		else
		{
			CartItem cartItem1=cartItemService.findByPidAndCartid(cart1.getCartid(),pid);
			if(cartItem1==null){
				cartItem1=new CartItem();
				Product product=productService.findByPid(pid);
				cartItem1.setCountnumber(count);
				cartItem1.setProduct(product);
				cartItem1.setSubtotal(count*product.getShop_price());
				cartItem1.setCart(cart1);
				
				cart1.getCartItems().add(cartItem1);
				float total=0;
				for(CartItem c:cart1.getCartItems()){
					total+=c.getSubtotal();
				}
				cartService.update(cart1.getCartid(),total);
				cartItemService.save(cartItem1);
			}else{
				Product product=productService.findByPid(pid);
				int newCount=cartItem1.getCountnumber()+count;
				float newSubtotal=newCount*product.getShop_price();
				cartItem1.setCountnumber(newCount);
				cartItem1.setProduct(product);
				cartItem1.setSubtotal(newSubtotal);
				cartItem1.setCart(cart1);
				//这种情况下不需要增加一条item，只需更改数量和小计
				float total=0;
				for(CartItem c:cart1.getCartItems()){
					if(c.getCartitemid()!=cartItem1.getCartitemid()){
						total+=c.getSubtotal();
					}
				}
				total+=newSubtotal;
				System.out.println("total+"+total);
				cartService.update(cart1.getCartid(), total);
				cartItemService.update(cartItem1.getCartitemid(),newCount,newSubtotal);
			}
		}
		return "add";
	}
	public String list()
	{
		User user=(User) session.get("exitUser");
		if(user==null){
			this.addActionError("亲！您还没有登录！");
			return "info";
		}
		cart=cartService.findByUid(user.getUserid());
		if(cart!=null){
			PageBean<CartItem> pageBeanCartItem=cartItemService.findPageByCaritid(cart.getCartid(),page);	
			ActionContext.getContext().getValueStack().set("pageBeanCartItem", pageBeanCartItem);
		}else{
			boolean flag=false;
			ActionContext.getContext().getValueStack().set("flag", flag);
		}
		return "list";
	}
	public String delete()
	{
		User user=(User) session.get("exitUser");
		CartItem cartItem=cartItemService.findByCartitemid(cartitemid);
		float subtotal=cartItem.getSubtotal();
		cart=cartService.findByUid(user.getUserid());
		float newTotal=cart.getTotal()-subtotal;
		if(newTotal==0){
			cartService.delete(cart);
		}else{
			cartItemService.delete(cartItem);
			cartService.update(cart.getCartid(), newTotal);
		}
		return "delete";
	}
	public String clear()
	{
		User user=(User) session.get("exitUser");
		cart=cartService.findByUid(user.getUserid());
		cartService.delete(cart);
		return "clear";
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	public Cart getModel() {
		return cart;
	}

}
