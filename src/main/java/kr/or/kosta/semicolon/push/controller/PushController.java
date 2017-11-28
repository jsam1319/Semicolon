package kr.or.kosta.semicolon.push.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.kosta.semicolon.member.domain.Member;
import kr.or.kosta.semicolon.member.service.MemberService;
import kr.or.kosta.semicolon.push.domain.PushToken;
import kr.or.kosta.semicolon.push.service.PushTokenService;

/**
 * @packgename   kr.or.kosta.semicolon.push.controller
 * @filename         PushController.java
 * @author          Jeon SeJong
 * @since            2017. 11. 28.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 28.      sejong         최초 생성
 *
 *
 */
@Controller
@RequestMapping("/push")
public class PushController {
	
	Logger logger = Logger.getLogger(PushController.class);
	
	@Inject
	MemberService memberService;
	
	@Inject
	PushTokenService pushTokenService;
	
	
	/**
	 * <pre>
	 * 1. 개      요 : 메세지를 보내는 작업
	 * 2. 처리내용 : 메시지를 받고 토큰값을 얻어 서비스로 보내준다. 
	 * </pre>
	 * @Method Name : index
	 * @param pushToken		
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/message")
	public String index(PushToken pushToken) throws Exception {
		logger.info("message컨트롤러 들어옴");
		
		String token = memberService.selectToken(1);
		
		pushTokenService.pushToken(token);
		
		//List<PushToken> tokenList; // = 서비스.loadFCMInfoList(pushToken);
		
		//String token; // = tokenList.get(count).getDEVICE_ID();
		
		return "redirect:/";
	}
	
	/**
	 * <pre>
	 * 1. 개      요 : 자동 로그인시 토큰값을 얻어온다.
	 * 2. 처리내용 : 얻어온 토큰값을 member DB에 등록한다.
	 * </pre>
	 * @Method Name : saveToken
	 * @param token			:		토큰 값
	 * @param no			:		회원번호
	 * @throws Exception
	 */
	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public void saveToken(String token, int no) throws Exception {
		logger.info("token : " + token);
		logger.info("no : " + no);
		
		Member member= memberService.select(no);
		member.setAppToken(token);
		
		memberService.updateToken(member);
	}
	
}
