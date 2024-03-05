package com.example.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.crud.dto.Paging;
import com.example.crud.message.Message;
import com.example.crud.service.BoardService;
import com.example.crud.vo.Board;
import com.example.crud.vo.Member;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	
	BoardService boardService;
	
	BoardController(BoardService boardService){
		this.boardService = boardService;
	}
	
	@RequestMapping("/board/list")
	public String showList(Model model, @RequestParam(defaultValue = "1") int type, 
			@RequestParam(defaultValue = "1") int page, String searchType, 
			@RequestParam(defaultValue="") String searchKeyword) {
	
		
		int totalPage = boardService.cntPosts(type, searchType, searchKeyword);
		
		Paging paging = new Paging(page, totalPage);
		paging.calc();
		
		List<Board> boards = boardService.showList(type, searchType, searchKeyword, paging.getCurrentPageNumberPosts(), paging.getStartPostIndex());
		
		model.addAttribute("type", type);
		model.addAttribute("boards", boards);
		model.addAttribute("paging", paging);
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		
		return "/board/list";
	}
	
	@RequestMapping("/board/write")
	public String write(Model model, int type) {
		
		model.addAttribute("type", type);
		
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
	public String showDetail(HttpServletResponse response, HttpServletRequest request, Model model, int id) {
		
		Board board = boardService.getBoardById(id);
		
		if(board == null) { // 글 자세히보기 했을 때 해당게시물이 했으면 해당 게시물 조회수 + 1
			
			return null;//Message.jsAlertBackPage("해당 게시물은 존재하지 않습니다.");
		}
		
		Cookie[] cookies = request.getCookies(); // detail로 요청을 보낼 때 내가 가지고 있는 쿠키들을 불러옴
		Cookie oldCookie = null;
		
		if(cookies != null) { 
			for(Cookie cookie : cookies) {
				if(cookie.getName().contains("hit")) {  // 이름이 hit인 쿠키가 있는경우
					oldCookie = cookie;					// 해당 쿠키를 old쿠키에 넣음
				}
			}
		}
			
		if(oldCookie != null) {   // hit이라는 이름의 쿠키가 있는경우
			if(!oldCookie.getValue().contains("[" + id + "]")) { // hit 이름의 쿠키는 있지만 , 특정 게시글은 처음방문
				oldCookie.setValue(oldCookie.getValue() + "[" + id + "]");
				oldCookie.setPath("/");
				oldCookie.setMaxAge(60 * 5); // 쿠키의 수명은 300초
				response.addCookie(oldCookie);	// 방금 생성한 쿠키를 추가해줌
			}
		}
		
		else { // hit이라는 쿠키가 존재하지 않는경우 -> hit이라는 이름의 쿠키 생성
			Cookie newCookie = new Cookie("hit", "[" + id + "]"); // hit : 7 생성
			newCookie.setMaxAge(60); // 쿠키 유효기간
			newCookie.setPath("/");  // 모든 경로에서 쿠기 접근 가능
			response.addCookie(newCookie);	// 방금 생성한 쿠키를 추가해줌
			boardService.incHitCnt(id);
		}
		
		// 이렇게 짜면 문제점 2시간전에 2번째 글을 들어가고 방금 3번째 글을 들어갔을 때 
		// 새로운 쿠키 객체를 만드는게 아니므로 2번째 글이 2시간전이 아닌 3번째글처럼 방금으로 바뀜
		
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
