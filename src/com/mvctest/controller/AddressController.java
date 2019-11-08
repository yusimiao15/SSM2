package com.mvctest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvctest.entity.Easybuy_user;
import com.mvctest.entity.Easybuy_user_address;
import com.mvctest.service.Easybuy_userService;

@Controller
public class AddressController {
	@Autowired
	private Easybuy_userService service;
	@RequestMapping("/initAdd")
	public String initadd(){
		return "WEB-INF/papper/address";
	}
	@RequestMapping("/Addaddress")
	public String addAddress(Easybuy_user_address address,Model m){
		address.setCreateTime(new Date());
		if(address.getIsDefault()==null){
			address.setIsDefault(0);
		}
		boolean isok = service.addAddr(address);
		if(isok){
			m.addAttribute("msg", "新增成功！");
		}else{
			m.addAttribute("msg", "新增失败！");
		}
		return "WEB-INF/papper/address";
	}
	@ModelAttribute("userList")
	public List<Easybuy_user> query() throws Exception{
		return service.queryUser();
	}
}