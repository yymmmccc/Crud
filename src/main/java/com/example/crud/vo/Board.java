package com.example.crud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  // toString, getter, setter 메서드를 자동으로 만들어줌
@AllArgsConstructor // 사용자가 도메인에 값을 요청하면 알아서 생성자를 만듦
public class Board {
	
	private int id;
	private int type;
	private String title;
	private String body;
	private String memberId;
	private String nickname;
	private String regDate;
	private String updateDate;
	
}
