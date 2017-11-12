package kr.or.kosta.semicolon.member.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.member.dao.MemberDao;
import kr.or.kosta.semicolon.member.domain.Member;

/**
 * @packgename    kr.or.kosta.semicolon.member.service
 * 
 *   DATE          AUTHOR         NOTE
 * --------        -----------    ---------------------------------------
 * 2017. 11. 8.        JaeHyun    최초 생성
 * 2017. 11. 8.        JaeHyun        최초 생성
 * 2017. 11. 9.        박주연        crud 생성
 *
 *
 */

@Service
 public class MemberServiceImpl implements MemberService{   
    @Inject
    MemberDao memberDao;
    
	 @Override
    public List<Member> listAll() {
        // TODO Auto-generated method stub
        return memberDao.listAll();
    }

    @Override
    public int insert(Member member) {
        // TODO Auto-generated method stub
        return memberDao.insert(member);
        
    }
    
    @Override
    public Member select(int no) {
        return memberDao.select(no);
    }
    
    @Override
    public void update(Member member) {
        memberDao.update(member);
    }
    
    @Override
    public void delete(int no) {
        memberDao.delete(no);
    }
    
    @Override
    public Member isMember(Member member) {
        return memberDao.isMember(member);
    }
    
    @Override
    public void updateLogin(Member member) throws Exception{
        memberDao.updateLogin(member);
    }

    @Override
    public Member readLogin(String sessionId) throws Exception{
        return memberDao.readLogin(sessionId);
    }
    
}
