package com.example.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.crud.message.Message;
import com.example.crud.service.BoardService;
import com.example.crud.vo.Board;
import com.example.crud.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	
	BoardService boardService;
	
	BoardController(BoardService boardService){
		this.boardService = boardService;
	}
	
	@RequestMapping("/board/list")
	public String showList(Model model, @RequestParam(defaultValue = "1") int type) {
		
		List<Board> boards = boardService.showList(type);
		
		model.addAttribute("boards", boards);
		
		return "/board/list";
	}
	
	@RequestMapping("/board/write")
	public String write(int type) {
		
		return "/board/write";
	}
	
	@RequestMapping("/board/doWrite")
	@ResponseBody
	public String doWrite(HttpServletRequest request, int type, String title, String body) {
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		int memberId = member.getId();
		
		boardService.doWrite(type, title, body, memberId);
		
		return Message.showAlertMovePage("게시글이 작성되었습니다.", String.format("/board/list?type=%d", type));
	}
	
	@RequestMapping("/board/detail")
	public String showDetail(Model model, int id) {
		
		Board board = boardService.getBoardById(id);
		
		model.addAttribute("board", board);
		
		return "/board/detail";
	}
	
	@RequestMapping("/board/modify")
	public String modify(Model model, int id) {
		
		Board board = boardService.getBoardById(id);
		model.addAttribute("board", board);
		
		return "/board/modify";
	}
	
	@RequestMapping("/board/doModify")
	@ResponseBody
	public String doModify(int id, int type, String title, String body) {
		
		boardService.doModify(id, type, title, body);
		
		return Message.showAlertMovePage("글이 수정되었습니다.", String.format("/board/detail?id=%d", id));
	}
}
