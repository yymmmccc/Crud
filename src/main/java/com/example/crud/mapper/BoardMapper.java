package com.example.crud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.crud.vo.Board;

@Mapper
public interface BoardMapper {

	public List<Board> showList(int type, String searchType, String searchKeyword, int currentPageNumberPosts, int currentPage);

	public void doWrite(int type, String title, String body, @Param("memberId") int memberId);

	public Board getBoardById(int id);

	public void doModify(int id, int type, String title, String body);

	public int getLastId();

	public int cntPosts(int type, String searchType, String searchKeyword);

	public void incHitCnt(int id);

}
