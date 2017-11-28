package kr.or.kosta.semicolon.common.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.or.kosta.semicolon.member.domain.Member;
import kr.or.kosta.semicolon.member.service.MemberService;


/**
 * @packgename        kr.or.kosta.semicolon.common.interceptor
 * @filename        LoginInterceptor.java
 * @author             박주연
 * @since            2017. 11. 9.
 * @see                로그인 처리를 하기 위한 인터셉터
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE          AUTHOR         NOTE
 * --------        -----------    ---------------------------------------
 * 2017. 11. 9.        박주연        최초 생성
 *
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String LOGIN = "no";
    
    Logger logger = Logger.getLogger(LoginInterceptor.class);
    
    @Inject
    private MemberService memberService;
    
    /**
     * <pre>
     * 1. 개      요 : preHandle 메소드
     * 2. 처리내용      : 기본 세션에 남아있는 사용자가 존재할 경우 삭제
     * </pre>
     * @Method Name     : preHandle
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	logger.debug("prehandle");
        HttpSession session = request.getSession();
        if(session.getAttribute(LOGIN) != null) {
            session.removeAttribute(LOGIN);
        }
        
        return true;
    }
    
    /**
     * <pre>
     * 1. 개      요 : postHandle 메소드
     * 2. 처리내용      : 
     * </pre>
     * @Method Name     : postHandle
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        
    	 
        HttpSession session = request.getSession();
        Member member = (Member) modelAndView.getModel().get("mem");

//       logger.debug("postHandle");
//       logger.debug("member:"+member);

        
        if(member != null) {
//            logger.debug("login성공");
            session.setAttribute(LOGIN, member.getMemberNo());
            
            //자동 로그인 체크시
            if(modelAndView.getModel().get("autologin") != null) {
//            	logger.debug("자동로그인처리");
                String sessionId = session.getId();
                int days = 60 * 60 * 24 * 14; //14일간 저장
                Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * days));
                
                logger.debug("session_limit : " + sessionLimit.toString());
                
                // 사용자 테이블의 sessionid와 sessionlimt 컬럼 수정
                Member newM = new Member();
                newM.setId(member.getId());
                newM.setSessionId(sessionId);
                newM.setSessionLimit(sessionLimit);
                memberService.updateLogin(newM);
                
                //세션아이디 저장 사용자 쿠키 생성
                Cookie autoLoginCookie = new Cookie("autoLoginCookie", session.getId());
                autoLoginCookie.setPath("/");
                autoLoginCookie.setMaxAge(60 * 60 * 24 * 7); 
                response.addCookie(autoLoginCookie);
            }
            
            // 로그인 전의 해당 경로로 이동
            String referer = (String)session.getAttribute("referer");
            if(referer != null) {
            	request.getSession().setAttribute("referer", "/");
				response.sendRedirect(referer);
			} else { //인덱스 페이지로
				if((String)modelAndView.getModel().get("result") != null) {
					response.sendRedirect("/member/result/"+member.getName());
				}
				else {
					response.sendRedirect("/");
				}
			}
        }
        
    }
}