package kr.or.kosta.semicolon.gpurchase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import kr.or.kosta.semicolon.askresale.domain.AskResale;
import kr.or.kosta.semicolon.askresale.service.askResaleService;
import kr.or.kosta.semicolon.common.KeywordParameter;
import kr.or.kosta.semicolon.common.UseParameter;
import kr.or.kosta.semicolon.common.enumtype.LogType;
import kr.or.kosta.semicolon.common.util.CompareTime;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.goods.service.GoodsService;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;
import kr.or.kosta.semicolon.gpurchase.domain.GpurchaseInfo;
import kr.or.kosta.semicolon.gpurchase.service.gpurchaseService;
import kr.or.kosta.semicolon.gwish.domain.Gwish;
import kr.or.kosta.semicolon.gwish.service.gwishService;
import kr.or.kosta.semicolon.keyword.service.KeywordService;
import kr.or.kosta.semicolon.log.domain.Log;
import kr.or.kosta.semicolon.log.service.LogService;
import kr.or.kosta.semicolon.member.service.MemberService;
import kr.or.kosta.semicolon.negolist.domain.NegoList;
import kr.or.kosta.semicolon.negolist.service.NegoListService;
import kr.or.kosta.semicolon.push.domain.PushToken;
import kr.or.kosta.semicolon.push.service.PushTokenService;

/**
 * @packgename 	kr.or.kosta.semicolon.gpurchase.controller
 * @filename 	GpurchaseController.java
 * @author 		박연주
 * @since 		2017. 11. 14.
 * @see 		공구 관리를 위한 Controller
 *
 * == Modification Infomation (수정 이력) ==
 * 
 * 	  DATE 			AUTHOR 			NOTE 
 *  --------      -----------   ---------------------------------------
 * 2017. 11. 14. 	   박연주 			최초 생성
 * 2017. 11. 15.	   김미소			insert 추가
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
	
	@Inject
	private GoodsService goodsService;
	
	@Inject
	private MemberService memService;
	
	@Inject
	private PushTokenService pushService;
	
	@Inject
	private KeywordService keywordService;
	
	@Inject
	private LogService logService;
	
	@Inject
	private NegoListService negoListService;
	
	@RequestMapping(value="/insert/{goodsNo}", method=RequestMethod.GET)
	public String insert(@PathVariable("goodsNo") int goodsNo, Model model) throws Exception {
//		logger.info("Product Insert...GET");
		
		Goods goods = new Goods();
		goods = goodsService.select(goodsNo);
		
		NegoList negoList = new NegoList();
		negoList = negoListService.select(goodsNo);
		
		model.addAttribute("goods", goods);
		model.addAttribute("negoList", negoList);
		
		return "/product/insert";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(Gpurchase gpurchase, int category) throws Exception {
//		logger.info("Product Insert...POST");
		
		gpService.insert(gpurchase);
		
		return "redirect:/product/research/"+category;
	}

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
//		logger.info("researchPage 접근");

		return "/product/research";
	}
	
	
	/**
	 * <pre>
	 * 1. 개      요 : 공구 조사 리스트 
	 * 2. 처리내용 : ajax를 이용한 조사 리스트 출력 및 정렬
	 * </pre>
	 * 
	 * @Method Name : researchList
	 * @param params : 페이징에 필요한 파라미터들을 저장하기 위한 JavaBean
	 * @param page : 요청받은 페이지
	 * @param productOrder : 요청받은 페이지 정렬 value
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/research/{category}/{page}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> researchList(@PathVariable("category") int category, @PathVariable("page") int page,
			@RequestParam(value = "productOrder", defaultValue = "newProduct") String productOrder) throws Exception {
//		logger.info("gpurchaseController research 접근");
		
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			Map<String, Object> map = new HashMap<>();
			
			UseParameter parameter = new UseParameter(page, productOrder, 0, category);

			List<GpurchaseInfo> list = gpService.ListAll(parameter);
			map.put("list", list);

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
	 * @param gpurchaseNo : 상세보기를 띄우기 위한 해당 공구조사 번호
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{gpurchaseNo}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> researchSelect(@PathVariable("gpurchaseNo") int gpurchaseNo,
			HttpServletRequest request) throws Exception {
//		logger.info("gpurchaseController researchSelect 접근");
		Log log = new Log();

		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("no");

		log.setMemberNo(memberNo);
		log.setContent(String.valueOf(gpurchaseNo));
		log.setType(LogType.VIEW.name());
		logService.insert(log);
		
		ResponseEntity<Map<String, Object>> entity = null;

		try {
			Map<String, Object> map = gpService.select(gpurchaseNo, memberNo);

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
	 * @param wishck : 공구조사에 참여했는지에 대한 반환 count
	 * @param gpurchaseNo : 공구 번호
	 * @param memberNo : 멤버 번호
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{gwishCheck}/{gpurchaseNo}", method = RequestMethod.POST)
	public ResponseEntity<Integer> wishCheck(@PathVariable("gwishCheck") int wishck,
			@PathVariable("gpurchaseNo") int gpurchaseNo, HttpServletRequest request) throws Exception {
//		logger.info("gpurchaseController wishCheck 접근");

		ResponseEntity<Integer> entity = null;
		
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("no");

		Gwish gwish = new Gwish(gpurchaseNo, memberNo);

		try {
			// 참여버튼, 공구조사참여하지 않았을 때
			if (wishck == 0) {
				wishService.insert(gwish);
				gpService.updateCntP(gpurchaseNo);
				
				Log log = new Log();
				log.setMemberNo(memberNo);
				log.setContent(String.valueOf(gpurchaseNo));
				log.setType(LogType.BEFORELIKE.name());
				logService.insert(log);
				

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
//		logger.info("listPage 접근");
		return "/product/list";
	}

	
	/**
	 * <pre>
	 * 1. 개      요 : 공구 list 상품 list
	 * 2. 처리내용 : ajax를 이용한 공구 리스트 출력 및 정렬
	 * </pre>
	 * 
	 * @Method Name : gpurchaseList
	 * @param params : 페이징에 필요한 파라미터들을 저장하기 위한 JavaBean
	 * @param page : 요청받은 페이지
	 * @param productOrder : 요청받은 페이지 정렬 value
	 * @return List<Gpurchase>
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/list/{category}/{page}", method = RequestMethod.POST)
	public List<GpurchaseInfo> gpurchaseList(@PathVariable("category") int category, @PathVariable("page") int page,
			@RequestParam(value = "productOrder", defaultValue = "newProduct") String productOrder) throws Exception {
//		logger.info("gpurchaseController gpurchaseList 접근");
		
		UseParameter parameter = new UseParameter(page, productOrder, 1, category);
		
		List<GpurchaseInfo> list = gpService.ListAll(parameter);
		
		return list;

	}
	
	
	/**
	 * <pre>
	 * 1. 개      요 : 완료된 공구 리스트
	 * 2. 처리내용 : 끝난 공구 리스트 출력
	 * </pre>
	 * @Method Name : endList
	 * @param category : 상품 분류 카테고리 번호
	 * @param page : 요청받은 페이지
	 * @param productOrder : 요청받은 정렬 순서
	 * @return List<Gpurchase>
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/list/{category}/{page}", method = RequestMethod.GET)
	public List<GpurchaseInfo> endList(@PathVariable("category") int category, @PathVariable("page") int page,
			@RequestParam(value = "productOrder", defaultValue = "newProduct") String productOrder) throws Exception {
//		logger.info("gpurchaseController endList 접근");
		
		UseParameter parameter = new UseParameter(page, productOrder, 2, category);
		
		List<GpurchaseInfo> list = gpService.ListAll(parameter);
		
		return list;

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
	@RequestMapping(value = "/gpurchase/{gpurchaseNo}", method = RequestMethod.GET) 
	public String select(@PathVariable("gpurchaseNo") int gpurchaseNo, Model model, HttpServletRequest request) throws Exception {
//		logger.info("gpurchaseselect 들어옴");
		
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("no");
		
		Log log = new Log();
		log.setMemberNo(memberNo);
		log.setContent(String.valueOf(gpurchaseNo));
		log.setType(LogType.VIEW.name());
		logService.insert(log);
		
		Map<String, Object> map = gpService.select(gpurchaseNo, memberNo);
		
		AskResale askResale = new AskResale(gpurchaseNo, memberNo);
		int askCnt = askService.selectCnt(askResale);
		
		model.addAttribute("gpurchase", (GpurchaseInfo) map.get("gpurchase"));
		model.addAttribute("keyword", map.get("keyword"));
		model.addAttribute("size", map.get("size"));
		model.addAttribute("askCnt", askCnt);
		model.addAttribute("orderCheck", map.get("orderCheck"));
		
		return "product/product";

	}
	
	@RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET)
	public String search(@PathVariable("keyword") String keyword, HttpServletRequest request) throws Exception {
		int memberNo = (int)request.getSession().getAttribute("no");
		
		Log log = new Log();
		log.setMemberNo(memberNo);
		log.setType(LogType.SEARCH.name());
		log.setContent(keyword);
		logService.insert(log);
		
		request.setAttribute("keyword", keyword);
		
		return "product/search";
	}
	
	@RequestMapping(value = "/search/{keywordName}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectSearch(@PathVariable("keywordName") String keywordName, KeywordParameter keyword) throws Exception {
		keyword.setKeywordName(keywordName);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<GpurchaseInfo> purchases = keywordService.listByKeyword(keyword);

		if(purchases.isEmpty()) {
			resultMap.put("ResponseCode", -1);
			resultMap.put("ResponseMessage", "결과가 없습니다.");
		}
		
		else {
			resultMap.put("ResponseCode", 1);
			resultMap.put("ResponseMessage", purchases.size() + "개의 결과가 있습니다.");
		
			resultMap.put("list", purchases);
		}
		
		return resultMap;
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
//		logger.info("gpurchaseController askCheck 접근");

		ResponseEntity<Integer> entity = null;

		AskResale askResale = new AskResale(gpurchaseNo, memberNo);

		Log log = new Log();
		log.setMemberNo(memberNo);
		log.setContent(String.valueOf(gpurchaseNo));
		log.setType(LogType.AFTERLIKE.name());
		logService.insert(log);
		
		
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
	@Scheduled(cron = "00 00 00 * * *")
	public void updateStatus() throws Exception {
//		logger.info("updateStatus 들어옴");
		List<Gpurchase> list = gpService.gpListAll();

		for (Gpurchase gpurchase : list) {
			CompareTime time = new CompareTime(gpurchase.getEndDate());
			
			String compare = time.timeCount();
			int likeCnt = gpurchase.getLikeCnt();
			int min = gpurchase.getMin();
			int status = gpurchase.getStatus();
			int gpurchaseNo = gpurchase.getGpurchaseNo();
			
			// 공구의 endDate가 현재 날짜보다 과거라면 조건 만족
			if (compare != null) {
				if (likeCnt >= min) {
					gpService.statusUpdate(gpurchase);
					
					if (status == 0) {
						// 안드로이드 푸쉬 알림
						List<Gwish> memberNo = wishService.selectMemNo(gpurchaseNo);
						
						for(Gwish gwish : memberNo) {
							int memNo = gwish.getMemberNo();
							PushToken push = new PushToken();
							
							push.setTitle("Semicolon_공구등록 알림");
							push.setMessage("NEW 공구 뙇!! 어맛!! 이건 사야됭!!");
							push.setPushToken(memService.selectToken(memNo));
							pushService.pushToken(push);
						}
					} 
					
				} else if (likeCnt < min && status == 0) {
					gpService.updateResearchCancle(gpurchaseNo);
				}
			}

		}
	}
	
	
}
