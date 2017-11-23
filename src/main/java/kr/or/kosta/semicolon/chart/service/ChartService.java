package kr.or.kosta.semicolon.chart.service;

import java.util.Date;
import java.util.List;

import kr.or.kosta.semicolon.chart.domain.Chart;

/**
 * @packgename  	 kr.or.kosta.semicolon.chart.service
 * @filename         ChartService.java
 * @author           박주연
 * @since            2017. 11. 21.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 21.        박주연        최초 생성
 * 2017. 11. 22.		박주연		  getMon추가
 *
 */
public interface ChartService {
	
	/** 회사별로 매출액 반환 */
	public List<Chart> getSalesbyCompany();
	
	/** 달별로 매출액 반환 */
	public List<List<Chart>> getSalesbyMon(Date start, Date end, int size);
	
	/** listChrt x축에 들어갈 월 반환 */
	public String[] getMon();
}
