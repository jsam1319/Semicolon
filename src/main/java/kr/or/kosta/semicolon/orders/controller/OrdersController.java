package kr.or.kosta.semicolon.orders.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.kosta.semicolon.member.service.MemberService;
import kr.or.kosta.semicolon.orderlist.domain.OrderList;
import kr.or.kosta.semicolon.orderlist.service.OrderListService;
import kr.or.kosta.semicolon.orders.domain.OrderDetail;
import kr.or.kosta.semicolon.orders.domain.Orders;
import kr.or.kosta.semicolon.orders.sevice.OrdersService;
import kr.or.kosta.semicolon.payment.domain.Payment;

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
	private MemberService memberService;
	
	@Inject
	private OrderListService orderListService;
	
	
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
	
	/** Order Page */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String orderPage(String orderList, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		logger.info("OrderController /order POST");
		
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("no");

		/** 공구 상품에 대한 정보 받아오기 */
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<String> list;
		
//		readValue(arg, type) : arg를 type으로 변환
		list = mapper.readValue(orderList, ArrayList.class);
		
//		ArrayList 선언
		ArrayList<OrderList> orders = new ArrayList<OrderList>();
		
		
		for(int i=0; i<list.size(); i++) {
//			writeValueAsString(value) : value를 String 타입으로 변환 
			orders.add(mapper.readValue(new ObjectMapper().writeValueAsString(list.get(i)), OrderList.class));
		}
		
		for (OrderList orderlist : orders) {
			logger.info(orderlist);
		}
		
		Map<String, Object> map = orderListService.selectOrderItem(orders.get(0).getGpurchaseNo());
		
		
		/** Cookie 생성 및 주문항목(JSON) set */
		Cookie cookie = new Cookie("orderlist", orderList);
	    cookie.setMaxAge(60*60*24*365);            // 쿠키 유지 기간(이부분이 없으면 브라우저 종료시 사라짐)
	    cookie.setPath("/");                       // 모든 경로에서 접근 가능하도록 
	    response.addCookie(cookie);
		
		
		model.addAttribute("orderList", orders);
		model.addAttribute("member", memberService.select(memberNo));
		model.addAttribute("map", map);
		
		return "/order/order";

	}
	
	
	
	
	
	@RequestMapping(value="/orders", method=RequestMethod.POST)
	public String Order(HttpServletRequest request, Payment payment, Orders orders) throws Exception {
		logger.info("Order POST 컨트롤러 접근");
		
		/** Cookie에 담겨있는 주문목록 출력 */
		Cookie[] cookies = request.getCookies();
		String cookievalue=null;
		
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("orderlist")) {
				cookievalue = cookies[i].getValue();
			}
		}
		
		
		/** 주문목록(JSON -> Object) 변환 */
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<String> list;
		
//		readValue(arg, type) : arg를 type으로 변환
		list = mapper.readValue(cookievalue, ArrayList.class);
		
//		ArrayList 선언
		ArrayList<OrderList> orderItems = new ArrayList<OrderList>();
		
		
		for(int i=0; i<list.size(); i++) {
//			writeValueAsString(value) : value를 String 타입으로 변환 
			orderItems.add(mapper.readValue(new ObjectMapper().writeValueAsString(list.get(i)), OrderList.class));
		}
		
		
		
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("no");
		
		orders.setMemberNo(memberNo);
		
		logger.info(orders);
		logger.info(payment);
		logger.info(orderItems);
		
		ordersService.insertOrder(orders, orderItems, payment);
		
		return "/";
	
	}

}
