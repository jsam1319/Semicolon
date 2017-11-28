package kr.or.kosta.semicolon.gwish.dao.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosta.semicolon.gwish.service.gwishService;

@RestController
public class GwishRestController {
	
	Logger logger = Logger.getLogger(GwishController.class);
	
	@Inject
	gwishService gwService;
	
	@RequestMapping(value="/gwish/{gpurchaseNo}", method=RequestMethod.DELETE)
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
}
