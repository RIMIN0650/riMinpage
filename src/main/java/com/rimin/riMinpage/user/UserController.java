package com.rimin.riMinpage.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


	@GetMapping("/user/join")
	public String inputJoin() {
		return "user/join";
	}
	
	@GetMapping("/user/login")
	public String logIn() {
		return "user/login";
	}
}
