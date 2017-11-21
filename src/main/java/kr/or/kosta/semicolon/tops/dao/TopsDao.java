package kr.or.kosta.semicolon.tops.dao;

import kr.or.kosta.semicolon.goods.domain.TakeAllThings;
import kr.or.kosta.semicolon.tops.domain.Tops;
/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.tops.dao
 * @filename         TopsDao.java
 * @author           김미소
 * @since            2017. 11. 18.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 18.      김미소         최초 생성
 * 2017. 11. 18.      박주연		 getBySize 추가
 *
 *
 */
public interface TopsDao {
	
	/** 상품 등록시 작성한 상의 사이즈 등록 */
	public void insert(Tops tops);
	
	/** 사이즈에 따른 상세정보 조회 (체형별 정보에 사용할 상세정보들) */
	public Tops getBySize(String size);
	
	
}
