package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import com.example.crud.message.Message;
import com.example.crud.service.MemberService;
import com.example.crud.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
		
	MemberService memberService;
	
	MemberController(MemberService memberService){
		this.memberService = memberService;
	}
	
	@RequestMapping("/member/join")
	public String Join() {
		
		
		return "/member/join";
	}
	
	@RequestMapping("/member/doJoin")
	@ResponseBody
	public String doJoin(String loginId, String loginPw, String name, String nickname
			, String phoneNum, String email, String address) {
		
		memberService.doJoin(loginId, loginPw, name, nickname, phoneNum, email, address);
	
		return Message.showAlertMovePage("정상적으로 회원가입이 되었습니다.", "/member/login");
		
	}
	
	@RequestMapping("/member/login")
	public String login() {
		
		
		return "/member/login";
	}
	
	@RequestMapping("/member/doLogin")
	@ResponseBody
	public String doLogin(HttpSession session, String loginId, String loginPw) {
		
		Member member = memberService.getMemberByLoginId(loginId);
		
		if(member == null) {
			return Message.showAlertBackPage("아이디 또는 비밀번호를 확인해주세요.");
		}
		
		if(!member.getLoginPw().equals(loginPw)) {
			return Message.showAlertBackPage("아이디 또는 비밀번호를 확인해주세요.");
		}
		
		session.setAttribute("member", member);
		
		//rq.login(member);
	
		return Message.movePage("/");
		
	}
	
	@RequestMapping("/member/logout")
	@ResponseBody
	public String Logout(HttpSession session) {
		
		session.removeAttribute("member");
		
		return Message.showAlertMovePage("로그아웃 되었습니다.", "/member/login"); 
	}
	
	@RequestMapping("member/myPage")
	public String showMyPage() {
		
		return "/member/myPage";
	}
	
	@RequestMapping("member/doModify")
	@ResponseBody
	public String doModify(int id, String nickname, String phoneNum, String email, String address) {
		
		memberService.doModify(id, nickname, phoneNum, email, address);
		
		return Message.showAlertMovePage("회원정보가수정되었습니다.", "myPage");
	}
}
