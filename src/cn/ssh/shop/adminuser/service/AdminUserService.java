package cn.ssh.shop.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.shop.adminuser.dao.AdminUserDao;
import cn.ssh.shop.adminuser.vo.AdminUser;
@Transactional
public class AdminUserService {
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	

}
