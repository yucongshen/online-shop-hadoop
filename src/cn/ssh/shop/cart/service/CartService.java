package cn.ssh.shop.cart.service;

import java.util.List;

import cn.ssh.shop.cart.dao.CartDao;
import cn.ssh.shop.cart.vo.Cart;
import cn.ssh.shop.cart.vo.CartItem;
import cn.ssh.shop.order.vo.Order;
import cn.ssh.shop.utils.PageBean;

public class CartService {
	private CartDao cartDao;

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public void save(Cart cart) {
		cartDao.save(cart);
		
	}

	public Cart findByUid(Integer uid) {
		return cartDao.findByUid(uid);
	}

	

	public void update(Integer cartid, float total) {
		cartDao.update(cartid, total);
		
	}

	public void delete(Cart cart) {
		cartDao.delete(cart);
		
	}

	
	

}
