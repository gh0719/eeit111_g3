package com.fund.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(path = "/")
	public String homePage() {
		return "home";
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
}
