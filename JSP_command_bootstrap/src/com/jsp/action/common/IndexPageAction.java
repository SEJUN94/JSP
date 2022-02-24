package com.jsp.action.common;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MenuVO;
import com.jsp.service.MenuService;

public class IndexPageAction implements Action {

	private MenuService menuService;

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	@Override
	//page url
	public String process(HttpServletRequest requeset, HttpServletResponse response)
			throws Exception {
		// 우리가 만든 서블릿을 타게 만들게 하기 위헤 WEB-INF경로를 걸어줌
		// contextPath(/)+WEB-INF = 사용자 접근 차단(접금 시 404 에러)
		// 포워딩(내부접근)은 가능
		// String url = "/WEB-INF/views/common/indexPage.jsp";
		String url = "common/indexPage";
		
		String mCode = requeset.getParameter("mCode");
		
		// 처음에 들어가는 화면은 mCode없음. 그래서 mCode가 없을경우 홈으로 가기 위한 처리
		if(mCode == null) mCode ="M000000";
		
		try {
			List<MenuVO>menuList = menuService.getMainMenuList();
			requeset.setAttribute("menuList", menuList);
			
			MenuVO menu = menuService.getMenuByMcode(mCode);
			requeset.setAttribute("menu", menu);
			
		} catch (SQLException e) {
			e.printStackTrace(); // 콘솔에만 찍힘
			// Exception 처리 :  log 기록.....
			throw e;
		}
		
		return url;
	}

}
