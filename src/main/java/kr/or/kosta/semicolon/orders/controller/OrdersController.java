package kr.or.kosta.semicolon.orders.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.kosta.semicolon.orderlist.service.OrderListService;
import kr.or.kosta.semicolon.orders.domain.OrderDetail;
import kr.or.kosta.semicolon.orders.sevice.OrdersService;

/**
 * @packgename   kr.or.kosta.semicolon.orders.controller
 * @filename         OrdersController.java
 * @author          박연주
 * @since            2017. 11. 20.
 * @see			주문 관리를 위한 Controller
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 20.      박연주         최초 생성
 * 2017. 11. 24.	  박주연	     getOrders추가
 *
 *
 */
@Controller
@RequestMapping("/order")
public class OrdersController {
	
	Logger logger = Logger.getLogger(OrdersController.class);
	
	@Inject
	private OrdersService ordersService;
	
	@Inject
	private OrderListService listService;
	
	@RequestMapping("/order")
	public void orderPage() throws Exception {}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String myPurchseList() {
		return "/order/list";
	}
	
	@RequestMapping(value="/{ordersNo}",method=RequestMethod.GET)
	public String orderListDetail(@PathVariable("ordersNo") int ordersNo, Model model) {
		
		OrderDetail detail = ordersService.selectDetail(ordersNo);
		logger.debug("detail:"+detail);
		
		model.addAttribute("detail",detail);
		
		return "/order/listdetail";
	}

}
