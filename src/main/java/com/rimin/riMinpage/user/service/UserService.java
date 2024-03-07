package com.rimin.riMinpage.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimin.riMinpage.common.EncryptUtils;
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
}
