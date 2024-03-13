package com.rimin.riMinpage.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.riMinpage.common.EncryptUtils;
import com.rimin.riMinpage.user.domain.User;
import com.rimin.riMinpage.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	// 회원가입
	public int addUser(String loginId, String password, String name, String email) {
		// 비밀번호 암호화
		String encryptPassword = EncryptUtils.md5(password);
		
		return userRepository.insertUser(loginId, encryptPassword, name, email);
		
	}
	
	// Id 중복 여부 판단
	public boolean isDuplicateId(String loginId) {
		int count = userRepository.checkDupId(loginId);
		
		if(count != 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	// 로그인 기능
	public User getUser(String loginId, String password) {
		String encryptPassword = EncryptUtils.md5(password);
		return userRepository.checkUser(loginId, encryptPassword);
	}
	
	
	//userid를 전달받고 대응되는 사용자 정보를 return
	// 아이디와 일치하는 한 행의 정보를 return 받음
	public User getUserById(int id){
		return userRepository.selectUserById(id);
	}
}
