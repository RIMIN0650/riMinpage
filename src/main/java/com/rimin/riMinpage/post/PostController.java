package com.rimin.riMinpage.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rimin.riMinpage.post.dto.PostDetail;
import com.rimin.riMinpage.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	// 메인 페이지
	@GetMapping("/post/homepage")
	public String mainPage(
			HttpSession session
			, Model model) {
		
		// 로그인 할때 사용자의 정보를 userId에 저장해둠
		int userId = (Integer)session.getAttribute("userId"); // 로그인할때 저장한 값을 쓰기 위해
		
		List<PostDetail> postList = postService.getPostList(userId);
		model.addAttribute("postList", postList);
		
		return "post/homepage";
	}
		
	@GetMapping("/post/uploadpost")
	public String uploadPost() {
		return "post/uploadpost";
	}
	
	
}
