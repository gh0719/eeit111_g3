package com.fund.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Autowired
	private SessionFactory sessionFactory ;
	
	@RequestMapping(path = "/")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping(path = "/ajax")
	public String ajaxTestPage() {
		return "ajaxTestPage";
	}
	
	/**
	 * @映射路徑到register
	 */
	@RequestMapping(path = "/register")
	public String register() {
		return "MemberSystem/register";
	}

	/**
	 * @映射路徑到loginSystem
	 */
	@RequestMapping(path = "/loginSystem")
	public String loginSystem() {
		return "MemberSystem/loginSystem";
	}
	
	/**
	 * @映射路徑到registerStore
	 */
	@RequestMapping(path = "/registerStore")
	public String registerStore() {
		return "Store/storeRegister";
	}
}
