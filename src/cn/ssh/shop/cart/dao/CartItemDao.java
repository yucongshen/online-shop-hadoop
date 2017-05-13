package cn.ssh.shop.cart.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ssh.shop.cart.vo.CartItem;
import cn.ssh.shop.favorite.vo.Favorite;
import cn.ssh.shop.utils.PageHibernateCallback;

public class CartItemDao extends HibernateDaoSupport{

	public void save(CartItem cartItem1) {
		this.getHibernateTemplate().save(cartItem1);
		
	}

	public void update(Integer cartitemid, int newCount, float newSubtotal) {
		String hql="update CartItem c set c.countnumber=?,c.subtotal=? where cartitemid=?";
		this.getHibernateTemplate().bulkUpdate(hql,newCount,newSubtotal,cartitemid);
		
	}
	
	public CartItem findByPidAndCartid(Integer cartid,Integer pid) {
		String hql="from CartItem c where c.cart.cartid=? and c.product.pid=?";
		List<CartItem> list=this.getHibernateTemplate().find(hql,cartid,pid);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public Integer findCountByCartid(Integer cartid) {
		String hql="select count(*) from CartItem c where c.cart.cartid=?";
		List<Long>list=this.getHibernateTemplate().find(hql,cartid);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}

	public List<CartItem> findPageByCartid(Integer cartid, int begin, int limit) {
		String hql="from CartItem c where c.cart.cartid=?";
		List<CartItem> list=this.getHibernateTemplate().execute(
				new PageHibernateCallback<CartItem>(hql,new Object[]{cartid},begin,limit));
		return list;
	}

	public CartItem findByCaritemid(Integer cartitemid) {
		return this.getHibernateTemplate().get(CartItem.class, cartitemid);
	}

	public void delete(CartItem cartItem) {
		this.getHibernateTemplate().delete(cartItem);
		
	}

	public List<CartItem> findByCartid(Integer cartid) {
		String hql="from CartItem c where c.cart.cartid=?";
		List<CartItem> list=this.getHibernateTemplate().find(hql,cartid);
		if(list!=null&&list.size()>0)
		{
			return list;
		}
		return null;
	}
}
