package kr.or.kosta.semicolon.log.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.kosta.semicolon.gpurchase.domain.GpurchaseInfo;
import kr.or.kosta.semicolon.log.domain.Log;
import kr.or.kosta.semicolon.log.service.LogService;

@Controller
public class LogController {
	
	@Inject
	LogService logService;

	@RequestMapping(value="/log", method = RequestMethod.POST)
	@ResponseBody
	public void insert(Log log) {
		logService.insert(log);
		
	}
	
	@RequestMapping(value="/log/popular", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> popularPurchase() {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<GpurchaseInfo> list = logService.popularPurchase();
		
		if(list.size() <= 0) {
			result.put("ResponseCode", 404);
			result.put("ResponseMessage", "조회된 정보가 없습니다.");
		}
		
		else {
			result.put("ResponseCode", 200);
			result.put("ResponseMessage", list.size() + "건의 정보가 있습니다");
			result.put("list", list);
		}
		
		return result;
	}
	

	@RequestMapping(value="/log/recommand/{memberNo}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> mostCategory(@PathVariable int memberNo) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<GpurchaseInfo> list = logService.mostCategory(memberNo);
		
		if(list.size() <= 0) {
			result.put("ResponseCode", 404);
			result.put("ResponseMessage", "조회된 정보가 없습니다.");
		}
		
		else {
			result.put("ResponseCode", 200);
			result.put("ResponseMessage", list.size() + "건의 정보가 있습니다");
			result.put("list", list);
		}
		
		return result;
	}
}
