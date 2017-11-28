package kr.or.kosta.semicolon.gwish.dao;

import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.gwish.domain.Gwish;
import kr.or.kosta.semicolon.gwish.domain.GwishDetail;
 
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
 * 2017. 11. 27. 	  박주연		 selectByNo, getListByMemNo 추가
 * 2017. 11. 28.	  Sejong		 selectMemNo 추가
 *
 */
public interface gwishDao {
	
	public void insert(Gwish gwish) throws Exception;
	
	public int selectCnt(Gwish gwish) throws Exception;
	
	public int select(Gwish gwish) throws Exception;
	
	public int delete(int gwishNo) throws Exception;
	
	public int selectMemNo(int gpurchaseNo) throws Exception;
	
	public List<Gwish> selectByMemNo(int gwishNo) throws Exception;
	
	public List<GwishDetail> getListByMemNo(Map<String, Object> map) throws Exception; 

}
