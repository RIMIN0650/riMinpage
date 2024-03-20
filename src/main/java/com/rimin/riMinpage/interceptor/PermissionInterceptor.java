package com.rimin.riMinpage.interceptor;

import java.io.IOException;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PermissionInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler) throws IOException{
		
		HttpSession session = request.getSession();
		
		// null 처리하기 위해 Integer userId
		Integer userId = (Integer)session.getAttribute("userId");
		
		// 사용자가 입력한 url을 저장
		String uri = request.getRequestURI();
		
		// 로그인 안된 상태
		// 게시글 리스트, 게시글 작성 막기
		
		if(userId == null) {
			if(uri.startsWith("/post")) {
				response.sendRedirect("/user/login");
				return false;
			}
		} else {
			// 로그인이 된 경우 > 회원가입 페이지 막기
			// 게시글 리스트 페이지로 이동
			
			if(uri.startsWith("/user")) {
				response.sendRedirect("/post/homepage");
				return false;
			}
		}
		return true;

	}
	
	
	
	
	
	
	
	
}
