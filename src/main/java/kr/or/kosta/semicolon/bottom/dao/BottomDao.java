package kr.or.kosta.semicolon.bottom.dao;

import java.util.List;

import kr.or.kosta.semicolon.bottom.domain.Bottom;

/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.bottom.dao
 * @filename         BottomDao.java
 * @author           김미소
 * @since            2017. 11. 20.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 20.     	김미소          최초 생성
 * 2017. 11. 20.		박주연			getByTypesSize, selectByGoodsNum 추가
 * 2017. 11. 21.		박주연			getBySizeGoodsNo추가
 *
 */
public interface BottomDao {
	
	/** 상품 등록시 작성한 하의 사이즈 등록 */
	public void insert(Bottom bottom);
	
	/** types에 따른 샘플 데이터 추출 */
	public Bottom getByTypesSize(Bottom bottom);
	
	/** 상품번호에 따른 bottom 반환 */
	public List<Bottom> selectByGoodsNum(int no);
	
	/** sizes, productNo에 따른 bottom 반환 */
	public Bottom getBySizeGoodsNo(Bottom bottom);
}
