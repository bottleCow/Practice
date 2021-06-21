package com.ch.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
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
