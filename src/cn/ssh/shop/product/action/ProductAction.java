package cn.ssh.shop.product.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.ssh.shop.firstcategory.service.FirstCategoryService;
import cn.ssh.shop.firstcategory.vo.FirstCategory;
import cn.ssh.shop.product.service.ProductService;
import cn.ssh.shop.product.vo.Product;
import cn.ssh.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements ModelDriven<Product>,SessionAware{
	private Product product=new Product();
	private ProductService productService;
	private FirstCategoryService firstCategoryService;
	private Integer page;
	private Integer csid;
	private String match;
	//接收分类的cid
	private Integer cid;
	
	public void setMatch(String match) {
		this.match = match;
	}
	private Map<String, Object> session;
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
	
	public void setFirstCategoryService(FirstCategoryService firstCategoryService) {
		this.firstCategoryService = firstCategoryService;
	}

	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public Product getModel() {
		return product;
	}
	public String findByPid()
	{
		//这样直接将product放到了值栈的栈顶
		product=productService.findByPid(product.getPid());
		if(product==null)
			System.out.println(product.getPid());
		List<Product> likeList=productService.findLike(product.getSecondCategory().getCsid(),product.getPid());
		ActionContext.getContext().getValueStack().set("likeList", likeList);
		return "findByPid";
	}
	public String findByCid()
	{
		//List<Category> cList=categoryService.findAll();
		PageBean<Product> pageBean=productService.findByPageCid(cid,page);//根据一级分裂查询商品，分页查询
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
//		String cname=productService.findCnameByCid(cid);
//		ActionContext.getContext().getValueStack().set("cname", cname);
		FirstCategory firstCategory=firstCategoryService.findByCid(cid);
		session.put("firstCategory", firstCategory);
		return "findByCid";
	}
	public String findByCsid()
	{
		PageBean<Product> pageBean=productService.findByCsid(csid,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}
	public String search(){
		List<Product> searchList=productService.search(match);
		ActionContext.getContext().getValueStack().set("searchList", searchList);
		return "search";
	}
}
