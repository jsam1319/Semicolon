package kr.or.kosta.semicolon.membersize.dao;

import java.util.List;

import kr.or.kosta.semicolon.membersize.domain.MemberSize;

/**
 * @packgename  	 kr.or.kosta.semicolon.membersize.dao
 * @filename         MemberSizeDao.java
 * @author           박주연
 * @since            2017. 11. 16.
 * @see				 MemberSize(회원별 체형정보) 테이블에 관한 dao 인터페이스
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 16.       박주연        최초 생성
 *
 *
 */

//테스트요
public interface MemberSizeDao {
	public int insert(MemberSize size);
	public MemberSize select(int no);
	public void update(MemberSize size);
	public void delete(int no);
	public List<MemberSize> listAll();
}
