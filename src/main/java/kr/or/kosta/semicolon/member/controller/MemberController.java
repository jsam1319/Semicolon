package kr.or.kosta.semicolon.member.controller;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.kosta.semicolon.member.domain.Member;
import kr.or.kosta.semicolon.member.service.MemberService;


/**
 * @packgename    kr.or.kosta.semicolon.member.controller
 * 
 *   DATE          AUTHOR         NOTE
 * --------        -----------    ---------------------------------------
 * 2017. 11. 15.      박주연    최초 생성
 *
 *
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
	public void login(Member member, Model model) {
		Member mem = memberService.isMember(member);
		
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
	
	
	/**
	 * <pre>
	 * 1. 개      요 	: 회원가입 처리 메소드
	 * 2. 처리내용      : 회원들의 정보를 받아 회원가입을 처리한다
	 * </pre>
	 * 
	 * @Method Name : memberGet
	 */
	@RequestMapping(value="/regist", method = RequestMethod.POST)
	public String regist(Member member, Model model) {
		logger.debug("regist member:"+member);
		if(memberService.insert(member) == 1) {
			model.addAttribute("id",member.getId());
			return "/member/result";
		}
		return "/member/regist";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.GET)
	public String loginResult() {
		return "/member/result";
	}
	
	/**
	 * <pre>
	 * 1. 개      요 	: id 중복체크
	 * 2. 처리내용      : 사용자가 입력한 id가 중복된 값인지 확인한다 
	 * </pre>
	 * 
	 * @Method Name : memberGet
	 */
	@RequestMapping(value="/regist/{id}", method=RequestMethod.GET)
	public ResponseEntity<String> checkId(@PathVariable("id") String id) {
		ResponseEntity<String> response = null;
		String result = memberService.isId(id);
		try {
			if(result == null) {
				response = new ResponseEntity<String>("possible", HttpStatus.OK);
			}
			else {
				response = new ResponseEntity<String>("impossible", HttpStatus.OK);
			}
		}catch(Exception e) {
			response = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
}
