package com.ch.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.mysql.dto.BoardDto;
import com.ch.mysql.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService bs;

	//스프링 부트는 확장자까지 포함
	@RequestMapping("/board/boardList.do")
	public String boardList(Model model) {
	List<BoardDto> list = bs.selectBoardList();
	model.addAttribute("list", list);
	return "/board/boardList";
	}  //보드리스트로 이동하기
}
