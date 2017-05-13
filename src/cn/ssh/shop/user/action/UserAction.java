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
	//AjaxУ���û����Ƿ����
	public String findByName() throws IOException
	{
		User exitUser=userService.findByUsername(user.getUsername());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(exitUser!=null){
			response.getWriter().print("<font color='white'>�û����Ѵ���!!</font>");
		}
		return NONE;
	}
	//AjaxУ�������Ƿ����
	public String findByEMail() throws IOException
	{
		User exitUser=userService.findByMail(user.getEmail());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(exitUser!=null){
			response.getWriter().print("<font color='white'>�������ѱ�ע��!!</font>");
		}
		return NONE;
	}

	public String regist()
	{
		User user1=userService.findByUsername(user.getUsername());
		if(user1!=null){
			this.addActionMessage("���û����ѱ�ע�ᣬ������û�����");
			return "info";
		}
		User user2=userService.findByMail(user.getEmail());
		if(user2!=null){
			this.addActionMessage("�������ѱ�ע�ᣬ��������䣡");
			return "info";
		}
		String checkcode1=(String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addActionError("��֤�����!");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("ע��ɹ�����ȥ���伤�");
		return "info";
	}
	public String active()
	{
		//���ݼ������ѯ�û�
		User exitUser=userService.findByCode(user.getCode());
		//�ж�
		if(exitUser==null){
			this.addActionMessage("��������󣡣�����ʧ�ܣ�");
		}else{
			exitUser.setState(1);
			exitUser.setCode(null);
			userService.update(exitUser);
			this.addActionMessage("����ɹ������¼��");
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
			this.addActionError("��¼ʧ�ܣ�(�û�������������δ�ɹ�����)");
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
			this.addActionError("ԭʼ���벻��ȷ��");
		}else if(!newPassword.equals(renewPassword)){
			this.addActionError("�������������벻һ�£�");
		}else{
			this.addActionMessage("�޸�����ɹ���");
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
			this.addActionMessage("�������");
			return "info";
		}else{
			String code=UUIDUtils.getUUID();
			user.setCode(code);
			userService.update(user);
			ResetMailUtils.sendMail(user.getEmail(),user.getCode());
			this.addActionMessage("������֤�ɹ�����ȥ���䣬������������������룡");
			return "info";
		}
	}
	public String resetPasswordPage(){
		user=userService.findByCode(user.getCode());
		if(user==null){
			this.addActionMessage("��������ʧЧ��");
			return "info";
		}
		return "resetPasswordPage";
	}
	public String reset(){
		if(user==null){
			this.addActionMessage("��ҳ����ʧЧ��");
		}
		if(!newPassword.equals(renewPassword)){
			this.addActionError("�������������벻һ�£�");
		}else{
			this.addActionMessage("��������ɹ���");
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
		this.addActionMessage("�޸ĳɹ���");
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
