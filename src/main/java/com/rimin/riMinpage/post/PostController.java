package com.rimin.riMinpage.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rimin.riMinpage.post.dto.PostDetail;
import com.rimin.riMinpage.post.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	
	// 메인 페이지
	@GetMapping("/post/homepage")
	public String mainPage(Model model) {
		
		List<PostDetail> postList = postService.getPostList();
		model.addAttribute("postList", postList);
		
		return "post/homepage";
	}
	
	
	
	
	
	@GetMapping("/post/uploadpost")
	public String uploadPost() {
		return "post/uploadpost";
	}
	
	

	
	
	
	
}
