package cn.ssh.shop.firstcategory.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import cn.ssh.shop.secondcategory.vo.SecondCategory;
//实现序列化接口，这样点击stop server时 服务器正常关闭时，不会出现序列化异常
public class FirstCategory implements Serializable{
	private Integer cid;
	private String cname;
	private Set<SecondCategory> secondCategorys=new HashSet<SecondCategory>();
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<SecondCategory> getSecondCategorys() {
		return secondCategorys;
	}
	public void setSecondCategorys(Set<SecondCategory> secondCategorys) {
		this.secondCategorys = secondCategorys;
	}
	
	
}
