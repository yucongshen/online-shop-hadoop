package cn.ssh.shop.user.action;

import cn.ssh.shop.user.service.UserService;
import cn.ssh.shop.user.vo.User;
import cn.ssh.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserManageAction extends ActionSupport implements ModelDriven<User>{

	private User user=new User();
	private UserService userService;
	private Integer page;
	
	
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String list()
	{
		PageBean<User> pageBeanUser=userService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBeanUser", pageBeanUser);
		return "list";
	}
	public String delete(){
		user=userService.findByUid(user.getUserid());
		userService.delete(user);
		return "delete";
	}
	public User getModel() {
		return user;
	}

}
