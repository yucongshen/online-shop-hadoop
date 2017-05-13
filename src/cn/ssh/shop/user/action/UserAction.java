package cn.ssh.shop.user.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import cn.ssh.shop.user.service.UserService;
import cn.ssh.shop.user.vo.User;
import cn.ssh.shop.utils.ResetMailUtils;
import cn.ssh.shop.utils.UUIDUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>,SessionAware{
	private User user=new User();
	private UserService userService;
	private String checkcode;
	private Map<String, Object> session;
	private String pasw;
	private String newPassword;
	private String renewPassword;
	
	public void setPasw(String pasw) {
		this.pasw = pasw;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public void setRenewPassword(String renewPassword) {
		this.renewPassword = renewPassword;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getModel() {
		
		return user;
	}
	public String registPage()
	{
		return "registPage";
		
	}
	//Ajax校验用户名是否存在
	public String findByName() throws IOException
	{
		User exitUser=userService.findByUsername(user.getUsername());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(exitUser!=null){
			response.getWriter().print("<font color='white'>用户名已存在!!</font>");
		}
		return NONE;
	}
	//Ajax校验邮箱是否存在
	public String findByEMail() throws IOException
	{
		User exitUser=userService.findByMail(user.getEmail());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(exitUser!=null){
			response.getWriter().print("<font color='white'>该邮箱已被注册!!</font>");
		}
		return NONE;
	}

	public String regist()
	{
		User user1=userService.findByUsername(user.getUsername());
		if(user1!=null){
			this.addActionMessage("该用户名已被注册，请更改用户名！");
			return "info";
		}
		User user2=userService.findByMail(user.getEmail());
		if(user2!=null){
			this.addActionMessage("该邮箱已被注册，请更改邮箱！");
			return "info";
		}
		String checkcode1=(String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addActionError("验证码错误!");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("注册成功！请去邮箱激活！");
		return "info";
	}
	public String active()
	{
		//根据激活码查询用户
		User exitUser=userService.findByCode(user.getCode());
		//判断
		if(exitUser==null){
			this.addActionMessage("激活码错误！，激活失败！");
		}else{
			exitUser.setState(1);
			exitUser.setCode(null);
			userService.update(exitUser);
			this.addActionMessage("激活成功！请登录！");
		}
		return "info";
	}
	public String loginPage()
	{
		return "loginPage";
	}
	public String login()
	{
		User exitUser=userService.login(user);
		if(exitUser==null){
			this.addActionError("登录失败！(用户名或密码错误或未成功激活)");
			return "login";
		}else{
			session.put("exitUser", exitUser);
			return "loginSuccess";
		}
	}
	public String quit()
	{
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	public String editPasswordPage(){
		user=userService.findByUid(user.getUserid());
		return "editPasswordPage";
	}
	public String updatePassword()
	{
		if(!user.getPass().equals(pasw)){
			System.out.println(pasw);
			System.out.println(user.getPass());
			this.addActionError("原始密码不正确！");
		}else if(!newPassword.equals(renewPassword)){
			this.addActionError("两次新密码输入不一致！");
		}else{
			this.addActionMessage("修改密码成功！");
			user.setPass(newPassword);
			userService.update(user);
		}
		return "info";
	}
	public String verifyPage()
	{
		return "verifyPage";
	}
	public String resetPassword()
	{
		user=userService.findByMail(user.getEmail());
		if(user==null){
			this.addActionMessage("邮箱错误！");
			return "info";
		}else{
			String code=UUIDUtils.getUUID();
			user.setCode(code);
			userService.update(user);
			ResetMailUtils.sendMail(user.getEmail(),user.getCode());
			this.addActionMessage("邮箱验证成功，请去邮箱，点击邮箱链接重置密码！");
			return "info";
		}
	}
	public String resetPasswordPage(){
		user=userService.findByCode(user.getCode());
		if(user==null){
			this.addActionMessage("此链接已失效！");
			return "info";
		}
		return "resetPasswordPage";
	}
	public String reset(){
		if(user==null){
			this.addActionMessage("此页面已失效！");
		}
		if(!newPassword.equals(renewPassword)){
			this.addActionError("两次新密码输入不一致！");
		}else{
			this.addActionMessage("重置密码成功！");
			user.setPass(newPassword);
			user.setCode(null);
			userService.update(user);
		}
		return "info";
	}
	public String personal()
	{
		user=userService.findByUid(user.getUserid());
		return "personal";
	}
	public String editPersonalPage(){
		user=userService.findByUid(user.getUserid());
		return "editPersonalPage";
	}
	public String updatePersonal(){
		userService.update(user);
		this.addActionMessage("修改成功！");
		session.remove("exitUser");
		session.put("exitUser", user);
		return "info";
	}
	public String service(){
		return "service";
	}
	public String attention(){
		return "attention";
	}
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
}
