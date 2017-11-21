package kr.or.kosta.semicolon.membersize.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.kosta.semicolon.bottom.domain.Bottom;
import kr.or.kosta.semicolon.bottom.service.BottomService;
import kr.or.kosta.semicolon.membersize.domain.MemberSize;
import kr.or.kosta.semicolon.membersize.service.MemberSizeService;
import kr.or.kosta.semicolon.tops.domain.Tops;
import kr.or.kosta.semicolon.tops.service.TopsService;

/**
 * @packgename  	 kr.or.kosta.semicolon.membersize.controller
 * @filename         MemberSizeController.java
 * @author           박주연
 * @since            2017. 11. 18.
 * @see					
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 18.    박주연      최초 생성
 * 2017. 11. 20		박주연		membersize insert 생성
 *
 */

@Controller
@RequestMapping("/size")
public class MemberSizeController {
	@Inject
	MemberSizeService sizeService;
	
	@Inject
	TopsService topsService;
	
	
	@Inject
	BottomService bottomService;
	
	Logger logger = Logger.getLogger(MemberSizeController.class);
	
	/**
	 * <pre>
	 * 1. 개       요   : 바지 사이즈 상세 정보 반환
	 * 2. 처 리 내 용   : 바지 사이즈의 상세 정보를 얻어옴
	 * </pre>
	 * @Method Name : getBottom
	 * @param size : 바지 사이즈
	 */
	@RequestMapping(value="/{types}/{size}", method=RequestMethod.GET)
	@ResponseBody
	public Bottom getBottomDetail(@PathVariable("size") String size, @PathVariable("types") String types) {
		Bottom bottom = bottomService.getByTypesSize(types, size);
		logger.debug(bottom);
		
		return bottom;
	}
	
	/**
	 * <pre>
	 * 1. 개       요   : 상의 사이즈 상세 정보 반환
	 * 2. 처 리 내 용   : 상의 사이즈의 상세 정보를 얻어옴
	 * </pre>
	 * @Method Name : getTopsDetail
	 * @param size : 상의 사이즈
	 */
	@RequestMapping(value="/tops/{size}", method=RequestMethod.GET)
	@ResponseBody
	public Tops getTopsDetail(@PathVariable String size, Model model) {
		Tops tops = topsService.getBySize(size);
		logger.debug(tops);
		
		
		return tops;
	}
	
	/**
	 * <pre>
	 * 1. 개       요   : MemberSize 처리
	 * 2. 처 리 내 용   : MemberSize insert 처리
	 * </pre>
	 * @Method Name : insert
	 * @param size : mebersize
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	@ResponseBody
	public String insert(MemberSize size){
		
		MemberSize isSize = sizeService.select(size.getMemberNo());
		int result = 0;
		if(isSize == null) { result  = sizeService.insert(size); }
		else { result = sizeService.update(isSize); }

		ResponseEntity<String> entity = null;
		
		if(result == 1) { //insert 성공
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}
		else {
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return "redirect:/";
	}
	
	
}
