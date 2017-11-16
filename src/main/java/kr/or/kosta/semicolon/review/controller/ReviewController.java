package kr.or.kosta.semicolon.review.controller;

import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.kosta.semicolon.review.service.ReviewService;

@Controller
@RequestMapping("/product")
public class ReviewController {
	
	Logger logger = Logger.getLogger(ReviewController.class);
	
	@Inject
	ReviewService reviewService;
	
	
	@RequestMapping(value = "/research/{gpurchaseNo}")
	public ResponseEntity<Map<String, Object>> reviewList(@PathVariable("gpurchaseNo") int gpurchaseNo, @RequestParam(value="memberNo", defaultValue="1") int memberNo) {
		
		
		
		
		return null;
	}
	

}
