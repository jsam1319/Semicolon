package kr.or.kosta.semicolon.qna.controller;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.qna.domain.Qna;
import kr.or.kosta.semicolon.qna.service.QnaService;

/**
 * @packgename   kr.or.kosta.semicolon.qna.controller
 * @filename         QnaController.java
 * @author          전세종
 * @since            2017. 11. 15.
 * @see			 
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 14.      세종         최초 생성
 *
 *
 */
@Controller
@RequestMapping("/qna")
public class QnaController {
	
	Logger logger = Logger.getLogger(QnaController.class);
	
	@Inject
	QnaService qnaService;
	
	/**
	 * <pre>
	 * 1. 개      요 : Qna view 메소드
	 * 2. 처리내용 :   리스트를 띄운다.
	 * </pre>
	 * @Method Name : qnaListAll
	 */
	@RequestMapping(value = "/list")
	public String qnaListAll() { 
		
		return "qna/list";
	}
	
	/**
	 * <pre>
	 * 1. 개      요 : Qna List 더보기 메소드
	 * 2. 처리내용 :   더보기를 누르면 다음리스트가 출력된다.
	 * </pre>
	 * @Method Name  : qnaList
	 * @param page	 : 페이지를 불러옴
	 * @param params : 페이지 계산 
	 */
	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> qnaList(@PathVariable("page") int page, Params params) throws Exception{
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			params.setPage(page);
			
			Map<String, Object> map = qnaService.listAll(params);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	/**
	 * <pre>
	 * 1. 개      요 : Qna 등록을 위한 view 메소드
	 * 2. 처리내용 	 : 등록 화면을 띄운다.
	 * </pre>
	 * @Method Name : qnaRegist
	 */
	@RequestMapping(value="/regist", method = RequestMethod.GET)
	public String qnaRegist() {
		return "/qna/regist";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String success(Qna qna, RedirectAttributes rttr) throws Exception {
		
		qnaService.insert(qna);
		
		rttr.addFlashAttribute("result", "success");
		
		return "redirect:/qna/list";
	}
	
	/**
	 * <pre>
	 * 1. 개      요 : Qna 답변 view 메소드
	 * 2. 처리내용   : 답변 화면을 띄운다.	
	 * </pre>
	 * @Method Name : qnaReply
	 */
	@RequestMapping(value="/rewrite", method = RequestMethod.GET)
	public void qnaReply() {}
	
	@RequestMapping(value="/rewrite", method = RequestMethod.POST)
	public String qnaReplyUpdate(Qna qna, RedirectAttributes rttr) throws Exception {
		
		qnaService.update(qna);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/qna/list";
	}
	
	/**
	 * <pre>
	 * 1. 개      요 : Qna 글 상세정보를 위한 view 메소드
	 * 2. 처리내용   : Qna번호로 글을 찾는다
	 * </pre>
	 * @Method Name : qnaRead
	 * @param qnaNo : 글번호
	 * @param model
	 */
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public void qnaRead(@RequestParam("qnaNo") int qnaNo, Model model) throws Exception {
		
		model.addAttribute(qnaService.select(qnaNo));
	}
	
	/**
	 * <pre>
	 * 1. 개      요 : Qna 수정을 위한 메소드
	 * 2. 처리내용   : Qna의 글 번호로 찾은 후 수정 
	 * </pre>
	 * @Method Name : qnaModify
	 * @param qnaNo : 글번호
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void qnaModify(@RequestParam("qnaNo") int qnaNo, Model model) throws Exception {
		
		model.addAttribute(qnaService.select(qnaNo));
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String qnaModifyUpdate(Qna qna, RedirectAttributes rttr) throws Exception {
		
		qnaService.modify(qna);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/qna/list";
	}
	
}
