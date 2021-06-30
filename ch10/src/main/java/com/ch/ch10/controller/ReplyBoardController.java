package com.ch.ch10.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.ch10.model.Board;
import com.ch.ch10.model.ReplyBoard;
import com.ch.ch10.service.BoardService;
import com.ch.ch10.service.ReplyBoardService;
@Controller
public class ReplyBoardController {
	@Autowired
	private ReplyBoardService rbs;
	
	// board테이블도 추가
	@Autowired
	private BoardService bs;
	
	@RequestMapping("/replyList/bno/{bno}")
	private String replyList(@PathVariable int bno, Model model) {
		Board board = bs.select(bno); // 부모테이블 board에서 bno정보 가져옴
		List<ReplyBoard> rbdList = rbs.list(bno); //부모테이블board에서 가져온 bno를 리스트로 생성
		model.addAttribute("board", board);
		model.addAttribute("rbdList", rbdList);
		return "replyList";
	}
	
	@RequestMapping("/rDelete")
	private String rDelete(ReplyBoard rb) {
		rbs.delete(rb);
		return "redirect:/replyList/bno/"+rb.getBno();
	}
	
	@RequestMapping("/rInsert")
	private String rInsert(ReplyBoard rb) {
		rbs.insert(rb);
		// redirect또는 forward는 jsp가 아닌 controller 내부의 다른 메서드 호출하는 기능
		return "redirect:/replyList/bno/"+rb.getBno();
	}
	
	@RequestMapping("/rUpdate")
	private String rUpdate(ReplyBoard rb) {
		rbs.update(rb);
		// redirect또는 forward는 jsp가 아닌 controller 내부의 다른 메서드 호출하는 기능
		return "redirect:/replyList/bno/"+rb.getBno();
	}
}
