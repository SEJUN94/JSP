package com.jsp.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.MemberDAO;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;


public class MemberUpdateServlet extends HttpServlet {
	
	private MemberService memberService;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		/*
		 * SqlSessionFactory sqlSessionFatory = new OracleMybatisSqlSessionFactory();
		 * MemberDAO memberDAO = new MemberDAOImpl();
		 */
		String memberServiceStr = config.getInitParameter("memberService");
		String memberDAOStr = config.getInitParameter("memberDAO");
		String sqlSessionFactoryStr = config.getInitParameter("sqlSessionFactory");
		
		try {
			memberService = (MemberService)Class.forName(memberServiceStr).newInstance();
			MemberDAO memberDAO = (MemberDAO)Class.forName(memberDAOStr).newInstance();
			SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)Class.forName(sqlSessionFactoryStr).newInstance();
			
					
			
			if(memberService instanceof MemberServiceImpl ) {
				MemberServiceImpl memberServiceImpl = (MemberServiceImpl)memberService;
				memberServiceImpl.setSqlSessionFactory(sqlSessionFactory);
				memberServiceImpl.setMemberDAO(memberDAO);
				
				System.out.println("memberService injection clear!");
			}
		}catch(Exception e) {
			System.out.println("초기화 실패입니다.");
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="/WEB-INF/views/member/update.jsp";
		
		String id = request.getParameter("id");
		
		MemberVO member = null;
		
		try {
			member=memberService.getMember(id);
			
			request.setAttribute("member", member);
		} catch (SQLException e) {
			url="/WEB-INF/views/member/detail_fail.jsp";
			e.printStackTrace();
		}
		
		request.setAttribute("member", member);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getContextPath()+"/member/list";
		
		int cnt = 0;
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		
		List<MemberVO> memberList = null;
		MemberVO mv = new MemberVO();
		mv.setId(id);
		mv.setPwd(pwd);
		mv.setName(name);
		mv.setPhone(phone);
		mv.setEmail(email);
		mv.setAddress(address);
		
		try {
			cnt = memberService.updateMember(mv);
			memberService.getMemberList();
		} catch (SQLException e) {
			url="/WEB-INF/views/member/update_fail.jsp";
			e.printStackTrace();
		}
		
		String msg = "";
		if(cnt >0) {
			msg="정보_수정_성공";
		}else {
			msg="정보_수정_실패";
		}
		
		request.setAttribute("memberList", memberList);
		
		String redirectUrl = request.getContextPath() + "/member/list?msg=" + URLEncoder.encode(msg, "UTF-8");
		response.sendRedirect(redirectUrl);   // 목록 조회 화면으로 리다이렉트
	}

}
