package com.mvctest.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvctest.entity.User;
@Controller
public class UseController {
	@RequestMapping("/Login.action")
	public ModelAndView login(@RequestParam("userName")String a,@RequestParam("userPwd")String b)throws Exception {
		System.out.println("ÕËºÅ£º"+a+",ÃÜÂë£º"+b);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		mv.addObject("user", "¹þ¹þ¹þ¹þ");
		return mv;
	}
	@RequestMapping("/reg.action")
	public String regist(User user,Model m)throws Exception {
		
		if(user.getUserName()!=null){
			System.out.println("ÕËºÅ£º"+user.getUserName());
		}
		if(user.getUserPwd()!=null){
			System.out.println("ÃÜÂë£º"+user.getUserPwd());
		}
		if(user.getUserAge()!=null){
			System.out.println("ÄêÁä£º"+user.getUserAge());
		}
		if(user.getUserLike()!=null){
			for(String i:user.getUserLike()){
				System.out.println(i+" ");
			}
		}
		m.addAttribute("user", user.getUserName());
		return "welcome";
	}
}
