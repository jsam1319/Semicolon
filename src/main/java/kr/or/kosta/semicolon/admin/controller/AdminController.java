package kr.or.kosta.semicolon.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String adminPage() {
		return "/admin/adminpage";
	}
}
