package kr.or.kosta.semicolon.tops.dao;

import java.util.HashMap;
import java.util.List;

import kr.or.kosta.semicolon.bottom.domain.Bottom;
import kr.or.kosta.semicolon.tops.domain.Tops;
//import kr.or.kosta.semicolon.goods.domain.TakeAllThings;
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
 * 2017. 11. 18.    김미소         최초 생성
 * 2017. 11. 18.    박주연		 getBySize 추가
 * 2017. 11. 20.	박주연		 selectByGoodsNum 추가
 * 2017. 11. 21.	박주연		 getBySizeGoodsNo 추가
 * 2017. 11. 22.	박연주		 selectSize 추가
 *
 */
public interface TopsDao {
	
	/** 상품 등록시 작성한 상의 사이즈 등록 */
	public void insert(Tops tops);
	
	/** 사이즈에 따른 상세정보 조회 (체형별 정보에 사용할 상세정보들) */
	public Tops getBySize(String size);
	
	/** 상품번호에 따른 tops 반환 */
	public List<Tops> selectByGoodsNum(int no);
	
	/** 사이즈, goodsNo에 따른 Tops 반환 */
	public Tops getBySizeGoodsNo(Tops tops);
	
	/** 공구별 상품 사이즈 출력*/
	public List<HashMap<String, String>> selectSize(int gpurchaseNo);
}
>>>>>>> branch 'master' of https://github.com/jsam1319/Semicolon.git
