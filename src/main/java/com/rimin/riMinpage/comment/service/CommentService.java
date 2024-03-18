package com.rimin.riMinpage.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.riMinpage.comment.domain.Comment;
import com.rimin.riMinpage.comment.dto.CommentDetail;
import com.rimin.riMinpage.comment.repository.CommentRepository;
import com.rimin.riMinpage.user.domain.User;
import com.rimin.riMinpage.user.service.UserService;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UserService userService;
	
	public Comment addComment(int userId, int postId, String contents){
		
		Comment comment = Comment.builder()
					.userId(userId)
					.postId(postId)
					.contents(contents)
					.build();
		
		
		
		return commentRepository.save(comment);
		
	}
	
	
	// 댓글 목록 조회하는 기능
	// 특정한 게시글 목록에 대응하는 목록만 가져오기
	// list entity 클래스
	public List<CommentDetail> getCommentList(int postId){
		
		List<Comment> commentList = commentRepository.findByPostIdOrderByIdDesc(postId);
		
		List<CommentDetail> commentDetailList = new ArrayList<>();
		for(Comment comment:commentList) {
			
			
			User user = userService.getUserById(comment.getUserId());
			
			CommentDetail commentDetail = CommentDetail.builder()
												.commentId(comment.getId())
												.postId(comment.getPostId())
												.userId(comment.getUserId())
												.contents(comment.getContents())
												.userLoginId(user.getLoginId())
												.build();
		
			commentDetailList.add(commentDetail);
		
		}
		
		return commentDetailList;
		
	}
	
	
	
	
}
