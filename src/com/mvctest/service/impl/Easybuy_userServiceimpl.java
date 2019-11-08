package com.mvctest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mvctest.dao.Easybuy_addressDAO;
import com.mvctest.dao.Easybuy_userDAO;
import com.mvctest.entity.Easybuy_user;
import com.mvctest.entity.Easybuy_user_address;
import com.mvctest.service.Easybuy_userService;

@Service
public class Easybuy_userServiceimpl implements Easybuy_userService {
	@Autowired
	private Easybuy_userDAO dao;
	@Autowired
	private Easybuy_addressDAO addrdao;
	public Easybuy_user Login(String name, String password) {
		return dao.Login(name, password);
	}
	public boolean insert(Easybuy_user user) throws Exception{
		int count = dao.insert(user);
		if(count==1){
			return true;
		}
		return false;
	}
	public boolean getCount(String zh) throws Exception{
		if(dao.getCount(zh) == 1){
			return false;
		}else{
			return true;
		}
	}
	public List<Easybuy_user> queryUser() throws Exception {
		return dao.selectuser();
	}
	public boolean addAddr(Easybuy_user_address add) {
		boolean isok = addrdao.addAddr(add);
		return isok;
	}
	public List<Easybuy_user_address> addList() {
		return addrdao.addList();
	}
	public List<Easybuy_user> selectuserByPage(int pageIndex, int pageSize,
			Easybuy_user user) {
		return dao.selectuserByPage(pageIndex, pageSize, user);
	}
	public int pageCount(Easybuy_user user) {
		return dao.pageCount(user);
	}
}