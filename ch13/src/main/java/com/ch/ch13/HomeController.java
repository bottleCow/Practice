package com.ch.ch13;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping("home")
	public String home() {
		return "home";
	}

	@RequestMapping("first")
	public String first() {
		return "first";
	}

	@RequestMapping("second")
	public String second() {
		return "second";
	}

	@RequestMapping("third")
	public String third() {
		return "third";
	}

	@RequestMapping("test1")
	public String nolay() {
		return "test1";
	}

}
