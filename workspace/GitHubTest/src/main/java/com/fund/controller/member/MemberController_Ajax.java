package com.fund.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fund.util.Regular;

@Controller
public class MemberController_Ajax {
	@RequestMapping(path="/memberEmailRegular" ,produces = "text/html; charset=UTF-8")
	public @ResponseBody String emailRegular( @RequestParam String emailVal ) {
		
		String message ; 
		if(emailVal.matches(Regular.EMAIL))
			message = "格式正確" ;
		else if ( emailVal.length() == 0 ) {
			message =  "欄位不得為空" ;
		}
		else
			message = "請輸入正確的Email格式";
		
		return message ;
	}
	@RequestMapping(path="/registerPwdRegular" ,produces = "text/html; charset=UTF-8")
	public @ResponseBody String pwdRegular( @RequestParam String pwd ) {
		
		String message ; 
		if(pwd.matches((Regular.PASSWORD)))
			message = "格式正確" ;
		else if ( pwd.length() == 0 ) {
			message =  "欄位不得為空" ;
		}
		else
			message = "6~12長度 ,包含數字及英文字母";
		
		return message ;
	}
	
}
