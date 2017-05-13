package cn.ssh.shop.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.shop.secondcategory.vo.SecondCategory;
import cn.ssh.shop.user.dao.UserDao;
import cn.ssh.shop.user.vo.User;
import cn.ssh.shop.utils.MailUtils;
import cn.ssh.shop.utils.PageBean;
import cn.ssh.shop.utils.UUIDUtils;
@Transactional
public class UserService {
	//按用户名查询dao中方法
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public User findByUsername(String username)
	{
		return userDao.findByUsername(username);
	}
	public void save(User user) {
		user.setState(0);//0代表未激活，1代表已激活
		String code=UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		MailUtils.sendMail(user.getEmail(), code);
	}
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}
	public void update(User exitUser) {
		userDao.update(exitUser);
		
	}
	public User login(User user) {
		return userDao.login(user);
	}
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean=new PageBean<User>();
		pageBean.setPage(page);
		int limit=10;
		int totalCount=0;
		totalCount=userDao.findCount();
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
		List<User>list=userDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public User findByUid(Integer uid) {
		return userDao.findByUid(uid);
	}
	public void delete(User user) {
		userDao.delete(user);
		
	}
	public User findByMail(String email) {
		return userDao.findByMail(email);
	}

}
