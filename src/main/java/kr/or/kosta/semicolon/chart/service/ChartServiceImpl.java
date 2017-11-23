package kr.or.kosta.semicolon.chart.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.chart.dao.ChartDao;
import kr.or.kosta.semicolon.chart.domain.Chart;
import kr.or.kosta.semicolon.company.domain.Company;
import kr.or.kosta.semicolon.company.service.CompanyService;

/**
 * @packgename kr.or.kosta.semicolon.chart.service
 * @filename ChartServiceImpl.java
 * @author 박주연
 * @since 2017. 11. 21.
 * @see
 *
 * 		== Modification Infomation (수정 이력) ==
 * 
 *      DATE 			AUTHOR 			NOTE 
 *      -------- 		----------- 	--------------------------------------- 
 *      2017. 11. 21. 	박주연 			최초 생성
 *
 *
 */

@Service
public class ChartServiceImpl implements ChartService {
	@Inject
	ChartDao dao;
	
	@Inject
	CompanyService service;

	Logger logger = Logger.getLogger(ChartServiceImpl.class);

	private String[] month;
	
	@Override
	public List<Chart> getSalesbyCompany() {
		return dao.getSalesbyCompany();
	}

	/**
	 * <pre>
	 * 1. 개       요 : 선택한 date만큼 회사별로 list<list<chart>>를 구해 반환
	 * 2. 처 리 내 용 : startDate부터 endDate까지 모든 회사들의 수익을 구해, 회사별로 list<list<chart>>를 구해 반환한다.
	 * </pre>
	 * @Method Name : getSalesbyMon
	 * @param start : startDate
	 * @param end : endDate
	 * @param size : startDate와 endDate간의 개월 수
	 * @return List<List<Chart>>
	 */
	@Override
	public List<List<Chart>> getSalesbyMon(Date start, Date end, int size) {
		//행 수 : companyNo, 열 수 : size 
		List<List<Chart>> result = new ArrayList<List<Chart>>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM");
		Date date;
		Calendar cal;
		Map<String, Object> map;
		int i=0;
		month = new String[size];
		
		//행에 들어갈 데이터 베이스에 저장되어 있는 모든 company 반환 
		List<Company> companies = service.listAll();
		
		try {
			date = start;
			cal = Calendar.getInstance();
			cal.setTime(date);
			
			//내가 선택한 endDate까지! 뽑아오기 위해 endDate에 1달을 더한다 
			Calendar tmpEnd = Calendar.getInstance();
			tmpEnd.setTime(end);
			tmpEnd.add(Calendar.MONTH, 1);
			end = tmpEnd.getTime();
			
			while( end.compareTo(date) != 0) {
				map = new HashMap<String, Object>();
				
				//startDate
				date = cal.getTime();
				map.put("startDate", date);
				month[i++] = formatter.format(date);
				
				//endDate
				cal.add(Calendar.MONTH, 1);
				date = cal.getTime();
				map.put("endDate", date);
				
				List<Chart> chartList = new ArrayList<Chart>();
				
				//회사별로 수익을 구한다
				for (Company company : companies) {
					map.put("company", company.getName());
					Chart chart = dao.getSalesbyMon(map);
					if(chart != null) {
						chartList.add(chart);
					}else {
						//선택한 달에 수입이 0원이라면 null값으로 나오기 때문에 새로 chart를 추가해준다
						chart = new Chart();
						chart.setSales(0);
						chart.setName(company.getName());
						chart.setCompanyNo(company.getCompanyNo());
						chartList.add(chart);
					}
				}
				
				result.add(chartList);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	@Override
	public String[] getMon(){
		return month;
	}
	
}
