package com.rimin.riMinpage.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
	
	// 로그아웃
	@GetMapping("/user/logout")
	public String logout(HttpServletRequest request) {
		// 로그아웃 : 세션에 저장된 사용자 정보를 제거하기
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("loginId");
		
		return "redirect:/user/login";
	}
	
	
}
