package com.rimin.riMinpage.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {
	
	// 사용자 추가
	public int insertUser(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("name") String name
			, @Param("email") String email);
	
	
	// Id 중복 여부 확인
	public int checkDupId(@Param("loginId") String loginId);
	
	
}
