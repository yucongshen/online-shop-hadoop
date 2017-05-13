package cn.ssh.shop.message.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ssh.shop.firstcategory.vo.FirstCategory;
import cn.ssh.shop.message.vo.Message;
import cn.ssh.shop.utils.PageHibernateCallback;

public class MessageDao extends HibernateDaoSupport{

	public void save(Message message) {
		this.getHibernateTemplate().save(message);
		
	}

	public int findCount() {
		String hql="select count(*) from Message";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Message> findByPage(int begin, int limit) {
		String hql="from Message";
		List<Message> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Message>(hql, null, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public Message findByMid(Integer mid) {
		return this.getHibernateTemplate().get(Message.class, mid);
	}

	public void delete(Message message) {
		this.getHibernateTemplate().delete(message);
		
	}

}
