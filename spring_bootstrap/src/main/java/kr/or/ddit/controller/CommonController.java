package kr.or.ddit.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.dto.MenuVO;
import com.jsp.exception.IdNotFoundException;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.service.LoginSearchMemberService;
import com.jsp.service.MenuService;

@Controller
public class CommonController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private LoginSearchMemberService loginSearchMemberService;
	
	@RequestMapping("/index")
	public String index(@RequestParam(defaultValue="M000000")String mCode,Model model) throws SQLException{
		String url = "common/indexPage";
		
		List<MenuVO> menuList = menuService.getMainMenuList();
		MenuVO menu = menuService.getMenuByMcode(mCode);
		
		model.addAttribute("menuList", menuList);
		model.addAttribute("menu",menu);
		
		return url;
	}
	
	@RequestMapping("common/loginForm")
	public void loginForm() {}
	
	@RequestMapping("common/login")
	public String login(HttpServletRequest request, String id,String pwd,Model model) throws Exception {
		String url = "redirect:/index.do";
		
		
		try {
			loginSearchMemberService.login(id, pwd);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginSearchMemberService.getMember(id));
			
		} catch (IdNotFoundException | InvalidPasswordException e) {
			//e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			url = "common/login_fail";
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return url;
	}
}
