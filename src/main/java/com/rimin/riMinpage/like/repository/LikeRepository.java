package com.rimin.riMinpage.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimin.riMinpage.like.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Integer>  {
// generic : entity class & primary key type
	
	// select count(*) from `rimin_like` where postId = 1;
	public int countByPostId(int postId);
	
	
	// select count(*) from `rimin_like` where postId = 1 AND `userId` = 3; 가 1 이상이면 좋아요를 눌렀다는 뜻
	public int countByUserIdAndPostId(int userId, int postId);
	
	
}
