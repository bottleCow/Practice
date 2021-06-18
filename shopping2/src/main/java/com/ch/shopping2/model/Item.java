package com.ch.shopping2.model;

import lombok.Data;

@Data //getter setter자동 생성 어노테이션, outline에서 확인가능
public class Item {
	private int itemId;
	private String itemName;
	private int price;
	private String description;
	private String pictureUrl;
}
