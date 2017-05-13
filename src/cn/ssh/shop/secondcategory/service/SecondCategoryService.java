package cn.ssh.shop.secondcategory.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.shop.secondcategory.dao.SecondCategoryDao;
import cn.ssh.shop.secondcategory.vo.SecondCategory;
import cn.ssh.shop.utils.PageBean;

@Transactional
public class SecondCategoryService {
	private SecondCategoryDao secondCategoryDao;

	

	public void setSecondCategoryDao(SecondCategoryDao secondCategoryDao) {
		this.secondCategoryDao = secondCategoryDao;
	}

	public PageBean<SecondCategory> findByPage(Integer page) {
		PageBean<SecondCategory> pageBean=new PageBean<SecondCategory>();
		pageBean.setPage(page);
		int limit=15;
		int totalCount=0;
		totalCount=secondCategoryDao.findCount();
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
		List<SecondCategory>list=secondCategoryDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public void save(SecondCategory secondCategory) {
		secondCategoryDao.save(secondCategory);
		
	}

	public void delete(SecondCategory secondCategory) {
		secondCategoryDao.delete(secondCategory);
		
	}

	public SecondCategory findByCsid(Integer csid) {
		return secondCategoryDao.findByCsid(csid);
	}

	public void update(SecondCategory secondCategory) {
		secondCategoryDao.update(secondCategory);
		
	}

	public List<SecondCategory> findAll() {
		return secondCategoryDao.findAll();
	}
}
