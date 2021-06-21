package com.ch.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("memberForm")
	public String memberForm() {
		return "memberForm"; //memberForm.jsp로 이동해서 값을 받아옴
	}
	
	@RequestMapping("member") // 이 방법을 많이 사용
	public String member(Member member, Model model) {
		model.addAttribute("member", member); // member class에 다 명시했기 때문에 코드가 간결함
		return "member"; // member.jsp에서 ${member.name}으로 값 사용 가능
	} 
	
	@RequestMapping("calForm")
	public String calForm() {
		return "calForm";
	}
	
	@RequestMapping("cal") //92번줄과 유사
	public String cal(int num1, int num2, Model model) {
		model.addAttribute("add", num1+num2);
		model.addAttribute("min", num1-num2);
		model.addAttribute("mul", num1*num2);
		model.addAttribute("divi", num1/num2);
		return "cal"; // cal.jsp에서 ${cal.num1}으로 값 사용 가능
	}
	//위 메서드에서 0을 입력했을때 나오는 에러 처리
	@ExceptionHandler(ArithmeticException.class)
	public String err1() {
		return "err1";
	}
}
