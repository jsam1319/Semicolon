package kr.or.kosta.semicolon.orders.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
 * 2017. 11. 20.      kosta         최초 생성
 *
 *
 */
@Controller
@RequestMapping("/order")
public class OrdersController {
	
	Logger logger = Logger.getLogger(OrdersController.class);
	
	@Inject
	private OrdersService orderService;
	
	@RequestMapping("/order")
	public void orderPage() throws Exception {}

}
