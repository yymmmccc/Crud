package com.example.crud.service;


import org.springframework.stereotype.Service;

import com.example.crud.mapper.MemberMapper;
import com.example.crud.vo.Member;

@Service
public class MemberService {  
	
	MemberMapper memberMapper;
	
	MemberService(MemberMapper memberMapper){
		this.memberMapper = memberMapper;
	}
	
	public void doJoin(String loginId, String loginPw, String name, String nickname, String phoneNum, String email, String address){
			
		memberMapper.doJoin(loginId, loginPw, name, nickname, phoneNum, email, address);
			
	}

	public Member getMemberByLoginId(String loginId) {
		
		return memberMapper.getMemberByLoginId(loginId);
		
	}

	public void doModify(int id, String nickname, String phoneNum, String email, String address) {
		
		memberMapper.doModify(id, nickname, phoneNum, email, address);
	}
}
