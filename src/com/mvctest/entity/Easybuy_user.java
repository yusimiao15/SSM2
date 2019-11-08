package com.mvctest.entity;

import org.hibernate.validator.constraints.NotEmpty;

import com.mvctest.validate.UserLogin;
import com.mvctest.validate.UserRegist;

public class Easybuy_user {
	private int id;
	@NotEmpty(groups={UserLogin.class,UserRegist.class},message="请输入账户!")
	private String loginName;
	@NotEmpty(groups={UserRegist.class},message="请输入用户名!")
	private String userName;
	@NotEmpty(groups={UserLogin.class,UserRegist.class},message="请输入密码!")
	private String password;
	private Integer sex;
	@NotEmpty(groups={UserRegist.class},message="请输入身份证号码!")
	private String identityCode;
	@NotEmpty(groups={UserRegist.class},message="请输入邮箱!")
	private String email;
	@NotEmpty(groups={UserRegist.class},message="请输入手机号!")
	private String mobile;
	private Integer type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}
