package cn.ssh.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ssh.shop.secondcategory.vo.SecondCategory;
import cn.ssh.shop.user.vo.User;
import cn.ssh.shop.utils.PageHibernateCallback;

public class UserDao extends HibernateDaoSupport{
	//按名称查询是否有该用户
	public User findByUsername(String username)
	{
		String hql="from User where username=?";
		List<User> list=this.getHibernateTemplate().find(hql,username);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}

	public void save(User user) {
		//注册用户存入数据库
		this.getHibernateTemplate().save(user);
		
	}

	public User findByCode(String code) {
		String hql="from User where code=?";
		List<User> list=this.getHibernateTemplate().find(hql,code);
		if(list!=null&&list.size()>0)
		{
			return list.get(0);
		}
		return null;
	}

	public void update(User exitUser) {
		this.getHibernateTemplate().update(exitUser);
		
	}

	public User login(User user) {
		String hql="from User where username=? and pass=? and state=?";
		List<User> list=this.getHibernateTemplate().find(hql,user.getUsername(),user.getPass(),1);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}

	public int findCount() {
		String hql="select count(*) from User";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<User> findByPage(int begin, int limit) {
		String hql="from User";
		List<User> list=this.getHibernateTemplate().execute(new PageHibernateCallback<User>(hql, null, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public User findByUid(Integer uid) {
		return this.getHibernateTemplate().get(User.class, uid);
		
	}

	public void delete(User user) {
		this.getHibernateTemplate().delete(user);
		
	}

	public User findByMail(String email) {
		String hql="from User where email=?";
		List<User> list=this.getHibernateTemplate().find(hql,email);
		if(list!=null&&list.size()>0)
		{
			return list.get(0);
		}
		return null;
	}

}
