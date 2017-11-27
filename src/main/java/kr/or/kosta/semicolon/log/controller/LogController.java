package kr.or.kosta.semicolon.log.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
