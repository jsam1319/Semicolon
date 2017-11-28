package kr.or.kosta.semicolon.aftersales.dao;

import java.util.List;

import kr.or.kosta.semicolon.aftersales.domain.AfterSales;
import kr.or.kosta.semicolon.common.UseParameter;

/**
 * @packgename   kr.or.kosta.semicolon.service.dao
 * @filename         ServiceDao.java
 * @author          Jeon SeJong
 * @since            2017. 11. 20.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 20.      sejong         최초 생성
 *
 *
 */
public interface AfterSalesDao {
	
	public int insert(AfterSales aftersales);
	
	public AfterSales select(int aftersalesNo);
	
	public void update(int aftersalesNo);
	
	public void delete(int aftersalesNo);
	
	public List<AfterSales> listAll(UseParameter params);
	
}
