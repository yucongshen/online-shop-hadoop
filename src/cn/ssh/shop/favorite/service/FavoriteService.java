package cn.ssh.shop.favorite.service;

import java.util.List;

import cn.ssh.shop.favorite.dao.FavoriteDao;
import cn.ssh.shop.favorite.vo.Favorite;
import cn.ssh.shop.order.vo.Order;
import cn.ssh.shop.utils.PageBean;

public class FavoriteService {
	private FavoriteDao favoriteDao;

	public void setFavoriteDao(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}

	public void add(Favorite favorite) {
		favoriteDao.add(favorite);
		
	}

	public PageBean<Favorite> findPageByUid(Integer uid, Integer page) {
		PageBean<Favorite> pageBean=new PageBean<Favorite>();
		pageBean.setPage(page);
		int limit=5;
		pageBean.setLimit(limit);
		int totalCount=0;
		totalCount=favoriteDao.findCountByUid(uid);
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
		List<Favorite> list=favoriteDao.findPageByUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public Favorite findByPidAndUid(Integer pid,Integer uid) {
		return favoriteDao.findByPidAndUid(pid,uid);
	}

	public void delete(Favorite favorite) {
		favoriteDao.delete(favorite);
		
	}

	public List<Favorite> findByUid(Integer uid) {
		return favoriteDao.findByUid(uid);
	}
	

}
