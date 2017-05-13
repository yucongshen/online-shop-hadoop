package cn.ssh.shop.index.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.ssh.shop.firstcategory.service.FirstCategoryService;
import cn.ssh.shop.firstcategory.vo.FirstCategory;
import cn.ssh.shop.product.service.ProductService;
import cn.ssh.shop.product.vo.Product;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport implements SessionAware{
	private FirstCategoryService firstCategoryService;
	private ProductService productService;
	private Map<String, Object> session;
	
	

	public void setFirstCategoryService(FirstCategoryService firstCategoryService) {
		this.firstCategoryService = firstCategoryService;
	}


	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String execute()
	{
		List<FirstCategory> clist=firstCategoryService.findAll();
		session.put("clist", clist);
		List<Product> hotList=productService.findHot();
		ActionContext.getContext().getValueStack().set("hotList", hotList);
		List<Product> newList=productService.findNew();
		ActionContext.getContext().getValueStack().set("newList", newList);
		List<Product> bestList=productService.findBest();
		ActionContext.getContext().getValueStack().set("bestList", bestList);
		return "index";
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

}
