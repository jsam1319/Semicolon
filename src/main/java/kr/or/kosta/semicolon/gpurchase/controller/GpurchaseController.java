package kr.or.kosta.semicolon.gpurchase.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.kosta.semicolon.askresale.domain.AskResale;
import kr.or.kosta.semicolon.askresale.service.askResaleService;
import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.gpurchase.CompareTime;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;
import kr.or.kosta.semicolon.gpurchase.service.gpurchaseService;
import kr.or.kosta.semicolon.gwish.domain.Gwish;
import kr.or.kosta.semicolon.gwish.service.gwishService;

/**
 * @packgename kr.or.kosta.semicolon.gpurchase.controller
 * @filename GpurchaseController.java
 * @author 박연주
 * @since 2017. 11. 14.
 * @see 공구 관리를 위한 Controller
 *
 *      == Modification Infomation (수정 이력) ==
 * 
 *      DATE AUTHOR NOTE -------- -----------
 *      --------------------------------------- 2017. 11. 14. 박연주 최초 생성
 *
 *
 */
@Controller
@RequestMapping("/product")
public class GpurchaseController {

	Logger logger = Logger.getLogger(GpurchaseController.class);

	@Inject
	private gpurchaseService gpService;

	@Inject
	private gwishService wishService;
	
	@Inject
	private askResaleService askService;

	/**
	 * <pre>
	 * 1. 개요 및 처리내용 : 공구 조사 리스트 페이지 이동
	 * </pre>
	 * 
	 * @Method Name : researchPage
	 * @throws Exception
	 */
	@RequestMapping(value = "/research/{category}", method = RequestMethod.GET)
	public String researchPage(@PathVariable("category") int category) throws Exception {
		logger.info("researchPage 접근");

		return "/product/research";
	}
	/*
	@RequestMapping(value="/research", method=RequestMethod.GET)
	public String researchPage(int category) {
		logger.info("rp 접근");
		
		return "forward:/product/research/"+category;
	}
	
	@RequestMapping(value="/research/{category}", method=RequestMethod.POST)
	public String research() {
		logger.info("research 접근");
		
		return "/product/research";
	}
*/
	/*
	 * @RequestMapping(value="/research", method=RequestMethod.POST) public void
	 * researchPagePost(RedirectAttributes rttr, int category) throws Exception {
	 * logger.info("POSTcategory : " +category); }
	 */
	/**
	 * <pre>
	 * 1. 개      요 : 공구 조사 리스트 
	 * 2. 처리내용 : ajax를 이용한 조사 리스트 출력 및 정렬
	 * </pre>
	 * 
	 * @Method Name : researchList
	 * @param params
	 *            : 페이징에 필요한 파라미터들을 저장하기 위한 JavaBean
	 * @param page
	 *            : 요청받은 페이지
	 * @param productOrder
	 *            : 요청받은 페이지 정렬 value
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/research/{category}/{page}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> researchList(Params params, @PathVariable("category") int category,
			@PathVariable("page") int page,
			@RequestParam(value = "productOrder", defaultValue = "newProduct") String productOrder) throws Exception {
		logger.info("gpurchaseController research 접근");

		ResponseEntity<Map<String, Object>> entity = null;
		try {
			params.setPage(page);
			params.setProductOrder(productOrder);

			Map<String, Object> map = gpService.listAll(params, category);

			// 공구 조사 페이지에서 공구 리스트 페이지로 넘어가는 데이터 가져오기
			List<Integer> golist = gpService.selectGolist();
			map.put("golist", golist);

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	/**
	 * <pre>
	 * 1. 개      요 : 공구 조사 페이지 상품 상세보기
	 * 2. 처리내용 : 상품 상세정보를 modal로 띄우기 위한 ajax
	 * </pre>
	 * 
	 * @Method Name : researchSelect
	 * @param gpurchaseNo
	 *            : 상세보기를 띄우기 위한 해당 공구조사 번호
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{gpurchaseNo}/{memberNo}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> researchSelect(@PathVariable("gpurchaseNo") int gpurchaseNo,
			@PathVariable("memberNo") int memberNo) throws Exception {
		logger.info("gpurchaseController researchSelect 접근");

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			Map<String, Object> map = gpService.select(gpurchaseNo);

			Gwish gwish = new Gwish(gpurchaseNo, memberNo);

			map.put("gwishCheck", wishService.selectCnt(gwish));

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	/**
	 * <pre>
	 * 1. 개      요 : 공구조사 버튼 동작
	 * 2. 처리내용 :  공동구매조사페이지 wish 참여 / 취소 동작 ajax
	 * </pre>
	 * 
	 * @Method Name : wishCheck
	 * @param wishck
	 *            : 공구조사에 참여했는지에 대한 반환 count
	 * @param gpurchaseNo
	 *            : 공구 번호
	 * @param memberNo
	 *            : 멤버 번호
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{gwishCheck}/{gpurchaseNo}", method = RequestMethod.POST)
	public ResponseEntity<Integer> wishCheck(@PathVariable("gwishCheck") int wishck,
			@PathVariable("gpurchaseNo") int gpurchaseNo,
			@RequestParam(value = "memberNo", defaultValue = "1") int memberNo) throws Exception {
		logger.info("gpurchaseController wishCheck 접근");

		ResponseEntity<Integer> entity = null;

		Gwish gwish = new Gwish(gpurchaseNo, memberNo);

		try {
			// 참여버튼, 공구조사참여하지 않았을 때
			if (wishck == 0) {
				wishService.insert(gwish);
				gpService.updateCntP(gpurchaseNo);

				// 취소버튼, 공구조사참여했을 때
			} else {
				int gwishNo = wishService.select(gwish);

				wishService.delete(gwishNo);
				gpService.updateCntM(gpurchaseNo);
			}

			int gwishCheck = wishService.selectCnt(gwish);

			entity = new ResponseEntity<Integer>(gwishCheck, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	
	
	

	/**
	 * <pre>
	 * 1. 개      요 : 공구 list 페이지
	 * 2. 처리내용 : 공구 list 페이지로 이동
	 * </pre>
	 * 
	 * @Method Name : listPage
	 * @throws Exception
	 */
	@RequestMapping(value = "/list/{category}", method = RequestMethod.GET)
	public String listPage(@PathVariable("category") int category) throws Exception {
		logger.info("listPage 접근");
		return "/product/list";
	}

	
	/**
	 * <pre>
	 * 1. 개      요 : 공구 list 상품 list
	 * 2. 처리내용 : ajax를 이용한 공구 리스트 출력 및 정렬
	 * </pre>
	 * 
	 * @Method Name : gpurchaseList
	 * @param params
	 *            : 페이징에 필요한 파라미터들을 저장하기 위한 JavaBean
	 * @param page
	 *            : 요청받은 페이지
	 * @param productOrder
	 *            : 요청받은 페이지 정렬 value
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list/{category}/{page}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> gpurchaseList(Params params, Model model,
			@PathVariable("category") int category, @PathVariable("page") int page,
			@RequestParam(value = "productOrder", defaultValue = "newProduct") String productOrder) throws Exception {
		logger.info("gpurchaseController gpurchaseList 접근");

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			params.setPage(page);
			params.setProductOrder(productOrder);

			Map<String, Object> map = gpService.glistAll(params, category);

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();

			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	
	/**
	 * <pre>
	 * 1. 개      요 : 완료된 공구 리스트
	 * 2. 처리내용 : 끝난 공구 리스트 출력
	 * </pre>
	 * @Method Name : endList
	 * @param params
	 * @param model
	 * @param category
	 * @param page
	 * @param productOrder
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list/{category}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> endList(Params params, Model model,
			@PathVariable("category") int category, @PathVariable("page") int page,
			@RequestParam(value = "productOrder", defaultValue = "newProduct") String productOrder) throws Exception {
		logger.info("gpurchaseController endList 접근");

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			params.setPage(page);
			params.setProductOrder(productOrder);
			
			Map<String, Object> map = gpService.endlistAll(params, category);

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();

			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	
	/**
	 * <pre>
	 * 1. 개      요 : 공구 상품 상세보기
	 * 2. 처리내용 : 조사가 끝나고 정식 등록된 공구 정보 상세보기
	 * </pre>
	 * 
	 * @Method Name : select
	 * @param gpurchaseNo
	 * @param model
	 * @throws Exception
	 */
//	@ResponseBody
	@RequestMapping(value = "/gpurchase/{gpurchaseNo}/{memberNo}", method = RequestMethod.GET) 
	public String select(@PathVariable("gpurchaseNo") int gpurchaseNo, Model model, @PathVariable("memberNo") int memberNo) throws Exception {
		Map<String, Object> map = gpService.select(gpurchaseNo);
		
		AskResale askResale = new AskResale(gpurchaseNo, memberNo);
		int askCnt = askService.selectCnt(askResale);
		
		model.addAttribute("gpurchase", (Gpurchase) map.get("gpurchase"));
		model.addAttribute("goods", (Goods) map.get("goods"));
		model.addAttribute("companyName", map.get("companyName"));
		model.addAttribute("askCnt", askCnt);
		
		logger.info("askCnt : "+askCnt);

		return "product/product";

	}
	
	

	/**
	 * <pre>
	 * 1. 개      요 : 마감된 공구 재공구 요청
	 * 2. 처리내용 : 마감된 공구 재공구 요청 및 취소
	 * </pre>
	 * @Method Name : askCheck
	 * @param askck
	 * @param gpurchaseNo
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/askck/{gaskCheck}/{gpurchaseNo}", method = RequestMethod.POST)
	public ResponseEntity<Integer> askCheck(@PathVariable("gaskCheck") int askck,
			@PathVariable("gpurchaseNo") int gpurchaseNo, int memberNo) throws Exception {
		logger.info("gpurchaseController askCheck 접근");

		ResponseEntity<Integer> entity = null;

		AskResale askResale = new AskResale(gpurchaseNo, memberNo);

		try {
			// 공구재요청버튼 클릭시, 공구재요청을 하지 않았을 때
			if (askck == 0) {
				
				askService.insert(askResale);

				// 요청취소버튼, 공구재요청 참여했을  때
			} else {
				int askResaleNo = askService.select(askResale);

				askService.delete(askResaleNo);
			}

			int askCheck = askService.selectCnt(askResale);

			entity = new ResponseEntity<Integer>(askCheck, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	
	/**
	 * <pre>
	 * 1. 개      요 : 등록 기간이 끝나는 상품들 자동 이벤트
	 * 2. 처리내용 : 매일 자정 자동으로 DB에 저장된 끝나는 기간과 현재 시간을 비교해 이벤트 발생
	 * </pre>
	 * @Method Name : updateStatus
	 * @throws Exception
	 */
	@Scheduled(cron = "0 00 00 * * *")
	public void updateStatus() throws Exception {
		logger.info("updateStatus 들어옴");
		List<Gpurchase> list = gpService.gpListAll();

		for (Gpurchase gpurchase : list) {
			CompareTime time = new CompareTime(gpurchase.getEndDate());
			
			String compare = time.timeCount();
			int likeCnt = gpurchase.getLikeCnt();
			int min = gpurchase.getMin();

			if (compare != null && likeCnt >= min) {
				gpService.statusUpdate(gpurchase);
			}
		}
	}
	
	
}
