package kr.or.kosta.semicolon.gwish.dao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.kosta.semicolon.gwish.domain.GwishDetail;
import kr.or.kosta.semicolon.gwish.service.gwishService;

@Controller
@RequestMapping("/gwish")
public class GwishController {
	
	Logger logger = Logger.getLogger(GwishController.class);
	
	@Inject
	gwishService gService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getGwishAll() throws Exception {
		return "/member/gwish";
	}
	
	@RequestMapping(value="/{page}", method=RequestMethod.POST)
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
			entity = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
}
