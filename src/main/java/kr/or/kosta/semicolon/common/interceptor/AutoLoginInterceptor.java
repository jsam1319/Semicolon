package kr.or.kosta.semicolon.common.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.or.kosta.semicolon.member.domain.Member;
import kr.or.kosta.semicolon.member.service.MemberService;

/**
 * @packgename  	 kr.or.kosta.semicolon.common.interceptor
 * @filename         AutoLoginInterceptor.java
 * @author           박주연
 * @since            2017. 11. 29.
 * @see				 인덱스 페이지에서 자동로그인처리시 쿠키에 있던 정보를 세션에 넣는 인터셉터
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 29.       박주연        최초 생성
 *
 *
 */

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {
	@Inject
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		Cookie autoLoginCookie = WebUtils.getCookie(request, "autoLoginCookie");
		HttpSession session = request.getSession();
		
		if(autoLoginCookie != null) {
			Member member = memberService.readLogin(autoLoginCookie.getValue());
			if(member != null) {
				session.setAttribute("no", member.getMemberNo());
			}
		}
		return true;
		
	}
}
