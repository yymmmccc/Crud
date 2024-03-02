package com.example.crud.dto;

import com.example.crud.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  // toString, getter, setter 메서드를 자동으로 만들어줌
@AllArgsConstructor // 사용자가 도메인에 값을 요청하면 알아서 생성자를 만듦
public class Paging {
	private int page;
	private int currentPageNumberPosts = 10;
	private int viewPageLen = 10;
	private int startPostIndex;
	private int totalPage;
	private int endPage;
	private int startPage;
	
	public Paging(int page, int totalPage){
		this.page = page;
		this.totalPage = totalPage;
	}
	
	public void calc() {
	
		startPostIndex = (page -1) * currentPageNumberPosts;
		// 게시글 시작번호를 알려줄 변수 (0부터, 10부터 ... )
		
		totalPage = (int)Math.ceil((double)totalPage / 10);
		// 예를들어 totalPage 값이 243이라면 24페이지가 아닌 / 25페이지로 보이게 보정 
		
		endPage = (int) (Math.ceil((double) page / viewPageLen) * viewPageLen);
		// 페이지 (1) 보여줄 페이지 갯수(10) 0.1 -> Math.ceil 반올림하면 1. -> * 10 줄하면 10
		// endPage는 10, 20, 30, 40 ... 의 값을 가질 수 있음
		
		startPage = (endPage - viewPageLen) + 1;
		// 만약 endPage가 10이라면 첫페이지는 1
		// 만약 endPage가 29라면 첫페이지는 20
		
		if(endPage > totalPage) { // start, end = 20 ~ 30 인데 totalPage가 27이라면 28, 29. 30 이 나오면 안되므로 endPage를 27로 바꿔줌
			endPage = totalPage;
		}
		
	}
}
