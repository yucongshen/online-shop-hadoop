package cn.ssh.shop.message.service;

import java.util.List;

import cn.ssh.shop.firstcategory.vo.FirstCategory;
import cn.ssh.shop.message.dao.MessageDao;
import cn.ssh.shop.message.vo.Message;
import cn.ssh.shop.utils.PageBean;

public class MessageService {
	private MessageDao messageDao;

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public void save(Message message) {
		messageDao.save(message);
		
	}

	public PageBean<Message> findByPage(Integer page) {
		PageBean<Message> pageBean=new PageBean<Message>();
		pageBean.setPage(page);
		int limit=10;
		int totalCount=0;
		totalCount=messageDao.findCount();
		pageBean.setTotalCount(totalCount);
		Integer totalPage=0;
		if(totalCount<=limit){
			totalPage=1;
		}else{
			if(totalCount%limit==0){
				totalPage=totalCount/limit;
			}else{
				totalPage=totalCount/limit+1;
			}
		}
		pageBean.setTotalPage(totalPage);
		int begin =(page-1)*limit;
		List<Message>list=messageDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public Message findByMid(Integer mid) {
		return messageDao.findByMid(mid);
	}

	public void delete(Message message) {
		messageDao.delete(message);
		
	}
}
