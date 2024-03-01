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
	public String showList(Model model, @RequestParam(defaultValue = "1") int type, 
			@RequestParam(defaultValue = "1") int page) {
		
		int currentPageNumberPosts = 10; // 현재 페이지 보여줄 게시글 갯수
		int currentPage = ((page -1) * currentPageNumberPosts); // 0부터.. 10부터.. 
		
		// 마지막페이지를 알아야됨 -> 게시글 총 글 갯수 알아내기 (db갔다와야함)
		double totalPage = boardService.cntPosts(type);
		totalPage = Math.ceil(totalPage / 10);
		// ex. totalPage가 53이면 60으로 바꿔줘야 나머지 3개 페이지도 보여줌 ok
		// ex, 236
		// 페이지를 10개씩 끊어서 보여주고싶음.
		
		List<Board> boards = boardService.showList(type, currentPageNumberPosts, currentPage);
		
		
		model.addAttribute("boards", boards);
		model.addAttribute("totalPage", totalPage);
		
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
		
		int lastBoardId = boardService.doWrite(type, title, body, member);
		
		return Message.showAlertMovePage("게시글이 작성되었습니다.", String.format("/board/detail?id=%d", lastBoardId));
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
