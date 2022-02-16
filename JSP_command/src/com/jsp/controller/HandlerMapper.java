package com.jsp.controller;

import java.util.HashMap;
import java.util.Map;

import com.jsp.action.Action;

public class HandlerMapper {
	private String PATH = "com/jsp/properties/url"; // 리소스 번들은 .properties를 빼고 작성해야 이터레이터방식으로 읽어들임
	
	private Map<String, Action> commandMap = new HashMap<String, Action>();
	
	public HandlerMapper(String path) throws Exception{
		
	}
	
}
