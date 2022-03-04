package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 마지막 처리단임
public class JSPViewResolver {

	// req, resp 는 서블릿이 줌
	public static void view(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 안심어줘도 상관 없음
		// 그렇지만 심어주는 이유 = 분리!!
		String url = (String) request.getAttribute("viewName");

		if (url == null) {
			return;
		}

		if (url.indexOf("redirect:") > -1) { // = redirect

			String contextPath = request.getContextPath();

			url = contextPath + "/" + url.replace("redirect:", "");

			response.sendRedirect(url);

		} else { // jsp 찾아감
			String prefix = "/WEB-INF/views/";
			String subfix = ".jsp";
			url = prefix + url + subfix;
			request.getRequestDispatcher(url).forward(request, response);

		}
	}

}
