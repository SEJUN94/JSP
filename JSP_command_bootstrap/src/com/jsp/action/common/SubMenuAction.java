package com.jsp.action.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.JSONViewResolver;
import com.jsp.dto.MenuVO;
import com.jsp.service.MenuService;

public class SubMenuAction implements Action {
	
	private MenuService menuService;
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@Override
	//mCode값 받아서 
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String url = null;
		
		//mCode 받기
		String mCode = request.getParameter("mCode");
		//해당메뉴에다가 subMenuList => exception 발생한 곳에서 처리
		List<MenuVO> subMenu = null;
		
		try {
			subMenu = menuService.getSubMenuList(mCode);
			
			JSONViewResolver.view(response, subMenu);
			
		} catch(Exception e) {
			e.printStackTrace();
			// Exception 처리....
			throw e;
		}
		
		return url;
	}

}
