package kr.or.kosta.semicolon.bottom.controller;


import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosta.semicolon.bottom.domain.Bottom;
import kr.or.kosta.semicolon.bottom.service.BottomService;

/**
 * @packgename  	 kr.or.kosta.semicolon.bottom.controller
 * @filename         BottomController.java
 * @author           김미소
 * @since            2017. 11. 20.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 20.       김미소        최초 생성
 *
 *
 */
@RestController
public class BottomController {
	
	@Inject
	BottomService bottomService;
	
	Logger logger = Logger.getLogger(BottomController.class);
	
	@RequestMapping(value="/bottom/test", method=RequestMethod.POST)
	@ResponseBody
	public String getOption(Bottom bottom) {
		
		JSONObject obj = new JSONObject();
		
		obj.put("types", bottom.getTypes());
		obj.put("sizes", bottom.getSizes());
		obj.put("waist", bottom.getWaist());
		obj.put("rise", bottom.getRise());
		obj.put("hip", bottom.getHip());
		obj.put("thigh", bottom.getThigh());
		obj.put("fullLength", bottom.getFullLength());
		
		String str = obj.toJSONString();
		
		return str;
	}

}
