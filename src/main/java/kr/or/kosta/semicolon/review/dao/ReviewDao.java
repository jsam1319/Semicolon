package kr.or.kosta.semicolon.review.dao;

import java.util.List;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.review.domain.Review;

/**
 * @packgename   kr.or.kosta.semicolon.review.dao
 * @filename         ReviewDao.java
 * @author          전세종
 * @since            2017. 11. 15.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 15.      세종         최초 생성
 *
 *
 */
public interface ReviewDao {
	
	public List<Review> allList();
	
	public int insert(Review review);
	
	public Review select(int reviewNo) throws Exception;
	
	public void update(Review review) throws Exception;
	
	public void delete(int reviewNo) throws Exception;
	
	public List<Review> listAll(Params params) throws Exception;
	
	public int listCount() throws Exception;
	
}
