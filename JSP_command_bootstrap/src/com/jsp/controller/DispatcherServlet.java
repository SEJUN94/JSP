package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;

public class DispatcherServlet extends HttpServlet {

	// 핸들러맵퍼 -> init에서 초기화 진행
	private HandlerMapper handlerMapper;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String path = config.getInitParameter("urlPathProperties");

		try {
			if (path != null) {
				handlerMapper = new HandlerMapper(path);
			} else {
				handlerMapper = new HandlerMapper();
			}
			System.out.println("[DispatcherServlet] handlerMapper 가 준비되었습니다");
		} catch (Exception e) {
			System.out.println("[DispatcherServlet] handlerMapper 가 실패했습니다.");
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response);
	}

	private void requestPro(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// 사용자 URI 검출
		String command = request.getRequestURI(); // contextPath 포함.(=/JSP_command_bootstrap/*.do)
		if(command.indexOf(request.getContextPath())==0) { // contextPath 삭제
			command = command.substring(request.getContextPath().length()); // => /*.do
		}
		
		// commandHandlef 실행(HandlerMapper 의뢰 action 할당)
		Action action = null;
		String view = null;
		
		if(handlerMapper !=null) {
			action = handlerMapper.getAction(command);
			if(action!=null) { // 올바른 요청
				try {
					view = action.process(request, response);
					if(view==null) {
						return;
					}
					request.setAttribute("viewName", view);
					JSPViewResolver.view(request, response);
				} catch (Exception e) { // 서버에러이므로 500
					e.printStackTrace();
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				}
			} else { // 404
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		} else { // handler가 null인 경우(constructor) => handler내부에서 exception = 500에러
				 // hander에서 catch(해결/처리)를 하고 throw했기 때문에 서블릿은 정상적으로 작동함
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
