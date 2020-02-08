package com.fund.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
	@RequestMapping(path="test123")
	public String homePage() {
		return "updateMember";
	}
}
