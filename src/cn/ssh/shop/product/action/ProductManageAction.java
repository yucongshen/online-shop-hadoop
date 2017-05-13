package cn.ssh.shop.product.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.ssh.shop.product.service.ProductService;
import cn.ssh.shop.product.vo.Product;
import cn.ssh.shop.secondcategory.service.SecondCategoryService;
import cn.ssh.shop.secondcategory.vo.SecondCategory;
import cn.ssh.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductManageAction extends ActionSupport implements ModelDriven<Product>{
	private Product product=new Product();
	private ProductService productService;
	private Integer page;
	private SecondCategoryService secondCategoryService;
	//文件上传
	private File pimage;//上传的文件
	private String pimageFileName;//接收文件上传的文件名
	private String pimageContextType;//接收文件上传的文件的MIME类型
	
	public void setPimage(File pimage) {
		this.pimage = pimage;
	}

	
	public void setPimageFileName(String pimageFileName) {
		this.pimageFileName = pimageFileName;
	}


	public void setPimageContextType(String pimageContextType) {
		this.pimageContextType = pimageContextType;
	}


	
	public void setSecondCategoryService(SecondCategoryService secondCategoryService) {
		this.secondCategoryService = secondCategoryService;
	}


	public void setPage(Integer page) {
		this.page = page;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public String list(){
		PageBean<Product> pageBeanProduct=productService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBeanProduct", pageBeanProduct);
		return "list";
	}
	public String save() throws IOException{
		product.setPdate(new Date());
		if(pimage!=null){
			//获得文件上传的磁盘绝对路径
			String realPath=ServletActionContext.getServletContext().getRealPath("/products");
			//创建一个文件
			File diskFile=new File(realPath+"//"+pimageFileName);
			//文件上传
			FileUtils.copyFile(pimage, diskFile);
			product.setImage("products/"+pimageFileName);
		}
		productService.save(product);
		return "save";
	}
	public String edit(){
		product=productService.findByPid(product.getPid());
		List<SecondCategory> csList=secondCategoryService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "edit";
	}
	public String update() throws IOException{
		product.setPdate(new Date());
		if(pimage!=null){
			//先删除原来的图片
			String path=product.getImage();
			File file=new File(ServletActionContext.getServletContext().getRealPath("/"+path));
			file.delete();
			//获得文件上传的磁盘绝对路径
			String realPath=ServletActionContext.getServletContext().getRealPath("/products");
			//创建一个文件
			File diskFile=new File(realPath+"//"+pimageFileName);
			//文件上传
			FileUtils.copyFile(pimage, diskFile);
			product.setImage("products/"+pimageFileName);
		}
		productService.update(product);
		return "update";
	}
	public String delete(){
		product=productService.findByPid(product.getPid());
		String path=product.getImage();
		if(path!=null){
			String realPath=ServletActionContext.getServletContext().getRealPath("/"+path);
			File file=new File(realPath);
			file.delete();
		}
		productService.delete(product);
		return "delete";
	}
	public String addPage(){
		List<SecondCategory> csList=secondCategoryService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "addPage";
	}
	public Product getModel() {
		return product;
	}

}
