package cn.ssh.shop.favorite.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ssh.shop.favorite.vo.Favorite;
import cn.ssh.shop.utils.PageHibernateCallback;

public class FavoriteDao extends HibernateDaoSupport{

	public void add(Favorite favorite) {
		
		this.getHibernateTemplate().save(favorite);
	}

	public Integer findCountByUid(Integer uid) {
		String hql="select count(*) from Favorite f where f.user.userid=?";
		List<Long>list=this.getHibernateTemplate().find(hql,uid);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}

	public List<Favorite> findPageByUid(Integer uid, int begin, int limit) {
		String hql="from Favorite f where f.user.userid=?";
		List<Favorite> list=this.getHibernateTemplate().execute(
				new PageHibernateCallback<Favorite>(hql,new Object[]{uid},begin,limit));
		return list;
	}

	public Favorite findByPidAndUid(Integer pid,Integer uid) {
		String hql="from Favorite f where f.product.pid=? and f.user.userid=?";
		List<Favorite> list=this.getHibernateTemplate().find(hql,pid,uid);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public void delete(Favorite favorite) {
		this.getHibernateTemplate().delete(favorite);
		
	}
	public List<Favorite> findByUid(Integer uid) {
		String hql="from Favorite f where f.user.userid=?";
		List<Favorite> list=this.getHibernateTemplate().find(hql,uid);
		return list;
	}

}
