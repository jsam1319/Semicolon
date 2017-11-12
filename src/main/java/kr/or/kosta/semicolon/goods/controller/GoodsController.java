package kr.or.kosta.semicolon.goods.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.goods.service.GoodsService;

/**
 * @packgename   kr.or.kosta.semicolon.goods.controller
 * @filename         GoodsController.java
 * @author          전세종
 * @since            2017. 11. 10.
 * @see					상품관리를 위한 Controller
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 10.      kosta         최초 생성
 *
 *
 */
@Controller
public class GoodsController {
	
	@Inject
	GoodsService goodsService;
	
	
	/**
	 * <pre>
	 * 1. 개      요 : goods view method
	 * 2. 처리내용 : 상품 정보를 가지고 goods view로 이동하는 메소드
	 * </pre>
	 * @Method Name : goods
	 * @param model : 상품 정보를 저장하기 위한 model
	 */
/*	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public void goods(Params params, Model model) {
		
		List<Goods> list = goodsService.listAll(params);
		
		model.addAttribute("list", list);
	}
	*/
	
	@RequestMapping(value = "/goods", method = RequestMethod.POST)
	public String success(Goods goods, RedirectAttributes rttr) {
		
		goodsService.insert(goods);
		rttr.addFlashAttribute("result", "SUCCESS");
		
		return null;
	}
	
	
}
