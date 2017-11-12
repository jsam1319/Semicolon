package kr.or.kosta.semicolon.member.controller;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.kosta.semicolon.member.domain.Member;
import kr.or.kosta.semicolon.member.service.MemberService;

/**
 * @packgename kr.or.kosta.semicolon.member.controller
 */

@Controller
@RequestMapping("/member")
public class MemberController {

	Logger logger = Logger.getLogger(MemberController.class);

	@Inject
	MemberService memberService;

	/**
	 * <pre>
	 * 1. 개      요 	: 로그인 view 메소드
	 * 2. 처리내용      : 로그인창을 띄어준다
	 * </pre>
	 * 
	 * @Method Name : memberGet
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginView() {
		return "/member/login";
	}

	/**
	 * <pre>
	 * 1. 개      요 	: 로그인 처리 메소드
	 * 2. 처리내용      : ID, PASSWORD를 입력받아 처리해준다
	 * </pre>
	 * 
	 * @Method Name : login
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(Member member, Model model, HttpServletRequest request) {
		Member mem = memberService.isMember(member);
		logger.debug("login post  mem:" + mem);
		logger.debug("autoLogin:" + member.getAutoLogin());
		if (mem != null) {
			model.addAttribute("mem", mem);
			model.addAttribute("autologin", member.getAutoLogin());
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Cookie cookies[] = request.getCookies();
		
		if (session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if (cookieName.equals("autoLoginCookie")) {
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
		}
		
		return "redirect:/";
	}
	
	/**
	 * <pre>
	 * 1. 개      요 	: 회원가입 view 메소드
	 * 2. 처리내용      : 회원가입창을 띄어준다
	 * </pre>
	 * 
	 * @Method Name : memberGet
	 */
	@RequestMapping(value="/regist", method = RequestMethod.GET)
	public String registView() {
		return "/member/regist";
	}
	

}
