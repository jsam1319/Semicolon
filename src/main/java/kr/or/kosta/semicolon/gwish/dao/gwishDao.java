package kr.or.kosta.semicolon.gwish.dao;

import kr.or.kosta.semicolon.gwish.domain.Gwish;
 
/**
 * @packgename   kr.or.kosta.semicolon.gwish.dao
 * @filename         gwishDao.java
 * @author          박연주
 * @since            2017. 11. 20.
 * @see			Gwish 테이블의 Dao
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 20.      박연주         최초 생성
 *
 *
 */
public interface gwishDao {
	
	public void insert(Gwish gwish) throws Exception;
	
	public int selectCnt(Gwish gwish) throws Exception;
	
	public int select(Gwish gwish) throws Exception;
	
	public void delete(int gwishNo) throws Exception;

}
