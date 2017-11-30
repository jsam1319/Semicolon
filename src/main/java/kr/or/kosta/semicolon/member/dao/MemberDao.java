package kr.or.kosta.semicolon.member.dao;

import java.util.Date;
import java.util.List;
import kr.or.kosta.semicolon.member.domain.Member;

/**
 * @packgename    kr.or.kosta.semicolon.member.dao
 * @filename            MemberDao.java
 * @author             JaeHyun
 * @since                2017. 11. 8.
 * @see                    Member Table의 Dao
 * @packgename kr.or.kosta.semicolon.member.dao
 * @filename MemberDao.java
 * @author JaeHyun
 * @since 2017. 11. 8.
 * @see Member Table의 Dao
 *
 * == Modification Infomation (수정 이력) ==
 *      == Modification Infomation (수정 이력) ==
 * 
 *    
 *   DATE          AUTHOR         NOTE
 * --------        -----------    ---------------------------------------
 * 2017. 11. 8.     JaeHyun    		최초 생성
 * 2017. 11. 9.     박주연         crud 추가
 * 2017. 11. 24.    박연주			selectOrderInfo 추가
 * 2017. 11. 28.	Sejong			selectToken, updateToken 추가
 * 2017. 11. 29.	박연주			selectName 추가
 */

public interface MemberDao {

    
    public List<Member> listAll();
    
    public int insert(Member member);
    
    public int insertAuthority(Member member);

    public Member select(int no);
    
    public String selectToken(int no);
    
    public Member selectById(String username);

    public void update(Member member);

    public void delete(String id);
    
    public void deleteAuthority(String id);

    public Member isMember(Member member);

    /** 자동 로그인 처리를 위한 세션아이디와 유효기간 저장 */
    public void updateLogin(Member member) throws Exception;
    
    /** 자동 로그인시 토큰을 저장 */
    public void updateToken(Member member) throws Exception;

    /** 세션아이디에 해당하는 사용자 정보 반환 */
    public Member readLogin(String sessionId) throws Exception;
    
    /** 아이디 중복체크 */
    public String isId(String id) ;
    
    /** 공구 주문하는 사람 기본 정보 */
    public Member selectOrderInfo(int memberNo) throws Exception;
    
    public String selectName(int memberNo) throws Exception;

}
