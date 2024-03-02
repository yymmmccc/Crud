package com.example.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crud.mapper.BoardMapper;
import com.example.crud.vo.Board;
import com.example.crud.vo.Member;

@Service
public class BoardService {
	
	BoardMapper boardMapper;
	
	BoardService(BoardMapper boardMapper){
		this.boardMapper = boardMapper;
	}

	public List<Board> showList(int type, String searchType, String searchKeyword, int currentPageNumberPosts, int currentPage) {
		
		return boardMapper.showList(type, searchType, searchKeyword, currentPageNumberPosts, currentPage);
		
	}

	public int doWrite(int type, String title, String body, Member member) {
		
		boardMapper.doWrite(type, title, body, member.getId()); 
		
		int lastId = getLastId();	// 방금 insert 게시물의 기본키(id)를 가져옴 -> detail?id=내가 방금 작성한 글 보여주기 위함 
		
		return lastId;
	}

	public Board getBoardById(int id) {
		
		return boardMapper.getBoardById(id);
		
	}

	public void doModify(int id, int type, String title, String body) {
		
		boardMapper.doModify(id, type, title, body);
		
	}
	
	private int getLastId() {
		return boardMapper.getLastId();
		
	}

	public int cntPosts(int type, String searchType, String searchKeyword) {
		return boardMapper.cntPosts(type, searchType, searchKeyword);
		
	}
	
}
