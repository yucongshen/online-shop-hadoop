package cn.ssh.shop.cart.dao;

import java.util.List;

import javax.jms.Session;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ssh.shop.cart.vo.Cart;
import cn.ssh.shop.cart.vo.CartItem;

public class CartDao extends HibernateDaoSupport{

	public void save(Cart cart) {
		this.getHibernateTemplate().save(cart);
	}

	public Cart findByUid(Integer uid) {
		String hql="from Cart c where c.user.userid=?";
		List<Cart> list=this.getHibernateTemplate().find(hql,uid);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public void update(Integer cartid, float total) {
		String hql="update Cart c set c.total=? where c.cartid=?";
		this.getHibernateTemplate().bulkUpdate(hql,total,cartid);
		
	}

	public void delete(Cart cart) {
		this.getHibernateTemplate().delete(cart);
	}

}
