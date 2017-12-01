package kr.or.kosta.semicolon.chart.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.kosta.semicolon.chart.domain.Chart;
import kr.or.kosta.semicolon.chart.service.ChartService;
import kr.or.kosta.semicolon.common.enumtype.Category;
import kr.or.kosta.semicolon.common.util.CategoryName;
import kr.or.kosta.semicolon.company.domain.Company;
import kr.or.kosta.semicolon.company.service.CompanyService;
import kr.or.kosta.semicolon.gpurchase.domain.CategorySales;
import kr.or.kosta.semicolon.gpurchase.service.gpurchaseService;

/**
 * @packgename  	 kr.or.kosta.semicolon.chart.controller
 * @filename         ChartController.java
 * @author           박주연
 * @since            2017. 11. 21.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 21.        박주연        최초 생성
 * 2017. 11. 23			박주연		  getLineData추가
 *
 */

@Controller
@RequestMapping(value = "/chart")
public class ChartController {
	@Inject
	ChartService service;
	
	@Inject
	CompanyService comService;
	
	@Inject
	gpurchaseService gService;

	Logger logger = Logger.getLogger(ChartController.class);

	@RequestMapping("/salesline")
	public String drawChart() {
		return "/admin/salesLine";
	}
	
	@RequestMapping("/mul")
	public String drawMultiChart() {
		return "/admin/multichart";
	}

	/**
	 * <pre>
	 * 1. 개       요 : 회사별 전체 매출액 반환
	 * 2. 처 리 내 용 : 회사별 전체 매출액 반환
	 * </pre>
	 * @Method Name : getSalesbyMon
	 * @return  ResponseEntity<Object>
	 */
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public ResponseEntity<Object> getCompanyData() {
		ResponseEntity<Object> entity = null;

		List<Chart> list = service.getSalesbyCompany();

		JSONObject obj;
		JSONArray array = new JSONArray();

		//행에 들어갈 데이터 베이스에 저장되어 있는 모든 company 반환 
		List<Company> companies = comService.listAll();
				
		
		for (Company company : companies) {
			int sales = 0;//매출액
			for (Chart chart : list) {
				if(company.getName().equals(chart.getName())) {
					sales += chart.getSales();
				}
			}
			obj = new JSONObject();
			obj.put("name", company.getName());
			obj.put("y", sales);

			array.add(obj);
		}

		JSONObject sendObj = new JSONObject();
		sendObj.put("array", array);

		entity = new ResponseEntity<Object>(array, HttpStatus.OK);

		return entity;
	}
	
	/**
	 * <pre>
	 * 1. 개       요 : 선택한 date 데이터를 json으로 변환 후 뷰로 전달
	 * 2. 처 리 내 용 : startDate부터 endDate까지 모든 회사들의 수익의 데이터를 받아 json타입으로 만들어서 뷰로 보낸다
	 * </pre>
	 * @Method Name : getSalesbyMon
	 * @param request : HttpServletRequest
	 * @return  ResponseEntity<Object>
	 */
	@RequestMapping(value = "/", method=RequestMethod.PUT)
	public ResponseEntity<Object> getCategoryData() {
		ResponseEntity<Object> entity = null;
		
		List<CategorySales> list = gService.getSalesByCategory();
		
		JSONObject obj;
		JSONArray array = new JSONArray();
		Category[] categories = Category.values();
		
		for (int i = 0; i < categories.length; i++) {
			int price = 0;
			for (CategorySales cs : list) {
				if( categories[i].equals(Category.valueOfNo( cs.getCategory() )) ){
					price += cs.getPrice();
				}
			}
			obj = new JSONObject();
			obj.put("name",categories[i].toString());
			obj.put("y", price);

			array.add(obj);
		}
		

		JSONObject sendObj = new JSONObject();
		sendObj.put("array", array);

		entity = new ResponseEntity<Object>(array, HttpStatus.OK);

		return entity;
	}

	/**
	 * <pre>
	 * 1. 개       요 : 선택한 date 데이터를 json으로 변환 후 뷰로 전달
	 * 2. 처 리 내 용 : startDate부터 endDate까지 모든 회사들의 수익의 데이터를 받아 json타입으로 만들어서 뷰로 보낸다
	 * </pre>
	 * @Method Name : getSalesbyMon
	 * @param request : HttpServletRequest
	 * @return  ResponseEntity<Object>
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Object> getLineData(HttpServletRequest request){
		
		ResponseEntity<Object> entity = null;

		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String sSize = request.getParameter("size");
		int size = Integer.parseInt(sSize);
		
//		logger.debug("start:"+start+",end:"+end+",size:"+size);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM");
		Date startDate = null ;
		Date endDate = null;
		
		try {
			//string형을 date타입으로 변환
			startDate = formatter.parse(start);
			endDate = formatter.parse(end);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//각 달별로 회사들의 판매량을 반환
		List<List<Chart>> result = service.getSalesbyMon(startDate, endDate, size);
		int companyNum = comService.count();
		
		/** chart의 y축에 들어갈 data들을 회사들별로 담는 array */
		int[][] array = new int[companyNum][size];
		
		JSONArray jsonArr = new JSONArray();
		JSONObject obj;
		JSONObject rsObj = new JSONObject();
		
		if (result != null) {
			for(int i=0; i<companyNum; i++) {
				for(int j=0; j<size-1; j++) {
						array[i][j] = result.get(j).get(i).getSales();
				}
			}
			
			//json 저장
			for(int k=0; k<companyNum; k++) {
				obj = new JSONObject();
				//모든 달에 모든 회사가 들어가있기 때문에 굳이 이중 for문을 또 돌려서 가져올필요가 없기 때문에 result.get(0)을 하였음 
				obj.put("name", result.get(0).get(k).getName()); 
				obj.put("data", array[k]);
				jsonArr.add(obj);
			}
		} // end if
	
		rsObj.put("seriesData", jsonArr);
		rsObj.put("xAxisData", service.getMon());

		entity = new ResponseEntity<Object>(rsObj, HttpStatus.OK);
	
		return entity;
	}
	

}
