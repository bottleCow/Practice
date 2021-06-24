package com.ch.mybatis.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.mybatis.model.Member;
import com.ch.mybatis.service.MemberService;

@Controller //.service와 연결
public class MemberController {
	@Autowired
	private MemberService ms;
	
	@RequestMapping("joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
//  방법 1 (idChk.jsp거쳐서 msg전달)
//	@RequestMapping("idChk") 방법 1
//	public String idChk(String id, Model model) {
//		String msg = "";
//		Member member = ms.select(id); //memberService에 입력받은 id값으로 select문 요청함
//		if (member == null) msg = "사용 가능한 아이디 입니다";
//		else msg = "이미 사용중인 아이디 입니다";
//		model.addAttribute("msg", msg);
//		return "idChk"; idChk.jsp로 가서 ${msg}값을주기 때문에 번거로움
//	}
	
	//방법 2 (idChk.jsp없이 자체적으로 msg전달)
	@RequestMapping(value="idChk", produces="text/html;charset=utf-8")
	@ResponseBody //idChk.jsp로 가지말고 바로 본문으로 전달하게 해줌
	public String idChk(String id) {
		String msg = "";
		Member member = ms.select(id); //memberService에 입력받은 id값으로 select문 요청함
		if (member == null) msg = "사용 가능한 아이디 입니다";
		else msg = "이미 사용중인 아이디 입니다";
		return msg;
	}
	
	@RequestMapping("join")
	public String join(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
		// member는 화면에서 입력한 데이터, member2는 db에서 id로 읽은 데이터
		Member member2 = ms.select(member.getId());
		if (member2 == null) {
			String fileName = member.getFile().getOriginalFilename();
			member.setFileName(fileName); //파일명은 joinForm에서 받아오지 않았기때문에 따로 설정해줌
			// metadata에 저장
			String real = session.getServletContext().getRealPath("/resources/upload");
			FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
			fos.write(member.getFile().getBytes());
			fos.close();
			result = ms.insert(member);
		} else result = -1; // 이미 데이터가 있음
		model.addAttribute("result", result);
		return "join";
	}
	
	@RequestMapping("loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping("login")
	public String login(Member member, Model model, HttpSession session) {
		int result = 0; // 암호가 다름
		Member member2 = ms.select(member.getId());
		if (member2 == null || member2.getDel().equals("y"))
			result = -1; // 없는 아이디
		else if (member2.getPassword().equals(member.getPassword())) {
			result = 1; // 아이디와 비밀번호가 일치, 로그인 성공
			session.setAttribute("id", member.getId());
		}
		model.addAttribute("result", result);
		return "login";
	}
	
	@RequestMapping("main")
	public String main(Member member, Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		if (id != null && !id.equals("")) {
			member = ms.select(id);
		}
		model.addAttribute("member", member);
		return "main";
	}
	
	
	
}
