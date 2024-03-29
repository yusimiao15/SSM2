package com.mvctest.entity;

import org.hibernate.validator.constraints.NotEmpty;

import com.mvctest.validate.UserLogin;
import com.mvctest.validate.UserRegist;

public class Easybuy_user {
	private int id;
	@NotEmpty(groups={UserLogin.class,UserRegist.class},message="�������˻�!")
	private String loginName;
	@NotEmpty(groups={UserRegist.class},message="�������û���!")
	private String userName;
	@NotEmpty(groups={UserLogin.class,UserRegist.class},message="����������!")
	private String password;
	private Integer sex;
	@NotEmpty(groups={UserRegist.class},message="����������֤����!")
	private String identityCode;
	@NotEmpty(groups={UserRegist.class},message="����������!")
	private String email;
	@NotEmpty(groups={UserRegist.class},message="�������ֻ���!")
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
