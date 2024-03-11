package com.rimin.riMinpage.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
	
	// 메인 페이지
	@GetMapping("/post/homepage")
	public String mainPage() {
		return "post/homepage";
	}
	
}
