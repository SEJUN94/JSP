package com.jsp.listener;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.context.ApplicationContext;
import com.jsp.dto.MenuVO;
import com.jsp.service.MenuService;

public class TestMenuServiceImpl {

	private MenuService menuService;
	
	@Before	
	public void init()throws Exception{
		MockApplicationContextInitListener listener 
			= new MockApplicationContextInitListener();
		
		String beanConfigXml ="classpath:com/jsp/context/application-context.xml";
		
		listener.contextInitialized(beanConfigXml);
		
		//ApplicationContext(=container)에서 서비스 가져옴
		menuService = (MenuService)ApplicationContext.getApplicationContext().get("menuService");
	}
	
	@Test
	public void testGetMenuList() throws Exception{
		List<MenuVO> menuList = menuService.getMainMenuList();
		
		Assert.assertEquals(5, menuList.size());
	}
	
	@After
	public void destory()throws Exception{
		
	}
}
