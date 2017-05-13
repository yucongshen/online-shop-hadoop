package cn.ssh.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ssh.shop.firstcategory.vo.FirstCategory;
import cn.ssh.shop.product.vo.Product;
import cn.ssh.shop.secondcategory.vo.SecondCategory;
import cn.ssh.shop.utils.PageHibernateCallback;

public class ProductDao extends HibernateDaoSupport{

	public List<Product> findHot() {
		//使用离线条件查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//查询热门商品的条件是is_hot=1
		criteria.add(Restrictions.eq("is_hot", 1));
		//倒序排序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria,0,10);
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public List<Product> findNew() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria,0,4);
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	public int findCountByCid(Integer cid) {
		String hql="select count(*) from Product p where p.secondCategory.firstCategory.cid=?";
		List<Long> list=this.getHibernateTemplate().find(hql,cid);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Product> findByPageCid(Integer cid, int begin, Integer limit) {
		String hql = "select p from Product p join p.secondCategory cs join cs.firstCategory c where c.cid = ?";
		//分页另一种写法
		List<Product> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public int findCountByCsid(Integer csid) {
		String hql="select count(*) from Product p where p.secondCategory.csid=?";
		List<Long> list=this.getHibernateTemplate().find(hql,csid);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Product> findByPageCsid(Integer csid, int begin, Integer limit) {
		String hql="select p from Product p join p.secondCategory cs where cs.csid=?";
		List<Product> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public List<Product> findBest() {
		//使用离线条件查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//查询热门商品的条件是is_hot=1
		criteria.add(Restrictions.eq("is_hot", 2));
		//倒序排序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria,0,10);
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public List<Product> findLike(Integer csid, Integer pid) {
		String hql="from Product where csid=? and pid!=?";
		List<Product> list=this.getHibernateTemplate().find(hql,csid,pid);
		if(list!=null&&list.size()>0){
			return list;
		}
		return null; 
	}

//	public String findCnameByCid(Integer cid) {
//		String hql="select cname from Category where cid=?";
//		List<String> list=this.getHibernateTemplate().find(hql,cid);
//		if(list!=null&&list.size()>0){
//			return list.get(0);
//		}
//		return null; 
//	}

	public FirstCategory findCategoryByCid(Integer cid) {
		String hql="from FirstCategory where cid=?";
		List<FirstCategory> list=this.getHibernateTemplate().find(hql,cid);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null; 
	}

	public int findCount() {
		String hql="select count(*) from Product";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Product> findByPage(int begin, int limit) {
		String hql="from Product order by pdate";
		List<Product> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, null, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public void save(Product product) {
		this.getHibernateTemplate().save(product);
		
	}

	public void update(Product product) {
		this.getHibernateTemplate().update(product);
		
	}

	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
		
	}

	public List<Product> search(String match) {
		String hql="from Product p where p.pname like ?";
		List<Product> list=this.getHibernateTemplate().find(hql, '%' + match + '%');
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
}
