package com.ch.mysql.service;
import java.util.List;
import com.ch.mysql.dto.BoardDto;
public interface BoardService {
	List<BoardDto> selectBoardList();

}