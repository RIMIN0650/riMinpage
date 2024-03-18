package com.rimin.riMinpage.comment.dto;

import lombok.Builder;
import lombok.Getter;



@Builder
@Getter
public class CommentDetail {

	// primary key 도 포함된 형태로 만들어주기
	

	private int commentId;//댓글 primary key
	private int userId;
	private int postId;
	
	// 댓글 내용, 작성자 id 
	private String userLoginId;
	private String contents;
		
}
