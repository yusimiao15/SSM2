package com.mvctest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mvctest.entity.Easybuy_user;

public interface Easybuy_userDAO {
	public Easybuy_user Login(@Param("name") String name,@Param("password") String password);
	
	public int insert(Easybuy_user user);
	
	public int getCount(@Param("loginName") String loginName);
	
	public List<Easybuy_user> selectuser();
	
	public List<Easybuy_user> selectuserByPage(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize,@Param("u")Easybuy_user user);
	
	public int pageCount(Easybuy_user user);
}
