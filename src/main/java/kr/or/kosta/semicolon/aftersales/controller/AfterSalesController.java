package kr.or.kosta.semicolon.aftersales.controller;


import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.kosta.semicolon.aftersales.domain.AfterSales;
import kr.or.kosta.semicolon.aftersales.service.AfterSalesService;
import kr.or.kosta.semicolon.common.UseParameter;
import kr.or.kosta.semicolon.common.util.UploadService;
import kr.or.kosta.semicolon.goods.service.GoodsService;
import kr.or.kosta.semicolon.member.domain.Member;
import kr.or.kosta.semicolon.member.service.MemberService;

/**
 * @packgename   kr.or.kosta.semicolon.aftersales.controller
 * @filename         AfterSalesController.java
 * @author          Jeon SeJong
 * @since            2017. 11. 21.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 21.      sejong         최초 생성
 *
 *
 */
@Controller
@RequestMapping("/after")
public class AfterSalesController {
	
	Logger logger = Logger.getLogger(AfterSalesController.class);
	
	@Inject
	AfterSalesService afterSalesService;
	
	@Inject
	GoodsService GoodsService;
	
	@Inject
	MemberService memberService;
	
	@Inject
	UploadService uploadService;
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String regist() {
		
		return "/after/regist";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String success(MultipartHttpServletRequest multi) throws Exception {
		
		MultipartFile file = multi.getFile("attachFile");
		String savedName = uploadService.uploadFile(file.getOriginalFilename(), file.getBytes());
		
		AfterSales afterSales = new AfterSales();
		
		afterSales.setMemberNo( Integer.parseInt(multi.getParameter("memberNo")) );
		afterSales.setGoodsNo( Integer.parseInt(multi.getParameter("goodsNo")) );
		afterSales.setPassword( multi.getParameter("password") );
		afterSales.setContent( multi.getParameter("content") );
		afterSales.setAttachFile(savedName);
		
		afterSalesService.insert(afterSales);
		
		return "redirect:/after/result";
	}
	
	@RequestMapping(value = "/result")
	public String afterResult() { 
		
		return "after/result";
	}
	
	@RequestMapping(value = "/list")
	public String afterListAll() { 
		
		return "after/list";
	}
	
	@RequestMapping(value = "/{memberNo}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> afterlist(@PathVariable("memberNo") int memberNo, @PathVariable("page") int page, UseParameter params){
		ResponseEntity<Map<String, Object>> entity = null;
		
		params.setPage(page);
		params.setValue(Integer.toString(memberNo));
		
		Map<String, Object> map = afterSalesService.listAll(params);
		
		entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value = "/{aftersalesNo}", method = RequestMethod.GET)
	public String afterSelect(@PathVariable("aftersalesNo") int aftersalesNo, Model model) throws Exception {
		
		AfterSales afterSales = afterSalesService.select(aftersalesNo);
		
		Member member = memberService.select( afterSales.getMemberNo() );
		
		model.addAttribute("after", afterSales);
		model.addAttribute("member", member);
		
		return "/after/read";
	}
	
	@RequestMapping(value = "/update/{aftersalesNo}")
	public String afterUpdate(@PathVariable("aftersalesNo") int aftersalesNo) {
		
		afterSalesService.update(aftersalesNo);
		
		return "/after/list";
	}
	
}
