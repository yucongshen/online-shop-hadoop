package cn.ssh.shop.cart.vo;

import java.util.HashSet;
import java.util.Set;

import cn.ssh.shop.user.vo.User;

public class Cart {
	private Integer cartid;
	private float total;
	private User user;
	private Set<CartItem> cartItems=new HashSet<CartItem>();
	public Integer getCartid() {
		return cartid;
	}
	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}
	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	

}
