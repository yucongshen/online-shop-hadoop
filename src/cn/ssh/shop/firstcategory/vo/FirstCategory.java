package cn.ssh.shop.firstcategory.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import cn.ssh.shop.secondcategory.vo.SecondCategory;
//ʵ�����л��ӿڣ��������stop serverʱ �����������ر�ʱ������������л��쳣
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
