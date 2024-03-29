package kr.or.ddit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.jsp.dto.MemberVO;
import com.jsp.service.LoginSearchMemberService;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {

		User user = (User)authentication.getDetails();
		String id = user.getUsername();
		
		MemberVO loginUser = user.getMemberVO();
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", loginUser);
		session.setMaxInactiveInterval(10);
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	
}
