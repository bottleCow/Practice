package com.ch.tiles;

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

	@RequestMapping("/home/home")
	public String home() {
		return "home/home";
	}

	@RequestMapping("/home/first")
	public String first() {
		return "home/first";
	}

	@RequestMapping("/test/second")
	public String second() {
		return "test/second";
	}

	@RequestMapping("test/third")
	public String third() {
		return "test/third";
	}

	@RequestMapping("/nolay/test1")
	public String nolay() {
		return "nolay/test1";
	}

}
