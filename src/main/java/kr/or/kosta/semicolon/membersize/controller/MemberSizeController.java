package kr.or.kosta.semicolon.membersize.controller;

import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kr.or.kosta.semicolon.bottom.domain.Bottom;
import kr.or.kosta.semicolon.bottom.service.BottomService;
import kr.or.kosta.semicolon.common.Clothing;
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
 * 2017. 11. 20.	박주연		membersize insert 생성
 * 2017. 11. 21.	박주연		getSizeGap, getBestSize 추가
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
	 * 1. 개       요   : MemberSize 처리
	 * 2. 처 리 내 용   : MemberSize insert 처리
	 * </pre>
	 * @Method Name : insert
	 * @param size : mebersize
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView insert(MemberSize size){
		
		MemberSize isSize = sizeService.select(size.getMemberNo());
		logger.debug("size:"+size);
		int result = 0;
		if(isSize == null) { result  = sizeService.insert(size); }
		else { result = sizeService.update(size); }

		ResponseEntity<String> entity = null;
		
		if(result == 1) { //insert 성공
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}
		else {
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		RedirectView rv =new RedirectView("/");
		rv.setExposeModelAttributes(false);
		return new ModelAndView(rv);
		
	}
	
	/**
	 * <pre>
	 * 1. 개       요   : 바지 사이즈 상세 정보 반환
	 * 2. 처 리 내 용   : 바지 사이즈의 상세 정보를 얻어옴
	 * </pre>
	 * @Method Name : getBottom
	 * @param size : types(skirt, pants, shortpants) 사이즈
	 */
	@RequestMapping(value="/{types}/{size}", method=RequestMethod.GET)
	@ResponseBody
	public Bottom getBottomDetail(@PathVariable("size") String size, @PathVariable("types") String types) {
		Bottom bottom = bottomService.getByTypesSize(types, size);
		
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
	 * 1. 개       요 : 최적의 사이즈를 찾아 차를 반환
	 * 2. 처 리 내 용 : membersize와 상품size를 비교하여 최적의 size를 찾은 뒤 두 값의 차를 저장하여 반환한다.
	 * </pre>
	 * @Method Name : getBestSize
	 * @param no : memberNo
	 * @param productNo : productNo
	 * @return ResponseEntity
	 */
	@RequestMapping(value="/get/{no}/{goodsNo}", method=RequestMethod.GET)
	public ResponseEntity<Clothing> getBestSize(@PathVariable("no") int no, @PathVariable("goodsNo") int goodsNo){
		ResponseEntity<Clothing> entity = null;
		MemberSize size = sizeService.select(no);
		if(size != null) {
			List<? extends Clothing> bottom = bottomService.selectByGoodsNum(goodsNo);
			List<? extends Clothing> tops = topsService.selectByGoodsNum(goodsNo);
			Clothing object = null;
			
			if(bottom.size() > 0) {
				object = sizeService.compare(bottom, size);
			}else if(tops.size() > 0) {
				object = sizeService.compare(tops, size);
			}else { }
			
			if(object != null) {
				entity = new ResponseEntity<Clothing>(object, HttpStatus.OK);
			}
			else {
				entity = new ResponseEntity<Clothing>(HttpStatus.BAD_REQUEST);
			}
		}
		return entity;
		
	}
	
	/**
	 * <pre>
	 * 1. 개       요 : 상품과 회원체형사이즈의 차를 반환
	 * 2. 처 리 내 용 : goodsNo과 size와 일치하는 bottom 또는 tops를 membersize와 비교한 뒤, 두 사이즈의 차를 반환 한다.
	 * </pre>
	 * @Method Name : getSizeGap
	 * @param no : memberNo
	 * @param sizes : Bottom 또는 Tops의 sizes
	 * @param goodsNo : Bottom 또는 Tops의  goodsNo
	 * @return ResponseEntity<Clothing>
	 */
	@RequestMapping(value="/get/{no}/{sizes}/{goodsNo}", method=RequestMethod.GET)
	public ResponseEntity<Clothing> getSizeGap(@PathVariable("no") int no, 
			@PathVariable("sizes") String sizes, @PathVariable("goodsNo") int goodsNo){
		
		ResponseEntity<Clothing> entity = null;
		Clothing rsCloth = null;
		MemberSize size = sizeService.select(no);
		
		Bottom bottom = new Bottom();
		bottom.setGoodsNo(goodsNo);
		bottom.setSizes(sizes);
		//사이즈와 상품번호와 동일한 bottom 반환
		bottom = bottomService.getBySizeGoodsNo(bottom);
		
		Tops tops = new Tops();
		tops.setGoodsNo(goodsNo);
		tops.setSizes(sizes);
		//사이즈와 상품번호와 동일한 tops 반환
		tops = topsService.getBySizeGoodsNo(tops);
		
		//membersize와 상품의 size를 비교해 차를 반환
		if(bottom != null) {
			rsCloth = sizeService.getGap(bottom, size);
		} 
		else if(tops != null) {
			rsCloth = sizeService.getGap(tops, size);
		}
		
		if(rsCloth != null) {
			entity = new ResponseEntity<Clothing>(rsCloth, HttpStatus.OK);
		}
		else {
			entity = new ResponseEntity<Clothing>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
		
	}
	
	/**
	 * <pre>
	 * 1. 개       요 : 회원의 체형정보 불러옴
	 * 2. 처 리 내 용 : 회원의 체형정보를 반환
	 * </pre>
	 * @Method Name : getMemberSize
	 * @param memberNo : memberNo
	 * @return ResponseEntity<MemberSize>
	 */
	@RequestMapping(value="/{memberNo}", method=RequestMethod.GET)
	public ResponseEntity<MemberSize> getMemberSize(@PathVariable("memberNo") int memberNo){
		MemberSize mSize = sizeService.select(memberNo);
		ResponseEntity<MemberSize> entity = null;
		if(mSize != null) {
			entity = new ResponseEntity<MemberSize>(mSize, HttpStatus.OK);
		}
		else {
			entity = new ResponseEntity<MemberSize>(HttpStatus.NO_CONTENT); //클라이언트 요구를 처리했으나 전송할 데이터가 없음
		}
		
		return entity;
	}
	
}
