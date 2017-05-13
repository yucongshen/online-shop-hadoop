package cn.ssh.shop.adminuser.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import cn.ssh.shop.adminuser.service.AdminUserService;
import cn.ssh.shop.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>,SessionAware{
	private AdminUser adminUser=new AdminUser();
	private AdminUserService adminUserService;
	private Map<String, Object> session;

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	public String login(){
		AdminUser exitAdminUser=adminUserService.login(adminUser);
		if(exitAdminUser==null){
			this.addActionError("用户名或密码错误！");
			return "loginFail";
		}else{
			session.put("exitAdminUser", exitAdminUser);
			return "loginSuccess";
		}
	}

	public AdminUser getModel() {
		
		return adminUser;
	}
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
	public String logout()
	{
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}
}
