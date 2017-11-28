package kr.or.kosta.semicolon.member.service;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.member.dao.MemberDao;
import kr.or.kosta.semicolon.member.domain.Member;
import kr.or.kosta.semicolon.member.util.RSAUtil;

/**
 * @packgename    kr.or.kosta.semicolon.member.service
 * 
 *   DATE          AUTHOR         NOTE
 * --------        -----------    ---------------------------------------
 * 2017. 11. 8.        JaeHyun      최초 생성
 * 2017. 11. 9.        박주연       crud 생성
 * 2017. 11. 15.	   박주연		isMember, selectById, updateLogin, readLogin, isId 추가
 * 2017. 11. 24.	   박연주		selectOrderInfo 추가
 * 2017. 11. 28.	   Sejong		selectAppToken, updateToken 추가
 * 	
 */

@Service
 public class MemberServiceImpl implements MemberService{   
    @Inject
    MemberDao memberDao;
    
    /** RSA암호화 방식을 이용한 암호화, 복호화 클래스 */
    RSAUtil rsaUtil; 
    
    Logger logger = Logger.getLogger(MemberServiceImpl.class);
    
	 @Override
    public List<Member> listAll() {
        return memberDao.listAll();
    }

    @Override
    public int insert(Member member) {
    	rsaUtil = new RSAUtil();
    	String rawPassword = member.getPassword();
    	String encodedPassword = rsaUtil.encrypte(rawPassword);
    	
    	Encoder encoder = Base64.getEncoder();
    	
    	member.setPassword(encodedPassword);
    	member.setPublicEncoded(encoder.encodeToString(rsaUtil.getPublicEncoded()));
    	member.setPrivateEncoded(encoder.encodeToString(rsaUtil.getPrivateEncoded()));
    	
        return memberDao.insert(member);
        
    }
    
    @Override
    public Member select(int no) {
        return memberDao.select(no);
    }
    
    @Override
    public String selectToken(int no) {
    	return  memberDao.selectToken(no);
    }
    
    @Override
    public Member selectById(String username) {
    	Member member = memberDao.selectById(username);
    	return member;
    }
    
    @Override
    public void update(Member member) {
        memberDao.update(member);
    }
    
    @Override
    public void delete(String id) {
        memberDao.delete(id);
    }
    
    /**
     * <pre>
     * 1. 개       요  :   멤버인지 확인
     * 2. 처 리 내 용  :   저장되어있는 privateKey와 publicKey를 이용해 암호를 해독한 뒤 사용자가 입력한 아이디와 비밀번호가 
     * 					   저장되어 있는 것인지 비교한다. String형을 byte[] 로 바꾸기 위해 Base 64 사용한다.
     * </pre>
     * @Method Name : updateLogin
     * @param : member	사용자 도메인
     */
    @Override
    public Member isMember(Member inputM) {
    	rsaUtil = new RSAUtil();
    	Member rsM = memberDao.selectById(inputM.getId());
    	
    	if (rsM!=null) {
    		try {
    			Decoder decoder = Base64.getDecoder();
    			rsaUtil.setPrivateKey(decoder.decode(rsM.getPrivateEncoded()));
    			rsaUtil.setPublicKey(decoder.decode(rsM.getPublicEncoded()));
    			String decrypted = rsaUtil.decrypte(rsM.getPassword());
    			if(inputM.getPassword().equals(decrypted)) {
    				return rsM;
    			}
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	return null;
    }


    
    /**
     * <pre>
     * 1. 개       요  :   자동 로그인 처리에 따른 업데이트
     * 2. 처 리 내 용  :   자동 로그인 처리를 위한 세션아이디와 유효기간 저장
     * </pre>
     * @Method Name : updateLogin
     * @param : member	사용자 도메인
     */
    @Override
    public void updateLogin(Member member) throws Exception{
        memberDao.updateLogin(member);
    }
    
    @Override
    public void updateToken(Member member) throws Exception {
    	memberDao.updateToken(member);
    }

    /**
     * <pre>
     * 1. 개       요  :   세션아이디에 해당하는 사용자 정보 반환
     * 2. 처 리 내 용  :   로그인 처리를 위해 필요한 세션아이디에 해당하는 사용자 정보 반환
     * </pre>
     * @Method Name : readLogin
     * @param : sessionId	세션아이디
     */
    @Override
    public Member readLogin(String sessionId) throws Exception{
        return memberDao.readLogin(sessionId);
    }
    
    /**
     * <pre>
     * 1. 개       요  :   id 중복체크
     * 2. 처 리 내 용  :   id 중복체크
     * </pre>
     * @Method Name : isId
     * @param : id	
     */
    @Override
    public String isId(String id) {
    	return memberDao.isId(id);
    }
    
    @Override
    /** 공구 주문하는 사람 기본 정보 */
    public Member selectOrderInfo(int memberNo) throws Exception {
    	return memberDao.selectOrderInfo(memberNo);
    }
}
    