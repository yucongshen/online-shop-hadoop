package cn.ssh.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.shop.order.dao.OrderDao;
import cn.ssh.shop.order.vo.Order;
import cn.ssh.shop.product.vo.Product;
import cn.ssh.shop.utils.PageBean;
@Transactional
public class OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void save(Order order) {
		orderDao.save(order);
		
	}

	public PageBean<Order> findByPageUid(Integer uid, Integer page) {
		PageBean<Order> pageBean=new PageBean<Order>();
		pageBean.setPage(page);
		int limit=5;
		pageBean.setLimit(limit);
		int totalCount=0;
		totalCount=orderDao.findCountByUid(uid);
		pageBean.setTotalCount(totalCount);
		int totalPage=0;
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
		int begin=(page-1)*limit;
		List<Order> list=orderDao.findByPageUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
		
	}

	public void update(Order currOrder) {
		orderDao.update(currOrder);
		
	}

	public PageBean<Order> findByPage(Integer page) {
		PageBean<Order> pageBean=new PageBean<Order>();
		pageBean.setPage(page);
		int limit=15;
		int totalCount=0;
		totalCount=orderDao.findCount();
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
		List<Order>list=orderDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public void delete(Order order) {
		orderDao.delete(order);
		
	}

	

}
