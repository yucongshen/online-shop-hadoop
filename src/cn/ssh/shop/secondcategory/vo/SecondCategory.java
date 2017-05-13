package cn.ssh.shop.secondcategory.vo;

import java.util.HashSet;
import java.util.Set;

import cn.ssh.shop.firstcategory.vo.FirstCategory;
import cn.ssh.shop.product.vo.Product;

public class SecondCategory {
	private Integer csid;
	private String csname;
	private FirstCategory firstCategory;
	private Set<Product> products=new HashSet<Product>();
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public FirstCategory getFirstCategory() {
		return firstCategory;
	}
	public void setFirstCategory(FirstCategory firstCategory) {
		this.firstCategory = firstCategory;
	}
}
