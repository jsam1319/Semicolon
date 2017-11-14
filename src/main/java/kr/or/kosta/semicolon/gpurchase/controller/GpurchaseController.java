package kr.or.kosta.semicolon.gpurchase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.kosta.semicolon.common.PageBuilder;
import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.goods.service.GoodsService;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;
import kr.or.kosta.semicolon.gpurchase.service.gpurchaseService;

/**
 * @packgename   kr.or.kosta.semicolon.gpurchase.controller
 * @filename         GpurchaseController.java
 * @author          박연주
 * @since            2017. 11. 14.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 14.      kosta         최초 생성
 *
 *
 */
@Controller
@RequestMapping("/product")
public class GpurchaseController {
	
	Logger logger = Logger.getLogger(GpurchaseController.class);
	
	@Inject
	private gpurchaseService gpService;
	
	
	/**
	 * <pre>
	 * 1. 개요 및 처리내용 : 공구 조사 리스트 페이지 이동
	 * </pre>
	 * @Method Name : researchPage
	 * @throws Exception
	 */
	@RequestMapping(value="/research", method=RequestMethod.GET)
	public void researchPage() throws Exception {}
	
	/**
	 * <pre>
	 * 1. 개      요 : 공구 조사 리스트 
	 * 2. 처리내용 : ajax를 이용한 조사 리스트 출력 및 정렬
	 * </pre>
	 * @Method Name : researchList
	 * @param params
	 * @param model
	 * @param page
	 * @param productOrder
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> researchList(Params params, Model model, @PathVariable("page") int page, @RequestParam(value="productOrder", defaultValue="newProduct") String productOrder) throws Exception {
		logger.info("gpurchaseController research 접근");
		
		params.setProductOrder(productOrder);
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			params.setPage(page);
			
			int count = gpService.listCount();
			PageBuilder pb = new PageBuilder(params, count);
			pb.build();
			
			Map<String, Object> map = gpService.listAll(params);
			map.put("pageBuilder", pb);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
/*	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("gpurchaseController list 접근");
		model.addAttribute("list", gpService.listAll());
	}*/
	
	
	/**
	 * <pre>
	 * 1. 개      요 : 공구 상품 상세보기
	 * 2. 처리내용 : 조사가 끝나고 정식 등록된 공구 정보 상세보기
	 * </pre>
	 * @Method Name : select
	 * @param gpurchaseNo
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public void select(@RequestParam("gpurchaseNo") int gpurchaseNo, Model model) throws Exception {
		logger.info("GpurchaseController porudct 접근");
		
		Map<String, Object> map = gpService.select(gpurchaseNo);		
		
		model.addAttribute("gpurchase", (Gpurchase)map.get("gpurchase"));
		model.addAttribute("goods", (Goods)map.get("goods"));
		
	}
	

}
