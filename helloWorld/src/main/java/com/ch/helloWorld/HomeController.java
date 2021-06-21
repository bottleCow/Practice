package com.ch.helloWorld;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// 요청한 url, RequestMethod.GET get방식
	// @RequestMapping get/post구별하지 않고 사용 가능, method/class에서 사용 가능
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("color")
	public String color(Model model) {
		String[] color = {"red","orange","yellow","green","blue","navy","violet"};
		int num = (int)(Math.random()*7); // 0 ~ 6까지 정수
		model.addAttribute("color", color[num]);
		return "color";
	}
	
	@RequestMapping("gugu") // Model model 은 jsp request.과 유사
	public String gugu(Model model) {
		int num = (int)(Math.random()*8)+2; // 2 ~ 9까지 정수
		model.addAttribute("num", num);
		return "gugu";
	}
	
	@RequestMapping("colorForm")
	public String colorForm() {
		return "colorForm";
	}
	
	@RequestMapping("color2")
	public String color2(String color, Model model) {
		model.addAttribute("color", color);
		return "color";
	}
	
	@RequestMapping("guguForm")
	public String guguForm() {
		return "guguForm";
	}
	
	@RequestMapping("gugu2")
	public String gugu2(int num, Model model) {
		model.addAttribute("num", num);
		return "gugu";
	}
	
	@RequestMapping("addrForm")
	public String addrForm() {
		return "addrForm";
	}
	
	@RequestMapping("addr") // 첫번째 방법
	public String addr(HttpServletRequest request, Model model) {
		// addrForm에서 입력된 데이터 받아오기
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		//jsp로 데이터 전송
		model.addAttribute("name", name);
		model.addAttribute("addr", addr);
		return "addr";
	}
	// (addr==addr2)위 addr과 동일함 String을 메서드에 써주면 getParameter 부분 생략가능 함
	@RequestMapping("addr2") // 두번째 방법
	public String addr2(String name, String addr, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("addr", addr);
		return "addr";
	}
	
	// (addr==addr3)위 addr과 동일함 String을 메서드에 써주면 getParameter 부분 생략가능 함
	@RequestMapping("addr3") // 세번째 방법
	public String addr3(Person person, Model model) {
		model.addAttribute("person", person); //person class에 다 명시했기 때문에 코드가 간결함
		return "addr3"; // addr3.jsp에서 ${person.name}으로 값 사용 가능
	}
	
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
