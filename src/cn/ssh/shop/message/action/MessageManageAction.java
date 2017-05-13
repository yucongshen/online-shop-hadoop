package cn.ssh.shop.message.action;

import cn.ssh.shop.message.service.MessageService;
import cn.ssh.shop.message.vo.Message;
import cn.ssh.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MessageManageAction extends ActionSupport implements ModelDriven<Message>{
	private Message message=new Message();
	private MessageService messageService;
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public String list()
	{
		PageBean<Message> pageBeanMessage=messageService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBeanMessage", pageBeanMessage);
		return "list";
	}
	public String delete()
	{
		message=messageService.findByMid(message.getMid());
		messageService.delete(message);
		return "delete";
	}
	public String findByMid(){
		message=messageService.findByMid(message.getMid());
		return "findByMid";
	}
	public Message getModel() {
		return message;
	}

}
