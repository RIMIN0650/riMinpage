package com.rimin.riMinpage.like.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimin.riMinpage.like.domain.Like;

import jakarta.transaction.Transactional;

public interface LikeRepository extends JpaRepository<Like, Integer>  {
// generic : entity class & primary key type
	
	// select count(*) from `rimin_like` where postId = 1;
	public int countByPostId(int postId);
	
	
	// select count(*) from `rimin_like` where postId = 1 AND `userId` = 3; 가 1 이상이면 좋아요를 눌렀다는 뜻
	public int countByUserIdAndPostId(int userId, int postId);
	
	// WHERE `postId` = #{} AND `userId` = #{}
	public Optional<Like> findByPostIdAndUserId(int postId, int userId);
	// 한 행이 일치할 경우 Optional<Like>
	// 한 행의 정보가 null 일 수 있기 때문에
	
	
	// DELETE FROM `rimin_like` WHERE `postId` = #{}
	// delete 는 return type 없음
	@Transactional
	public void deleteByPostId(int postId);
	
	
	
}
