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
	
	
	// 좋아요 개수 얻어오기
	public int getLikeCount(int postId) {
		return likeRepository.countByPostId(postId);
	}
	
	
	// > like는 특정 사용자가 특정 게시물에 좋아요를 눌렀는지 알려주는 기능
	// select count(*) from `rimin_like` where postId = 1 AND `userId` = 3; 가 1 이상이면 좋아요를 눌렀다는 뜻
	// 나중에 취소 기능 만들면 수정하기
	public boolean isLike(int userId, int postId) {
		int count = likeRepository.countByUserIdAndPostId(userId, postId);
		
//		if(count > 0) {
//			// 특정 사용자가 특정 게시물에 좋아요 누른 상태
//			return true;
//		} else {
//			// 특정 사용자가 특정 게시물에 좋아요 안 누른 상태
//			return false;
//		}

		return count > 0;
	}
}
