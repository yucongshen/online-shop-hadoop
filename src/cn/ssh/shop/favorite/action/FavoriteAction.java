package cn.ssh.shop.favorite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.ssh.shop.favorite.service.FavoriteService;
import cn.ssh.shop.favorite.vo.Favorite;
import cn.ssh.shop.product.service.ProductService;
import cn.ssh.shop.user.vo.User;
import cn.ssh.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FavoriteAction extends ActionSupport implements ModelDriven<Favorite>,SessionAware{
	private Map<String, Object> session;
	private Favorite favorite=new Favorite();
	private FavoriteService favoriteService;
	private ProductService productService;
	private Integer pid;
	private Integer page;
	
	
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public void setFavoriteService(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
	public String add(){
		User user=(User) session.get("exitUser");
		if(user==null){
			this.addActionMessage("请先登录！");
			return "info";
		}else if(favoriteService.findByPidAndUid(pid, user.getUserid())!=null){
			
			this.addActionMessage("收藏夹中已有该商品！，请不要重复添加！");
			return "info";
		}else{
			favorite.setUser(user);
			favorite.setProduct(productService.findByPid(pid));
			favoriteService.add(favorite);
			return "add";
		}
	}
	public String list()
	{
		User user=(User) session.get("exitUser");
		PageBean<Favorite> pageBeanFavorite=favoriteService.findPageByUid(user.getUserid(),page);
		ActionContext.getContext().getValueStack().set("pageBeanFavorite", pageBeanFavorite);
		return "list";
	}
	public String delete()
	{
		User user=(User) session.get("exitUser");
		favorite=favoriteService.findByPidAndUid(pid,user.getUserid());
		favoriteService.delete(favorite);
		return "delete";
	}
	public String clear()
	{
		User user=(User) session.get("exitUser");
		List<Favorite> list=favoriteService.findByUid(user.getUserid());
		for(int i=0;i<list.size();i++){
			favoriteService.delete(list.get(i));
		}
		return "clear";
	}
	public Favorite getModel() {
		return favorite;
	}

}
