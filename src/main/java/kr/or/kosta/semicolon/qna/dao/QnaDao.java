package kr.or.kosta.semicolon.qna.dao;

import java.util.List;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.qna.domain.Qna;

/**
 * @packgename   kr.or.kosta.semicolon.qna.dao
 * @filename         QnaDao.java
 * @author          전세종
 * @since            2017. 11. 13.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 13.      세종         최초 생성
 *
 *
 */

public interface QnaDao {
	
	public List<Qna> allList();
	
	public int insert(Qna qna);
	
	public Qna select(int qnaNo) throws Exception;
	
	public void update(Qna qna);
	
	public void modify(Qna qna) throws Exception;
	
	public List<Qna> listAll(Params params) throws Exception;
	
}
