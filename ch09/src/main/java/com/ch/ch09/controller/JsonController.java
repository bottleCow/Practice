package com.ch.ch09.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ch.ch09.model.Board;
import com.ch.ch09.service.BoardService;

@RestController
public class JsonController {
	@Autowired
	private BoardService bs;

	@RequestMapping("jsonBoard")
	public List<Board> jsonBoard(Board board) {
		// 1부터 시작해서 10까지 10개 보여줌
		board.setStartRow(1);
		board.setEndRow(10);
		List<Board> list = bs.list(board);
		return list;
	}

}