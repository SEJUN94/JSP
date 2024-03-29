package com.jsp.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class MemberDetailAction implements Action {
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/detail";
		
		String id = request.getParameter("id");
		String from = request.getParameter("from");
		
		try {
			MemberVO member = memberService.getMember(id);
			
			if(from!=null && from.equals("list")) {
				//request.setAttribute("from", "true"); 위아래 둘다 상관없음
				request.setAttribute("from", true);
			}
			
			request.setAttribute("member", member);
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
		return url;
	}

}
