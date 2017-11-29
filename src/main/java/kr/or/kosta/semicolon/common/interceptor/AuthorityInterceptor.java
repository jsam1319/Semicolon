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
 * @packgename        kr.or.kosta.semicolon.common.interceptor
 * @filename          AuthorityInterceptor.java
 * @author            박주연
 * @since             2017. 11. 9.
 * @see               현재 사용자가 로그인을 한 상태인지 아닌지 체크하는 인터셉터
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE          AUTHOR         NOTE
 * --------        -----------    ---------------------------------------
 * 2017. 11. 9.        박주연        최초 생성
 *
 *
 */

public class AuthorityInterceptor extends HandlerInterceptorAdapter {
    Logger logger = Logger.getLogger(AuthorityInterceptor.class);
    
    @Inject
    private MemberService memberService;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        int memberNo = 0;
        
        if(session.getAttribute("no")!=null) {
        	memberNo = (int)session.getAttribute("no");
        }
        
        
        if(memberNo == 0) {
            saveReferer(request);
            
            //autoLoginCookie가 존재할 때
            Cookie autoLoginCookie = WebUtils.getCookie(request, "autoLoginCookie");
            if(autoLoginCookie != null) {
                Member member = memberService.readLogin(autoLoginCookie.getValue());
                if(member != null) {
                    session.setAttribute("no", member.getMemberNo());
                    return true;
                }
            }
            
            response.sendRedirect("/member/login");
            return false;
        }
        return true;
    }
    
    /**
     * <pre>
     * 1. 개      요 : saveReferer 메소드
     * 2. 처리내용      : 로그인 하지 않았을 때 로그인페이지로 이동후 다시 보던 페이지로 
     * 돌아 가기 위해 처리해주는 메소드
     * </pre>
     * @Method Name     : saveReferer
     */
    public void saveReferer(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String query = request.getQueryString();
        if(query == null || query.equals("null")) {
            query = "";
        }else {
            query += "?" + query;
        }
        
        uri += query;
        
        if(request.getMethod().equalsIgnoreCase("get")) {
            request.getSession().setAttribute("referer", uri);
        }
    }
    
}

