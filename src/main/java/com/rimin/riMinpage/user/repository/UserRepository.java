package com.rimin.riMinpage.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rimin.riMinpage.user.domain.User;

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
	
	
	// 로그인 기능 아이디 비밀번호 확인하기
	public User checkUser(
			@Param("loginId") String loginId
			, @Param("password") String password);
	
	
	//아이디와 일치하는 한 행의 정보를 return
	public User selectUserById(@Param("id") int id);
	
	
	
}
