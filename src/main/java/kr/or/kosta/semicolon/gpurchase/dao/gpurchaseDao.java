package kr.or.kosta.semicolon.gpurchase.dao;

import java.util.List;

import kr.or.kosta.semicolon.common.UseParameter;
import kr.or.kosta.semicolon.gpurchase.domain.CategorySales;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;

/**
 * 
 * @packgename   kr.or.kosta.semicolon.gpurchase.dao
 * @filename         gpurchaseDao.java
 * @author          박연주
 * @since            2017. 11. 10.
 * @see				Gpurchase Table의 Dao
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 10.    박연주        최초 생성
 * 2017. 11. 23		박주연		getSalesByCategory 추가
 * 2017. 11. 28.	박연주		updateResearchCancle 추가
 */
public interface gpurchaseDao {
	
	public void insert(Gpurchase gpurchase) throws Exception;
	
	public List<Gpurchase> gpListAll() throws Exception;
	
	public Gpurchase select(int gpurchaseNo) throws Exception;
	
	public int selectGoodsNo(int gpurchaseNo) throws Exception;
	
	 
	// 조사 공구 카운트 +/-
	public void updateCntP(int gpurchaseNo) throws Exception;
	
	public void updateCntM(int gpurchaseNo) throws Exception;
	
	
	public void delete(int gpurchaseNo) throws Exception;
	
	// 조사 공구, 진행 공구, 완료 공구 리스트
	public List<Gpurchase> listAll(UseParameter params) throws Exception;
	
	public List<Gpurchase> glistAll(UseParameter params) throws Exception;
	
	public List<Gpurchase> endlistAll(UseParameter params) throws Exception;
	
	
	// 기한 내에 목표 인원 채운 조사 공구 리스트
	public List<Integer> selectGolist() throws Exception;
	
	// 조사 및 진행 공구 상태 업데이트(+1)
	public void statusUpdate(Gpurchase gpurchase) throws Exception;
	
	//카테고리별 판매량
	public List<CategorySales> getSalesByCategory();
	
	public void updatePnum(int gpurchaseNo) throws Exception;
	
	// 목표 인원을 채우지 못한 조사 공구 상태 업데이트(-1)
	public void updateResearchCancle(int gpurchaseNo) throws Exception;
	
}
