package com.ch.mybatis.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ch.mybatis.model.Member;
import com.ch.mybatis.model.MemberPhoto;
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
	
	@RequestMapping("joinForm2")
	public String joinForm2() {
		return "joinForm2";
	}
	
	// 파일 여러개 업로드 가능한 가입
	@RequestMapping("join2")
	public String join2(Member member, Model model, HttpSession session, MultipartHttpServletRequest mhr) throws IOException {
		int result = 0;
		// member는 화면에서 입력한 데이터, member2는 db에서 id로 읽은 데이터
		Member member2 = ms.select(member.getId());
		if (member2 == null) {
			//여러개 파일명을 한번에 받아옴
			List<MultipartFile> list = mhr.getFiles("file");
			//사진을 여러개 가진 list, 하나씩 photo에 저장 후 그것을 photos에 추가
			List<MemberPhoto> photos = new ArrayList<MemberPhoto>();
			// metadata에 저장
			String real = session.getServletContext().getRealPath("/resources/upload");
			// list의 사진을 하나씩 뽑아서 photos에 저장
			for (MultipartFile mf : list) {
				MemberPhoto mp = new MemberPhoto();
				String fileName = mf.getOriginalFilename();
				mp.setFileName(fileName);
				mp.setId(member.getId());
				// photos에는 사진 하나짜리 mp가 여러개 저장되어있음
				photos.add(mp);
				// 파일 업로드
				FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
				fos.write(mf.getBytes());
				fos.close();
				member.setFileName(fileName);
			}
			result = ms.insert(member);
			if (result > 0) ms.insertPhoto(photos);
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
	
	@RequestMapping("view")
	public String view(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "view";
	}
	
	@RequestMapping("view2")
	public String view2(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		List<MemberPhoto> list = ms.listPhoto(id);
		model.addAttribute("member", member);
		model.addAttribute("list", list);
		return "view2";
	}
	
	@RequestMapping("updateForm") //member에서 id를 받아와 updateform으로 이동
	public String updateForm(Member member, Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		member = ms.select(id);
		model.addAttribute("member", member);
		return "updateForm";
	}
	
	@RequestMapping("update")
	public String update(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
		// member는 화면에서 입력한 데이터
		// 여기서 fileName은 값이 있을수도 있고(사용자가 수정할때 새로운사진 업로드하면) null일수도 있다
		String fileName = member.getFile().getOriginalFilename();
		if (fileName != null && !fileName.equals("")) {
			member.setFileName(fileName); //파일명은 updateForm에서 받아오지 않았기때문에 따로 설정해줌
			// metadata에 저장
			String real = session.getServletContext().getRealPath("/resources/upload");
			FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
			fos.write(member.getFile().getBytes());
			fos.close();
		}
		result = ms.update(member);
		model.addAttribute("result", result);
		return "update";
	}
	
	@RequestMapping("delete")
	public String delete(Member member, Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		int result = ms.delete(id);
		if (result > 0) session.invalidate(); //session 지우기
		model.addAttribute("result", result);
		return "delete";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate(); //session 지우기
		return "logout";
	}
	
	
}
