package cn.ssh.shop.secondcategory.action;

import java.util.List;

import cn.ssh.shop.firstcategory.service.FirstCategoryService;
import cn.ssh.shop.firstcategory.vo.FirstCategory;
import cn.ssh.shop.secondcategory.service.SecondCategoryService;
import cn.ssh.shop.secondcategory.vo.SecondCategory;
import cn.ssh.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SecondCategoryManageAction extends ActionSupport implements ModelDriven<SecondCategory>{
	private SecondCategory secondCategory=new SecondCategory();
	private SecondCategoryService secondCategoryService;
	private Integer page;
	private FirstCategoryService firstCategoryService;


	public void setFirstCategoryService(FirstCategoryService firstCategoryService) {
		this.firstCategoryService = firstCategoryService;
	}
	public void setPage(Integer page) {
		this.page = page;
	}

	public void setSecondCategoryService(SecondCategoryService secondCategoryService) {
		this.secondCategoryService = secondCategoryService;
	}


	public String list(){
		PageBean<SecondCategory> pageBean=secondCategoryService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "list";
	}
	public String addPage(){
		List<FirstCategory> cList=firstCategoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "addPage";
	}
	public String save(){
		secondCategoryService.save(secondCategory);
		return "save";
	}
	public String delete(){
		secondCategory=secondCategoryService.findByCsid(secondCategory.getCsid());
		secondCategoryService.delete(secondCategory);
		return "delete";
	}
	public String edit(){
		secondCategory=secondCategoryService.findByCsid(secondCategory.getCsid());
		List<FirstCategory> cList=firstCategoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "edit";
	}
	public String update(){
		secondCategoryService.update(secondCategory);
		return "update";
	}
	public SecondCategory getModel() {
		return secondCategory;
	}
}
