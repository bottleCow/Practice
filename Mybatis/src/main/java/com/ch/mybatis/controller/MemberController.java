package com.ch.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ch.mybatis.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	
}
