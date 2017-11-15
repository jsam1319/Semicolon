package kr.or.kosta.semicolon.member.service;


import java.util.List;

import kr.or.kosta.semicolon.member.domain.Member;

public interface MemberService{

    public List<Member> listAll();
    
    public int insert(Member member);

    public Member select(int no);
    
    public Member selectById(String id);

    public void update(Member member);

    public void delete(String id);

    public Member isMember(Member member);

    /** 자동 로그인 처리를 위한 세션아이디와 유효기간 저장 */
    public void updateLogin(Member member) throws Exception;

    /** 세션아이디에 해당하는 사용자 정보 반환 */
    public Member readLogin(String sessionId) throws Exception;
    
    /** id중복체크 */
    public String isId(String id); 
}
