package com.mvctest.dao;

import java.util.List;

import com.mvctest.entity.Easybuy_user_address;

public interface Easybuy_addressDAO {
	public boolean addAddr(Easybuy_user_address address);
	public List<Easybuy_user_address> addList();
}
