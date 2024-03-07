package com.rimin.riMinpage.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
	
	// 문자열을 암호화 하는 기능
	// Hashing - md5(알고리즘) 이용
	// 암호화 할 문자열을 전달받고, 암호화된 문자열 return 
	
	public static String md5(String message) {
		String result = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			
			// 문자열을 byte 타입 데이터로 변환
			byte[] bytes = message.getBytes();
			md.update(bytes);
			
			//암호화된 결과
			byte[] digest = md.digest();
			
			// byte 배열을 문자열로 변경
			// 16진수 숫자 형태로
			for(int i = 0; i < digest.length; i++) {
				result += Integer.toHexString(digest[i] & 0xff);
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}		
		
		return result;
	}
	
	
}
