package kr.or.kosta.semicolon.tops.controller;


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

import kr.or.kosta.semicolon.tops.domain.Tops;

@RestController
public class TopsController {
	
	Logger logger = Logger.getLogger(TopsController.class);
	
	@RequestMapping(value="/tops/test", method=RequestMethod.POST)
	@ResponseBody
	public String getOption(Tops tops) {
		
		JSONObject obj = new JSONObject();
		
		obj.put("types", tops.getTypes());
		obj.put("sizes", tops.getSizes());
		obj.put("sleeveLength", tops.getSleeveLength());
		obj.put("fullLength", tops.getFullLength());
		
		String str = obj.toJSONString();
		
		return str;
	}
}
