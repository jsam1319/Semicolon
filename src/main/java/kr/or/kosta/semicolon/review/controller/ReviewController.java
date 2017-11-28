package kr.or.kosta.semicolon.review.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.kosta.semicolon.common.UseParameter;
import kr.or.kosta.semicolon.common.util.UploadService;
import kr.or.kosta.semicolon.gpurchase.service.gpurchaseService;
import kr.or.kosta.semicolon.review.domain.Review;
import kr.or.kosta.semicolon.review.service.ReviewService;

/**
 * @packgename   kr.or.kosta.semicolon.review.controller
 * @filename         ReviewController.java
 * @author          Jeon SeJong
 * @since            2017. 11. 16.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 16.      sejong         최초 생성
 * 2017. 11. 20.	  sejong		 삭제를 위한 remove() 메소드 추가 및 평점을 위한 avgGrade() 메소드 추가
 *
 */
@RestController
@RequestMapping("/review")
public class ReviewController {
	
	Logger logger = Logger.getLogger(ReviewController.class);
	
	@Inject
	ReviewService reviewService;
	
	@Inject
	gpurchaseService gpurService;
	
	@Inject
	UploadService uploadService;
	
	
	/**
	 * <pre>
	 * 1. 개요 및 처리내용 : review를 추가하는 메소드
	 * </pre>
	 * @Method Name : reviewInsert
	 * @param multi	: 데이터를 저장하기 위한 변수
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String,Object>> reviewInsert(MultipartHttpServletRequest multi) throws Exception{
		
		logger.info("Insert컨트롤 들어옴!");
		
		ResponseEntity<Map<String,Object>> entity = null;
		
		Review review = new Review();
		review.setMemberNo(Integer.parseInt(multi.getParameter("memberNo")));
		review.setGoodsNo(Integer.parseInt(multi.getParameter("goodsNo")));
		review.setContent(multi.getParameter("content"));
		review.setGrade(Integer.parseInt(multi.getParameter("grade")));
		
		MultipartFile file = multi.getFile("attachFile");
		String savedName = uploadService.uploadFile(file.getOriginalFilename(), file.getBytes());
		
		review.setAttachFile(savedName);
		reviewService.insert(review);
		List<Review> list = new ArrayList<>();
		list.add(0, review);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return entity;
	}
	
	
	/**
	 * <pre>
	 * 1. 개      요 : review 리스트 뷰
	 * 2. 처리내용 :   ajax를 이용한 리스트 출력
	 * </pre>
	 * @Method Name 		: 	reivewList
	 * @param page			:	출력할 페이지
	 * @param gpurchaseNo	:	출력할 공구번호
	 * @param params		:	페이지 세팅을 위한 변수
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{goodsNo}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> reivewList(@PathVariable("page") int page, @PathVariable("goodsNo")int goodsNo, UseParameter useparam) throws Exception{
		ResponseEntity<Map<String, Object>> entity = null;
		
		logger.info("List컨트롤 들어옴!");
		
		try {
			useparam.setPage(page);
			useparam.setValue(Integer.toString(goodsNo)); 
			Map<String, Object> map = reviewService.listAll(useparam);
			logger.info(useparam);
			logger.info(map);
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	/**
	 * <pre>
	 * 1. 개요 및 처리내용 : review 삭제를 처리
	 * </pre>
	 * @Method Name : remove
	 * @param reviewNo	:	삭제시킬 번호
	 * @return
	 */
	@RequestMapping(value = "/{reviewNo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("reviewNo") int reviewNo){
		
		ResponseEntity<String> entity = null;
		
		try {
			String originalName = reviewService.getFile(reviewNo);
			
			reviewService.delete(reviewNo);
			uploadService.deleteFile(originalName);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
	}
	
	/**
	 * <pre>
	 * 1. 개 요 및 처리내용 : 평점을 출력
	 * </pre>
	 * @Method Name   : avgGrade
	 * @param goodsNo : 상품번호에 따라서 평점 부여
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{goodsNo}", method = RequestMethod.GET)
	@ResponseBody
	public int avgGrade(@PathVariable("goodsNo") int goodsNo) throws Exception {
		
		return reviewService.listAvg(goodsNo);
	}

}
