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

import kr.or.kosta.semicolon.member.domain.Member;
import kr.or.kosta.semicolon.member.service.MemberService;
import kr.or.kosta.semicolon.membersize.domain.MemberSize;
import kr.or.kosta.semicolon.membersize.service.MemberSizeService;


/**
 * @packgename    kr.or.kosta.semicolon.member.controller
 * 
 *   DATE          AUTHOR         NOTE
 * --------        -----------    ---------------------------------------
 * 2017. 11. 15.      박주연    최초 생성
 * 2017. 11. 16.	  박주연	회원가입 완료 후 로그인처리 기능 추가
 *
 */

@Controller
@RequestMapping("/member")
public class MemberController {

	Logger logger = Logger.getLogger(MemberController.class);

	@Inject
	MemberService memberService;
	
	@Inject
	MemberSizeService sizeService;

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
		
		if (session.getAttribute("no") != null) {
			session.removeAttribute("no");
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
	 * 2. 처리내용      : 회원들의 정보를 받아 회원가입을 처리한 후 인터셉터를 이용해 로그인 처리한다
	 * </pre>
	 * 
	 * @Method Name : memberGet
	 */
	@RequestMapping(value="/regist", method = RequestMethod.POST)
	public void regist(Member member, Model model) {
		logger.debug("regist member:"+member);
		if(memberService.insert(member) == 1) {
			model.addAttribute("mem",member);
			model.addAttribute("autologin",null);
			model.addAttribute("result","result");
		}
	}
	
	@RequestMapping(value="/result/{name}", method=RequestMethod.GET)
	public String loginResult(Model model, @PathVariable("name") String name) {
		model.addAttribute("name",name);
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
	
	@RequestMapping(value="/size", method=RequestMethod.GET)
	public String inputMemberSize() {
		return "/member/membersize";
	}
	
	@RequestMapping(value="/size", method=RequestMethod.POST)
	public String MemberSizeProcess(MemberSize size) {
		logger.info("memberSize:"+size);
		if(sizeService.insert(size) == 1) {
			return "redirect:/";
		}
		
		return "/member/size";
	}
	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String mypage() {
		return "/member/mypage";
	}

	
}
