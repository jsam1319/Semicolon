package kr.or.kosta.semicolon.gpurchase.dao;

import java.util.List;

import kr.or.kosta.semicolon.common.Params;
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
 *
 */
public interface gpurchaseDao {
	
	public void insert(Gpurchase gpurchase) throws Exception;
	
	public List<Gpurchase> gpListAll() throws Exception;
	
	public Gpurchase select(int gpurchaseNo) throws Exception;
	
	public int selectGoodsNo(int gpurchaseNo) throws Exception;
	
//	public void update(Gpurchase gpurchase) throws Exception;
	
	public void updateCntP(int gpurchaseNo) throws Exception;
	
	public void updateCntM(int gpurchaseNo) throws Exception;
	
	public void delete(int gpurchaseNo) throws Exception;
	
	public List<Gpurchase> listAll(Params params) throws Exception;
	
	public List<Gpurchase> glistAll(Params params) throws Exception;
	
	public List<Gpurchase> endlistAll(Params params) throws Exception;
	
	public List<Integer> selectGolist() throws Exception;
	
	public void statusUpdate(Gpurchase gpurchase) throws Exception;
	
	//카테고리별 판매량
	public List<CategorySales> getSalesByCategory();
	
	public void updatePnum(int gpurchaseNo) throws Exception;
	
}
