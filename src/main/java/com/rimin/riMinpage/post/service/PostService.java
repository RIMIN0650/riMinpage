package com.rimin.riMinpage.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.riMinpage.post.domain.Post;
import com.rimin.riMinpage.post.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post addPost(int userId, String title, String contents) {
		// 로그인 성공시 id 멤버변수가 세션에 저장됨
		
		Post post = Post.builder()
						.userId(userId)
						.contents(contents)
						.build();
		return postRepository.save(post);
		
		
		
	}
	
	
	
	
	
	
}
