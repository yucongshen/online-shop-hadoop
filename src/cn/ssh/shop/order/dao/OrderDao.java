package cn.ssh.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ssh.shop.order.vo.Order;
import cn.ssh.shop.user.vo.User;
import cn.ssh.shop.utils.PageHibernateCallback;

public class OrderDao extends HibernateDaoSupport{

	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

	public Integer findCountByUid(Integer uid) {
		String hql="select count(*) from Order o where o.user.userid=?";
		List<Long>list=this.getHibernateTemplate().find(hql,uid);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}

	public List<Order> findByPageUid(Integer uid, Integer begin, Integer limit) {
		String hql="from Order o where o.user.userid=? order by ordertime desc";
		List<Order> list=this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql,new Object[]{uid},begin,limit));
		return list;
	}

	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
		
	}

	public void update(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);
		
	}

	public int findCount() {
		String hql="select count(*) from Order";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Order> findByPage(int begin, int limit) {
		String hql="from Order order by ordertime desc";
		List<Order> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, null, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public void delete(Order order) {
		this.getHibernateTemplate().delete(order);
		
	}
}
