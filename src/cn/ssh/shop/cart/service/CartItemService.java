package cn.ssh.shop.cart.service;

import java.util.List;

import cn.ssh.shop.cart.dao.CartItemDao;
import cn.ssh.shop.cart.vo.CartItem;
import cn.ssh.shop.favorite.vo.Favorite;
import cn.ssh.shop.utils.PageBean;

public class CartItemService {
	private CartItemDao cartItemDao;

	public void setCartItemDao(CartItemDao cartItemDao) {
		this.cartItemDao = cartItemDao;
	}

	public void save(CartItem cartItem1) {
		cartItemDao.save(cartItem1);
		
	}
	public CartItem findByPidAndCartid(Integer cartid,Integer pid) {
		return cartItemDao.findByPidAndCartid(cartid,pid);
	}
	
	public void update(Integer cartitemid, int newCount, float newSubtotal) {
		cartItemDao.update(cartitemid,newCount,newSubtotal);
		
	}

	public PageBean<CartItem> findPageByCaritid(Integer cartid, Integer page) {
		PageBean<CartItem> pageBean=new PageBean<CartItem>();
		pageBean.setPage(page);
		int limit=5;
		pageBean.setLimit(limit);
		int totalCount=0;
		totalCount=cartItemDao.findCountByCartid(cartid);
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
		int begin=(page-1)*limit;
		List<CartItem> list=cartItemDao.findPageByCartid(cartid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public CartItem findByCartitemid(Integer cartitemid) {
		return cartItemDao.findByCaritemid(cartitemid);
	}

	public void delete(CartItem cartItem) {
		cartItemDao.delete(cartItem);
		
	}

	public List<CartItem> findByCartid(Integer cartid) {
		return cartItemDao.findByCartid(cartid);
	}
	

}
