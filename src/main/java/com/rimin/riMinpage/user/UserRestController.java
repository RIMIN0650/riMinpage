package com.rimin.riMinpage.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rimin.riMinpage.user.domain.User;
import com.rimin.riMinpage.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
//@Controller + @ResponseBody = @RestController
@RestController 
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/user/join")
	public Map<String, String> join(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("email") String email){
		
		int count = userService.addUser(loginId, password, name, email);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result","success");
		} else {
			resultMap.put("result","fail");
		}
		
		return resultMap;
	}
	
	
	// 중복 id 확인하기
	@GetMapping("/user/duplicate-id")
	public Map<String, Boolean> isDuplicateId(@RequestParam("loginId") String loginId){
		
		boolean isDuplicateId = userService.isDuplicateId(loginId);
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		resultMap.put("isDuplicateId",  isDuplicateId);
		
		return resultMap;
		
		
	}
	
	
	
	// 로그인 기능
	@PostMapping("/user/login")
	public Map<String, String> login(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, HttpServletRequest request){
		
		User user = userService.getUser(loginId, password);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(user != null) {
			// 사용자 정보를 session 에 저장해서
			// HttpServletRequest 로부터 Session 객체를 얻어온다.
			HttpSession session = request.getSession();
			// 세션에 로그인 되었다는 정보, 사용자 정보를 저장하고
			// 세션에 사용자 정보가 저장되어있으면 로그인
			
			session.setAttribute("userId",  user.getId());
			session.setAttribute("loginId", user.getLoginId());
			
			resultMap.put("result",  "success");
		} else {
			resultMap.put("result",  "fail");
		}
		return resultMap;
	}
}
