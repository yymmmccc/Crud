package com.example.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crud.mapper.BoardMapper;
import com.example.crud.vo.Board;

@Service
public class BoardService {
	
	BoardMapper boardMapper;
	
	BoardService(BoardMapper boardMapper){
		this.boardMapper = boardMapper;
	}

	public List<Board> showList(int type) {
		
		return boardMapper.showList(type);
		
	}

	public void doWrite(int type, String title, String body, int memberId) {
		
		boardMapper.doWrite(type, title, body, memberId);
		
	}

	public Board getBoardById(int id) {
		
		return boardMapper.getBoardById(id);
		
	}

	public void doModify(int id, int type, String title, String body) {
		
		boardMapper.doModify(id, type, title, body);
		
	}

	
}
