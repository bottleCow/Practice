package com.ch.ch09.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ch.ch09.model.Board;
import com.ch.ch09.service.BoardService;
import com.ch.ch09.service.PagingBean;

@Controller
public class BoardController {
	@Autowired
	private BoardService bs;

	@RequestMapping("insertForm")
	public String insertForm(int num, String pageNum, Model model) {
		int ref = 0, re_level = 0, re_step = 0;
		model.addAttribute("num", num);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("ref", ref);
		model.addAttribute("re_level", re_level);
		model.addAttribute("re_step", re_step);
		return "insertForm";
	}

	@RequestMapping("insert")
	public String insert(Board board, String pageNum, Model model, HttpServletRequest request) {
		// ip를 추적할 필요가 있는 경우
		board.setIp(request.getRemoteAddr());
		int number = bs.getMaxNum(); // 게시글 글번호 생성
		board.setRef(number);
		board.setNum(number);
		int result = bs.insert(board);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "insert"; 
	}

	@RequestMapping("list")
	public String list(String pageNum, Model model) {
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage = 10;  // 한 화면에 보여주는 게시글 갯수
		int total = bs.getTotal();
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		List<Board> list = bs.list(startRow, endRow);
		int num = total - startRow + 1;
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		model.addAttribute("num", num);
		model.addAttribute("pb", pb);
		model.addAttribute("list", list);
		return "list";
	}
	
	// list.jsp view.do
	@RequestMapping("view")
	public String view(int num, String pageNum, Model model) {
		bs.updateReadCount(num);
		Board board = bs.select(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "view";
	}
	
	@RequestMapping("updateForm")
	public String updateForm(int num, String pageNum, Model model) {
		Board board = bs.select(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "updateForm";
	}
	
	@RequestMapping("update")
	public String update(Board board, String pageNum, Model model) {
		int result = bs.update(board);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "update";
	}
	
	@RequestMapping("deleteForm")
	public String deleteForm(int num, String pageNum, Model model) {
		Board board = bs.select(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "deleteForm";
	}
	
}