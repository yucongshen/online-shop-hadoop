package cn.ssh.shop.message.action;

import cn.ssh.shop.message.service.MessageService;
import cn.ssh.shop.message.vo.Message;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MessageAction extends ActionSupport implements ModelDriven<Message>{
	private Message message=new Message();
	private MessageService messageService;
	
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public String page()
	{
		return "page";
	}
	public String save()
	{
		messageService.save(message);
		this.addActionMessage("您的意见已经反馈到我们的数据库，我们会尽快处理！");
		return "info";
	}
	public Message getModel() {
		return message;
	}
	

}
