package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 메인페이지 컨트롤러
@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String Home() {
		
		return "home/main";
	}
	
	@RequestMapping("/")
	public String Homes() {
		
		return "home/main";
	}
}
