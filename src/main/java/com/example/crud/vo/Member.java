package com.example.crud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  // toString, getter, setter 메서드를 자동으로 만들어줌
@AllArgsConstructor // 사용자가 도메인에 값을 요청하면 알아서 생성자를 만듦
public class Member {

	private int id;
	private String loginId;
	private String loginPw;
	private String name;
	private String nickname;
	private String phoneNum;
	private String email;
	private String address;
	private String grade;
	private String regDate;
	private String updateDate;
}
