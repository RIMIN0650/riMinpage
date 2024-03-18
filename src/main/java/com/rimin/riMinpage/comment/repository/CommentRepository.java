package com.rimin.riMinpage.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimin.riMinpage.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

	//댓글 목록 불러오기
	//  WHERE `postId` = #{} ORDER BY `id` DESC
	// list안에 한 행의 정보를 저장하기 위한 entity class 넣어줌
	public List<Comment> findByPostIdOrderByIdDesc(int postId);
	
	
	
	
}
