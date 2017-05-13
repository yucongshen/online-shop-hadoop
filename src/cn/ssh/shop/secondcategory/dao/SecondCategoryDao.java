package cn.ssh.shop.secondcategory.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ssh.shop.secondcategory.vo.SecondCategory;
import cn.ssh.shop.utils.PageHibernateCallback;

public class SecondCategoryDao extends HibernateDaoSupport{

	public int findCount() {
		String hql="select count(*) from SecondCategory";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<SecondCategory> findByPage(int begin, int limit) {
		String hql="from SecondCategory order by csid";
		List<SecondCategory> list=this.getHibernateTemplate().execute(new PageHibernateCallback<SecondCategory>(hql, null, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public void save(SecondCategory secondCategory) {
		this.getHibernateTemplate().save(secondCategory);
		
	}

	public void delete(SecondCategory secondCategory) {
		this.getHibernateTemplate().delete(secondCategory);
		
	}

	public SecondCategory findByCsid(Integer csid) {
		return this.getHibernateTemplate().get(SecondCategory.class, csid);
	}

	public void update(SecondCategory secondCategory) {
		String hql="update SecondCategory c set c.csname=?,c.firstCategory.cid=? where c.csid=?";
		this.getHibernateTemplate().bulkUpdate(hql, secondCategory.getCsname(),secondCategory.getFirstCategory().getCid(),secondCategory.getCsid());
		
	}

	public List<SecondCategory> findAll() {
		String hql="from SecondCategory";
		List<SecondCategory> csList=this.getHibernateTemplate().find(hql);
		if(csList!=null&&csList.size()>0){
			return csList;
		}
		return null;
	}

}
