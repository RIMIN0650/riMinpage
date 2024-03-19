package com.rimin.riMinpage.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rimin.riMinpage.post.domain.Post;
import com.rimin.riMinpage.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RestController
public class PostRestController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/post/create")
	public Map<String, String> createPost(
			@RequestParam("contents") String contents
			, @RequestParam(value="imageFile", required=false) MultipartFile imageFile
			// required=false : 꼭 전달받지 않아도 되게 해줌
			, HttpSession session){
		
		// 로그인한 사용자의 user table id가 세션에 저장되어있음
		
		// getAttribute : object 이기 때문에 downcasting 과정 필요함 
		int userId = (Integer)session.getAttribute("userId");
		//2개는 파라미터로 1개는 세션으로부터 값 얻어옴
		
		Post post = postService.addPost(userId, contents, imageFile);
		
		Map<String, String> resultMap = new HashMap<>();
		if(post != null) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
	
	// 게시물 지워주기
	@DeleteMapping("/post/delete")
	public Map<String, String> deleteContents(@RequestParam("id") int id){
		Post post = postService.deletePost(id);
		
		
		
		Map<String, String> resultMap = new HashMap<>();
		if(post != null) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	
	// 댓글 지워주기
	
	
	
}
