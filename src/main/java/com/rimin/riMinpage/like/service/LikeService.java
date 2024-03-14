package com.rimin.riMinpage.like.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.riMinpage.like.domain.Like;
import com.rimin.riMinpage.like.repository.LikeRepository;

@Service
public class LikeService {
	
	@Autowired
	private LikeRepository likeRepository;
	
	// 게시글 id , 누가 좋아요 눌렀는지 : userId
	public Like addLike(int postId, int userId) {
		
		Like like = Like.builder()
		.postId(postId) // 멤버변수이름(parameter id)
		.userId(userId)
		.build();
		
		
		return likeRepository.save(like);
		
	}
	
	
	
	
	
}
