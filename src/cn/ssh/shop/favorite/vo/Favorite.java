package cn.ssh.shop.favorite.vo;

import cn.ssh.shop.product.vo.Product;
import cn.ssh.shop.user.vo.User;

public class Favorite {
	private Integer fid;
	private Product product;
	private User user;
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
