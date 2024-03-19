package com.rimin.riMinpage.like.service;

import java.util.Optional;

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
	
	
	public Like deleteLike(int postId, int userId) {
		// 우리가 직접 만든 테이블은 직접 만들어줘야함
		Optional<Like> optionalLike = likeRepository.findByPostIdAndUserId(postId, userId);
		// null 일 수도 있어서 optional 만들어준거라 null일 경우 처리해주기
		Like like = optionalLike.orElse(null);
		
		if(like != null) {
			likeRepository.delete(like);
		} 
		// 조회된 결과가 있으면 삭제될 행 리턴
		return like;
		
	}
	
	
	// 게시물 삭제됐을 때 좋아요 삭제
	// postId 기반 삭제
	public void deleteLikeByPostId(int postId){
		// delete from `like` where `postid` = #{}
		
		// 좋아요는 좋아요가 0개일수도 있어서 어차피 조회를 한다고 해도 크게 의미를 가지지 않음
		// post는 id 를 정확하게 전달해서 확인하기 때문 > 있는지 없는지 확인이 됨
		// 좋아요는 있을수도 있고 없을 수도 있음
		
		likeRepository.deleteByPostId(postId);
		
	}
	
	
	
	
	
	
}
