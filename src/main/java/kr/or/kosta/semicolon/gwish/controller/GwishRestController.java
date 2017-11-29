package kr.or.kosta.semicolon.gwish.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.or.kosta.semicolon.gwish.domain.GwishDetail;
import kr.or.kosta.semicolon.gwish.service.gwishService;

@RestController
@RequestMapping("/gwish")
public class GwishRestController {
	
	Logger logger = Logger.getLogger(GwishRestController.class);
	
	@Inject
	gwishService gService;
	
	@Inject
	gwishService gwService;
	
	@RequestMapping(value="/{gpurchaseNo}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("gpurchaseNo") int gpurchaseNo) throws Exception{
		ResponseEntity<Object> entity = null;
		
		logger.debug("delete");
		
		int result = gwService.delete(gpurchaseNo);
		logger.debug("result:"+result);
		
		if(result == 1) {
			entity = new ResponseEntity<Object>(HttpStatus.OK);
		}
		
		else {
			entity = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	@RequestMapping(value="/{page}", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Object> getGwishAll(HttpServletRequest request, @PathVariable("page") int page) throws Exception {
		ResponseEntity<Object> entity = null;
		
		int memNo = (Integer)request.getSession().getAttribute("no");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memNo);
		map.put("page", page);
		
		List<GwishDetail> list = gService.getListByMemNo(map);
		
		if(list!=null) {
			entity = new ResponseEntity<Object>(list, HttpStatus.OK);
		}else {
			entity = new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getGwishAll() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/gwish");
		return mav;
	}
}
