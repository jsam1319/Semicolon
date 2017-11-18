package kr.or.kosta.semicolon.review.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.common.util.UploadService;
import kr.or.kosta.semicolon.gpurchase.service.gpurchaseService;
import kr.or.kosta.semicolon.review.domain.Review;
import kr.or.kosta.semicolon.review.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	Logger logger = Logger.getLogger(ReviewController.class);
	
	@Inject
	ReviewService reviewService;
	
	@Inject
	gpurchaseService gpurService;
	
	@Inject
	UploadService uploadService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public void reviewInsert(@PathVariable int no, HttpServletRequest request, Review review) throws Exception {
		
		logger.info("Insert컨트롤 들어옴!");
		logger.info(no);
		logger.info(review);
		
		/*
		
		review.setGoodsNo(goodsNo);
		
		logger.info(review);
		
		reviewService.insert(review);*/
			
		
		
	}
	
	
	@ResponseBody
	   @RequestMapping(value="/upload", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	   public String insert(MultipartFile file, Model model) throws Exception {
	      logger.info("파일 이름:" + file.getOriginalFilename());
	      
	      String savedName = uploadService.uploadFile(file.getOriginalFilename(), file.getBytes());
	      String thumbnail = uploadService.makeThumbnail(savedName);
	      
	      model.addAttribute("savedName", savedName);
	      model.addAttribute("thumbnail", thumbnail);
	      
	      logger.info("저장 이름:" + savedName);
	      
	      return "/resources/images/"+thumbnail;
	      
	   }
	
	
	@RequestMapping(value = "/{gpurchaseNo}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> reivewList(@PathVariable("page") int page, Params params) throws Exception{
		ResponseEntity<Map<String, Object>> entity = null;
		
		logger.info("List컨트롤 들어옴!");
		
		try {
			params.setPage(page);
			 
			Map<String, Object> map = reviewService.listAll(params);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	

}
