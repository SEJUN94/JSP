package com.jsp.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;

public class LoginFormAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//String url="/WEB-INF/views/common/loginForm.jsp";   /WEB-INF/views/ + url + .jsp  -> JSPViewResolver에 표기 해놨기 때문에 생략해야됨.
		String url="common/loginForm";
		return url;
	}

}
