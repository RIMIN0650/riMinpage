package com.rimin.riMinpage.post.dto;

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
	private String userLoginId;
	private String contents; // 게시글 내용
	private String imagePath;
	private String comment;
	
}
