package kr.or.kosta.semicolon.keyword.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.keyword.domain.Keyword;
import kr.or.kosta.semicolon.keyword.service.KeywordService;

/**
 * @packgename   kr.or.kosta.semicolon.keyword.controller
 * @filename         KeywordController.java
 * @author          jaehyun
 * @since            2017. 11. 18.
 * @see						Keyword의 요청을 처리하기 위한 Controller
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 18.      jaehyun         최초 생성
 *
 *
 */
@Controller
public class KeywordController {

	@Inject
	KeywordService keywordService;
	
	
	@RequestMapping(value = "/keyword", method = RequestMethod.POST)
	public int insert(Keyword keyword) {
		return keywordService.insert(keyword);
	}
	
	@RequestMapping(value = "/keyword", method = RequestMethod.GET)
	public List<Goods> listByKeyword(String keyword) {
			return keywordService.listByKeyword(keyword);
	}
	
	@RequestMapping(value = "/keyword/auto", method = RequestMethod.GET)
	@ResponseBody
	public List<String> autoComplete(String keyword) {
		System.out.println(keyword);
		return keywordService.autoComplete(keyword);
	}
}
