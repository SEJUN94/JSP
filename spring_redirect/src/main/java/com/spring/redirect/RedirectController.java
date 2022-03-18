package com.spring.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	@RequestMapping(value = "/a")
	public String a(RedirectAttributes rttr) {
		String url = "redirect:receive?name=kim";
		
		//rttr.addAttribute("name", "kim");
		//rttr.addAttribute("messsage","good day!");
		
		rttr.addFlashAttribute("name", "kim");
		
		return url;
	}
	
	@RequestMapping(value = "/receive")
	public void receive(String name,Model model) {
		//model.addAttribute("name", name);
	}
	
	
}
