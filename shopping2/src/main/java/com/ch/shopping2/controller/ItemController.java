package com.ch.shopping2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.shopping2.model.Item;
import com.ch.shopping2.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService is;
	@RequestMapping("fruitList")
	// WEB-INF shopping2-servlet.xml에서 /WEB-INF/views/...jsp 자동으로 더해서 jsp로 정보 전달 
	public String fruitList(Model model) {
		// 여러건 데이터 읽을때는 list
		List<Item> list = is.list();
		model.addAttribute("list", list);
		return "fruitList";
		
	}
	// fruitList에서 fruitDetail.do 실행 할때 ?itemId=숫자 했기때문에 int로
	@RequestMapping("fruitDetail")
	public String fruitDetail(int itemId, Model model) {
		// 하나의 데이터 읽을때는 select
		Item item = is.select(itemId);
		//              바로 밑 item을 jsp페이지에서 ${item.~~}로 사용가능하게 해줌
		model.addAttribute("item", item);
		return "fruitDetail";
	}
}
