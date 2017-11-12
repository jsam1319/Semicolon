package kr.or.kosta.semicolon.gpurchase.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.kosta.semicolon.common.PageBuilder;
import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.goods.service.GoodsService;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;
import kr.or.kosta.semicolon.gpurchase.service.gpurchaseService;

@Controller
@RequestMapping("/product")
public class GpurchaseController {
	
	Logger logger = Logger.getLogger(GpurchaseController.class);
	
	@Inject
	private gpurchaseService gpService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String researchList(Params params, Model model, @RequestParam(value="pageSize", defaultValue="12") int pageSize) throws Exception {
		logger.info("gpurchaseController research 접근");
//		, @RequestParam(value="pageSize", defaultValue="1") int pageSize

		logger.info("pageSize : "+pageSize);
		params.setPage(1);
		params.setPageSize(pageSize);
		
		int count = gpService.listCount();
		PageBuilder pb = new PageBuilder(params, count);
		pb.build();
		
		Map<String, Object> map = gpService.listAll(params);
		
		List<Gpurchase> gplist = (List<Gpurchase>) map.get("gplist");
		List<Goods> glist = (List<Goods>) map.get("glist");
		
		model.addAttribute("gplist", gplist);
		model.addAttribute("glist", glist);
		model.addAttribute("pageBuilder", pb);
		
		return "product/research";
	}
	
	
/*	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("gpurchaseController list 접근");
		model.addAttribute("list", gpService.listAll());
	}*/
	
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public void select(@RequestParam("gpurchaseNo") int gpurchaseNo, Model model) throws Exception {
		model.addAttribute(gpService.select(gpurchaseNo));
	}
	

}
