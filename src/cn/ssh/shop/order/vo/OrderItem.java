package cn.ssh.shop.order.vo;

import cn.ssh.shop.product.vo.Product;
//CREATE TABLE `orderitem` (
//		  `itemid` int(11) NOT NULL AUTO_INCREMENT,
//		  `count` int(11) DEFAULT NULL,
//		  `subtotal` double DEFAULT NULL,
//		  `pid` int(11) DEFAULT NULL,
//		  `oid` int(11) DEFAULT NULL,
//		  PRIMARY KEY (`itemid`),
//		  KEY `FKE8B2AB6166C01961` (`oid`),
//		  KEY `FKE8B2AB6171DB7AE4` (`pid`),
//		  KEY `FKE8B2AB6140ACF87A` (`oid`),
//		  CONSTRAINT `FKE8B2AB6140ACF87A` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`),
//		  CONSTRAINT `FKE8B2AB6171DB7AE4` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
//		) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
public class OrderItem {
	private Integer itemid;
	private Integer countnumber;
	private float subtotal;
	private Product product;
	private Order order;
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
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
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}
