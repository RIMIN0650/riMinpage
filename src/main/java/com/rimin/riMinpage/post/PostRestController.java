package com.rimin.riMinpage.post;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@RestController
public class PostRestController {
	
	@PostMapping("/post/create")
	public Map<String, String> uploadPost(
			 @RequestParam("contents") String contents
			, @RequestParam("imageFile") MultipartFile file
			, HttpSession session){
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
