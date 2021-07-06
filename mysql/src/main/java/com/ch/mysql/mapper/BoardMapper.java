package com.ch.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.mysql.dto.BoardDto;
//DAO역할
@Mapper //구현하는 클래스 없이 바로 xml에 연결
public interface BoardMapper {
	
	List<BoardDto> selectBoardList();
	
	int insert(BoardDto board);
	
	BoardDto select(int board_idx);
}
