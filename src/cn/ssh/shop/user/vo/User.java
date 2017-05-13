package cn.ssh.shop.user.vo;
//CREATE TABLE `user` (
//		  `uid` int(11) NOT NULL AUTO_INCREMENT,
//		  `username` varchar(255) DEFAULT NULL,
//		  `password` varchar(255) DEFAULT NULL,
//		  `name` varchar(255) DEFAULT NULL,
//		  `email` varchar(255) DEFAULT NULL,
//		  `phone` varchar(255) DEFAULT NULL,
//		  `addr` varchar(255) DEFAULT NULL,
//		  `state` int(11) DEFAULT NULL,
//		  `code` varchar(64) DEFAULT NULL,
//		  PRIMARY KEY (`uid`)
//		) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
public class User {
	private Integer userid;
	private String username;
	private String pass;
	private String realname;
	private String email;
	private String phone;
	private String addr;
	private Integer state;
	private String code;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	

}
