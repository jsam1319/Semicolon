package kr.or.kosta.semicolon.admin.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.goods.service.GoodsService;
import kr.or.kosta.semicolon.gpurchase.domain.GpurchaseInfo;
import kr.or.kosta.semicolon.push.domain.PushToken;
import kr.or.kosta.semicolon.push.service.PushTokenService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	Logger logger = Logger.getLogger(AdminController.class);
	
	@Inject
	PushTokenService pushService;
	
	@Inject
	GoodsService goodsService;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String adminPage() {
		return "/admin/adminpage";
	}
	
	@RequestMapping(value = "/push", method = RequestMethod.GET)
	public String pushPage() {
		
		return "/admin/push";
	}
	
	@RequestMapping(value = "/push", method = RequestMethod.POST)
	public String pushAllPage(PushToken pushToken) throws Exception {
		logger.info(pushToken);
		
		pushService.pushToken(pushToken);
		
		return "redirect:/admin/";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listAll() {
		
		return "/admin/productList";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/goods", method=RequestMethod.POST)
	public List<GpurchaseInfo> goodsList() {
		List<GpurchaseInfo> goods = goodsService.adminGoodsList();
		
		return goods;
	}
	
}
