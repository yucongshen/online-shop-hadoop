package cn.ssh.shop.firstcategory.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.shop.firstcategory.dao.FirstCategoryDao;
import cn.ssh.shop.firstcategory.vo.FirstCategory;
import cn.ssh.shop.utils.PageBean;

@Transactional
public class FirstCategoryService {
	private FirstCategoryDao firstCategoryDao;

	
	public void setFirstCategoryDao(FirstCategoryDao firstCategoryDao) {
		this.firstCategoryDao = firstCategoryDao;
	}
	public List<FirstCategory> findAll() {
		return firstCategoryDao.findAll();
	}
	public void save(FirstCategory firstCategory) {
		firstCategoryDao.save(firstCategory);
		
	}
	public FirstCategory findByCid(Integer cid) {
		return firstCategoryDao.findByCid(cid);
	}
	public void delete(FirstCategory firstCategory) {
		firstCategoryDao.delete(firstCategory);
		
	}
	public void update(FirstCategory firstCategory) {
		firstCategoryDao.update(firstCategory);
		
	}
	public PageBean<FirstCategory> findByPage(Integer page) {
		PageBean<FirstCategory> pageBean=new PageBean<FirstCategory>();
		pageBean.setPage(page);
		int limit=10;
		int totalCount=0;
		totalCount=firstCategoryDao.findCount();
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
		List<FirstCategory>list=firstCategoryDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

}
