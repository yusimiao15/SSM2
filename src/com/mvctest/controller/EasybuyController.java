package com.mvctest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sun.management.snmp.AdaptorBootstrap.DefaultValues;

import com.alibaba.fastjson.JSON;
import com.mvctest.entity.Easybuy_user;
import com.mvctest.entity.Easybuy_user_address;
import com.mvctest.entity.PageBean;
import com.mvctest.service.Easybuy_userService;
import com.mvctest.validate.UserLogin;
import com.mvctest.validate.UserRegist;

import javax.servlet.http.HttpSession;

@Controller
public class EasybuyController {
	//private Easybuy_userService service = new Easybuy_userServiceimpl();
	@Autowired
	private Easybuy_userService service;
	@RequestMapping("/easybuyLogin")
	public ModelAndView login(@Validated(value=UserLogin.class) Easybuy_user param, BindingResult r, HttpSession session)throws Exception {
		ModelAndView mv = new ModelAndView();
		if(r.hasFieldErrors()){
			mv.setViewName("easybuyLogin");
			return mv;
		}else{
			Easybuy_user user = service.Login(param.getLoginName(), param.getPassword());
			if(user==null){
				mv.setViewName("easybuyLogin");
				mv.addObject("msg", "用户名或密码错误！");
				return mv;
			}else{
				mv.setViewName("/WEB-INF/manager/main");
				session.setAttribute("user",user);
				mv.addObject("user", user.getLoginName());
				return mv;
			}
		}
	}
	
	@RequestMapping("/queryByPage")
	public String queryByPage(@RequestParam(defaultValue="1")Integer pageIndex,@ModelAttribute Easybuy_user user,Model m){
		 int pageSize=2;
	   	 int count=service.pageCount(user);
	   	 int pageCount=(count%pageSize==0)?count/pageSize:count/pageSize+1;
	   	 if(pageIndex<1 || pageIndex>pageCount){
	   		 pageIndex=1;
	   	 }
	   	 PageBean pa=new PageBean();
	   	 pa.setPageIndex(pageIndex);   	 
	   	 pa.setPageCount(pageCount);
	   	 pa.setRecord(count);
	   	 List<Easybuy_user> lista=service.selectuserByPage((pageIndex-1)*pageSize, pageSize, user);
	   	 pa.setDataList(lista);
	   	 m.addAttribute("pagebean",pa);
		return "/WEB-INF/manager/memberList";
	}
	
	@RequestMapping("/easybuyReg")
	public ModelAndView regist(@Validated(value=UserRegist.class) Easybuy_user user,BindingResult r)throws Exception {
		ModelAndView mv = new ModelAndView();
		if(r.hasFieldErrors()){
			mv.setViewName("easybuyReg");
			return mv;
		}else{
			boolean flag = service.insert(user);
			if(flag){
				mv.setViewName("easybuyReg");
				mv.addObject("msg", "注册成功!");
				return mv;
			}else{
				mv.setViewName("easybuyReg");
				mv.addObject("msg", "注册失败!");
				return mv;
			}
		}
		
	}
	
	@RequestMapping("/checkLoginName")
	@ResponseBody
	public String checkLoginName(String zh) throws Exception{
		boolean isok = service.getCount(zh);
		String rs = "{\"msg\":0}";
		if(isok){
			rs="{\"msg\":1}";
		}
		return rs;
	}
	
	@RequestMapping("/showUserList")
	@ResponseBody
	public List<Easybuy_user> showUserList() throws Exception{
		List<Easybuy_user> list = service.queryUser();
		return list;
	}
	
	@RequestMapping("/showAddList")
	@ResponseBody
	public List<Easybuy_user_address> showAddList() throws Exception{
		List<Easybuy_user_address> list = service.addList();
		return list;
	}
	
	@RequestMapping("/deleteUser/{a}/{b}")
	public String deleteUser(@PathVariable("a") Integer id,@PathVariable("b") Integer pwd){
		System.out.println("ID是"+id);
		System.out.println("密码是"+pwd);
		return "UserList";
	}
}
