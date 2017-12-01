package kr.or.kosta.semicolon.chart.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.chart.domain.Chart;

/**
 * @packgename  	 kr.or.kosta.semicolon.chart.dao
 * @filename         ChartDao.java
 * @author           박주연
 * @since            2017. 11. 21.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 21.       박주연        최초 생성
 *
 *
 */
public interface ChartDao {
	/** 회사별로 매출액 반환 */
	public List<Chart> getSalesbyCompany();
	
	/** 달별로 매출액 반환 */
	public List<Chart> getSalesbyMon(Map<String, Object> map);
}
