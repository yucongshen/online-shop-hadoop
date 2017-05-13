package cn.ssh.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.shop.firstcategory.vo.FirstCategory;
import cn.ssh.shop.product.dao.ProductDao;
import cn.ssh.shop.product.vo.Product;
import cn.ssh.shop.secondcategory.vo.SecondCategory;
import cn.ssh.shop.utils.PageBean;
@Transactional
public class ProductService {
	private ProductDao productDao;
	

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


	public List<Product> findHot() {
		return productDao.findHot();
	}


	public List<Product> findNew() {
		return productDao.findNew();
	}


	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}


	public PageBean<Product> findByPageCid(Integer cid, Integer page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		Integer limit=12;
		pageBean.setLimit(limit);
		int totalCount=0;
		totalCount=productDao.findCountByCid(cid);
		Integer totalPage=0;
		//Math.ceil(totalCount/limit)向上取整
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
		List<Product> list=productDao.findByPageCid(cid,begin,limit);
		pageBean.setList(list);
			
		return pageBean;
	}


	public PageBean<Product> findByCsid(Integer csid, Integer page) {
		
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		Integer limit=6;
		pageBean.setLimit(limit);
		int totalCount=0;
		totalCount=productDao.findCountByCsid(csid);
		Integer totalPage=0;
		//Math.ceil(totalCount/limit)向上取整
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
		List<Product> list=productDao.findByPageCsid(csid,begin,limit);
		pageBean.setList(list);
			
		return pageBean;
	}


	public List<Product> findBest() {
		return productDao.findBest();
	}


	public List<Product> findLike(Integer csid, Integer pid) {
		return productDao.findLike(csid,pid);
	}


//	public String findCnameByCid(Integer cid) {
//		return productDao.findCnameByCid(cid);
//	}


	public FirstCategory findCategoryByCid(Integer cid) {
		return productDao.findCategoryByCid(cid);
	}
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		pageBean.setPage(page);
		int limit=9;
		int totalCount=0;
		totalCount=productDao.findCount();
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
		List<Product>list=productDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}


	public void save(Product product) {
		productDao.save(product);
		
	}


	public void update(Product product) {
		productDao.update(product);
		
	}


	public void delete(Product product) {
		productDao.delete(product);
		
	}


	public List<Product> search(String match) {
		
		return productDao.search(match);
	}



}
