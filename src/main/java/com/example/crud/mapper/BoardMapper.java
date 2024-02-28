package com.example.crud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.crud.vo.Board;

@Mapper
public interface BoardMapper {

	public List<Board> showList(int type);

	public void doWrite(int type, String title, String body, int memberid);

	public Board getBoardById(int id);

	public void doModify(int id, int type, String title, String body);

}
