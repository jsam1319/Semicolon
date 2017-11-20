package kr.or.kosta.semicolon.bottom.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosta.semicolon.bottom.domain.Bottom;
import kr.or.kosta.semicolon.tops.domain.Tops;

@RestController
public class BottomController {
	
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
