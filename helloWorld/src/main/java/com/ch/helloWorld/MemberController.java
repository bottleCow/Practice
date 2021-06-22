package com.ch.helloWorld;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //데이터를 읽어서 xml 또는 json으로 값을 출력해서 보여줌
public class MemberController {
	
	@RequestMapping("mem1")
	public Member mem1() {
		Member member = new Member();
		member.setAddr("강서");
		member.setAge(27);
		member.setGender("여자");
		member.setHobby("game");
		member.setName("Britney");
		return member;
	}
	
	@RequestMapping("mem1List")
	public List<Member> mem1List() {
		List<Member> list = new ArrayList<Member>();
		for (int i=0; i<10; i++) {
			Member member = new Member();
			member.setAddr("강서+i");
			member.setAge(27+i);
			member.setGender("여자+i");
			member.setHobby("game+i");
			member.setName("Britney+i");
			list.add(member);
		}
		return list;
	}
	
	
	
}
