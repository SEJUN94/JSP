package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test") // http://localhost/ServletTest/test
public class TestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// System.out.println("Get 요청처리");
		
		//입력
		int dan = 2, gop = 1;
		String output = "";
		
		Scanner scann = new Scanner(System.in);
		int target = scann.nextInt();
		scann.nextLine();

		//처리
		for (;dan<target;dan++) {
			output += dan + "단 " + "<br/>";
			for (gop=1;gop<10; gop++) {
				output += dan + "*" + gop + "=" + dan * gop + "<br/>";
			}
			output += "<br/>";
		}
		
		//출력
		//System.out.println(output);
		//response.setContentType("application/html; charset=utf-8"); // 다운로드
		//response.setContentType("text/plain; charset=utf-8"); // htmp형식이 아닌 text형식으로 인식
		response.setContentType("text/html;charset=utf-8");  // html형식을 맞춰서 출력하기 위해 \n이아닌 <br/> 태그로 줄을 띄어줌
		PrintWriter out = response.getWriter();
		out.print(output);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
