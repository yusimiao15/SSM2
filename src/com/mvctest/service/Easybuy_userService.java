package com.mvctest.service;

import java.util.List;

import com.mvctest.entity.Easybuy_user;
import com.mvctest.entity.Easybuy_user_address;

public interface Easybuy_userService {
	public Easybuy_user Login(String name, String password);
	public boolean insert(Easybuy_user user) throws Exception;
	public boolean getCount(String zh) throws Exception;
	public List<Easybuy_user> queryUser() throws Exception;
	public boolean addAddr(Easybuy_user_address add);
	public List<Easybuy_user_address> addList();
	public List<Easybuy_user> selectuserByPage(int pageIndex,int pageSize,Easybuy_user user);
	public int pageCount(Easybuy_user user);
}
