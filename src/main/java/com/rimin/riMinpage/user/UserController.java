package com.rimin.riMinpage.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	// 회원가입 페이지
	@GetMapping("/user/join-view")
	public String inputJoin() {
		return "user/join";
	}
	
	// 로그인 페이지
	@GetMapping("/user/login")
	public String logIn() {
		return "user/login";
	}
	
	// 메인 페이지
	@GetMapping("/user/homepage")
	public String mainPage() {
		return "user/homepage";
	}
}
