package cn.ssh.shop.firstcategory.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ssh.shop.firstcategory.vo.FirstCategory;
import cn.ssh.shop.utils.PageHibernateCallback;

public class FirstCategoryDao extends HibernateDaoSupport{

	public List<FirstCategory> findAll() {
		String hql="from FirstCategory";
		List<FirstCategory> list=this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public void save(FirstCategory firstCategory) {
		this.getHibernateTemplate().save(firstCategory);
		
	}

	public FirstCategory findByCid(Integer cid) {
		
		return this.getHibernateTemplate().get(FirstCategory.class, cid);
	}

	public void delete(FirstCategory firstCategory) {
		this.getHibernateTemplate().delete(firstCategory);
		
	}

	public void update(FirstCategory category) {
		String hql="update FirstCategory c set c.cname=? where c.cid=?";
		this.getHibernateTemplate().bulkUpdate(hql,category.getCname(),category.getCid());
		
	}

	public int findCount() {
		String hql="select count(*) from FirstCategory";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<FirstCategory> findByPage(int begin, int limit) {
		String hql="from FirstCategory";
		List<FirstCategory> list=this.getHibernateTemplate().execute(new PageHibernateCallback<FirstCategory>(hql, null, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

}
