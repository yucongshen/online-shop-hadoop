package cn.ssh.shop.adminuser.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ssh.shop.adminuser.vo.AdminUser;

public class AdminUserDao extends HibernateDaoSupport{

	public AdminUser login(AdminUser adminUser) {
		System.out.println("dddddddddd");
		String hql="from AdminUser where username=? and pass=?";
		List<AdminUser> list=this.getHibernateTemplate().find(hql,adminUser.getUsername(),adminUser.getPass());
		if(list!=null&&list.size()>0){
			System.out.println(list);
			return list.get(0);
		}
		return null;
	}

}
