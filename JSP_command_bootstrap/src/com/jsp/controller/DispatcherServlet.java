package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.controller.HandlerMapper;

public class DispatcherServlet extends HttpServlet {
	
	private HandlerMapper handlerMapper;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String path  = config.getInitParameter("urlPathProperties");
		
		try {
			if(path!=null) {
				handlerMapper = new HandlerMapper(path);
			}else {
				handlerMapper = new HandlerMapper();
			}
			
			System.out.println("[DispatcherServlet] handlerMapper 가 준비되었습니다.");
		} catch (Exception e) {
			System.out.println("[DispatcherServlet] handlerMapper 가 실패했습니다.");
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
