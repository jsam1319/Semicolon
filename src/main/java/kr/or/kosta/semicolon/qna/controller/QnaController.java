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

import kr.or.kosta.semicolon.common.PageBuilder;
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
	
	@RequestMapping(value = "/list")
	public String qnaListAll() { 
		
		return "qna/list";
	}
	
	@RequestMapping(value = "/list/all", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> list(){
		
		ResponseEntity<Map<String, Object>> entity = null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Qna> list = qnaService.allList();
		
		map.put("list", list);
		
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> qnaList(@PathVariable("page") int page, Params params, Model model) throws Exception{
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			params.setPage(page);
			
			int count = qnaService.listCount();
			PageBuilder pb = new PageBuilder(params, count);
			pb.build();
			
			Map<String, Object> map = qnaService.listAll(params);
			map.put("pageBuilder", pb);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
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
	
	@RequestMapping(value="/rewrite", method = RequestMethod.GET)
	public void qnaReply() {}
	
	@RequestMapping(value="/rewrite", method = RequestMethod.POST)
	public String qnaReplyUpdate(Qna qna, RedirectAttributes rttr) throws Exception {
		
		qnaService.update(qna);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/qna/list";
	}
	
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public void qnaRead(@RequestParam("qnaNo") int qnaNo, Model model) throws Exception {
		
		model.addAttribute(qnaService.select(qnaNo));
	}
	
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
