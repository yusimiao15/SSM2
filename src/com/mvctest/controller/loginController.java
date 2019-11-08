package com.mvctest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class loginController extends AbstractController {
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		String zh = req.getParameter("zh");
		String pwd = req.getParameter("mm");
		System.out.println("’À∫≈£∫"+zh+"√‹¬Î£∫"+pwd);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("welcome");
		return mav;
	}

}