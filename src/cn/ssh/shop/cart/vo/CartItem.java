package cn.ssh.shop.cart.vo;

import cn.ssh.shop.product.vo.Product;

public class CartItem {
	private Integer cartitemid;
	private Integer countnumber;
	private float subtotal;
	private Product product;
	private Cart cart;
	public Integer getCartitemid() {
		return cartitemid;
	}
	public void setCartitemid(Integer cartitemid) {
		this.cartitemid = cartitemid;
	}
	
	
	public Integer getCountnumber() {
		return countnumber;
	}
	public void setCountnumber(Integer countnumber) {
		this.countnumber = countnumber;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	

}
