package com.rimin.riMinpage.post.dto;

import java.util.List;

import com.rimin.riMinpage.comment.dto.CommentDetail;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostDetail {
	// 카드 화면을 구성하기 위해 필요한 데이터를 모아둔 클래스
	// entity 클래스는 한 테이블의 컬럼 이름에 대응되는 값을 저장하기 위함이고
	// 이 테이블은 카드 하나를 구성하기 위해 필요한 데이터를 모아둔 클래스 >> DTO
	private int postId; // pk는 들고다니면 유용하게 쓸 수 있음
	private int userId; // pk는 들고다니면 유용하게 쓸 수 있음
	private int likeCount; // 좋아요 개수 세기 위해
	
	
	// source getter setter 하면 is로 시작하는건 islike로만 되어있음
	// el태그 안에서 사용할때는 is 를 빼고 사용함 ${post.like } 로
	private boolean isLike; // 좋아요 했는지 안했는지 기록하기 위해
	
	private String userLoginId;
	private String contents; // 게시글 내용
	private String imagePath;
	
	
	private List<CommentDetail> commentList; 
}
