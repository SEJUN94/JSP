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
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		String mCode = request.getParameter("mCode");
		List<MenuVO> subMenu = null;
		
		try {
			subMenu = menuService.getSubMenuList(mCode);
			
			JSONViewResolver.view(response, subMenu);

			//subMenu 내보내기.
//			ObjectMapper mapper = new ObjectMapper();
//			String json = mapper.writeValueAsString(subMenu);
			
			// content Type 결정
//			response.setContentType("application/json;charset=utf-8");
//			PrintWriter out = response.getWriter();
			
//			out.print(json);
			
//			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			// Exception 처리......
			throw e;	
		}
			
		return url;
	}

}








