package com.rimin.riMinpage.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class PostController {
	
	// 메인 페이지
	@GetMapping("/post/homepage")
	public String mainPage() {
		return "post/homepage";
	}
	
	@GetMapping("/post/uploadpost")
	public String uploadPost() {
		return "post/uploadpost";
	}
	
	
	// 로그인한 사용자의 메모 목록을 조회하기
	@GetMapping("/post/list-view")
	public String postList(
				HttpSession session
				, Model model) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		
		
		
	}
	
	
	
	
}
