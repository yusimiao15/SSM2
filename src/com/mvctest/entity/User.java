package com.mvctest.entity;

public class User {
	private String userName;
	private String userPwd;
	private Integer userAge;
	private String[] userLike;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public String[] getUserLike() {
		return userLike;
	}
	public void setUserLike(String[] userLike) {
		this.userLike = userLike;
	}
	
}
