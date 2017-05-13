package cn.ssh.shop.firstcategory.action;

import cn.ssh.shop.firstcategory.service.FirstCategoryService;
import cn.ssh.shop.firstcategory.vo.FirstCategory;
import cn.ssh.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FirstCategoryManageAction extends ActionSupport implements ModelDriven<FirstCategory>{
	private FirstCategory firstCategory=new FirstCategory();
	private FirstCategoryService firstCategoryService;
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public void setFirstCategoryService(FirstCategoryService firstCategoryService) {
		this.firstCategoryService = firstCategoryService;
	}

	public String list(){
		PageBean<FirstCategory> pageBeanCategory=firstCategoryService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBeanCategory", pageBeanCategory);
		return "list";
	}
	public String save(){
		firstCategoryService.save(firstCategory);
		return "save";
	}
	public String delete(){
		firstCategory=firstCategoryService.findByCid(firstCategory.getCid());
		firstCategoryService.delete(firstCategory);
		return "delete";
	}
	public String edit(){
		firstCategory=firstCategoryService.findByCid(firstCategory.getCid());
		return "edit";
	}
	public String update(){
		firstCategoryService.update(firstCategory);
		return "update";
	}
	public FirstCategory getModel() {
		return firstCategory;
	}
	

}
