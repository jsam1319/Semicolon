package kr.or.kosta.semicolon.orders.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosta.semicolon.orderlist.domain.OrderList;
import kr.or.kosta.semicolon.orderlist.service.OrderListService;
import kr.or.kosta.semicolon.orders.domain.OrderListVal;
import kr.or.kosta.semicolon.orders.domain.Orders;
import kr.or.kosta.semicolon.orders.sevice.OrdersService;

/**
 * @packgename  	 kr.or.kosta.semicolon.orders.controller
 * @filename         OrdersRestController.java
 * @author           박주연
 * @since            2017. 11. 20.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 20.       박주연        최초 생성
 *
 *
 */
@RestController
public class OrdersRestController {
	Logger logger = Logger.getLogger(OrdersRestController.class);
	
	@Inject
	private OrdersService ordersService;
	
	@Inject
	private OrderListService listService;
	
	/**
	 * <pre>
	 * 1. 개       요 : 주문조회를 하기위해 필요한 데이터 반환 
	 * 2. 처 리 내 용 : 회원이 주문한 공구들의 리스트의 필요한 데이터들을 OrderListVal에 담아서 반환
	 * </pre>
	 * @Method Name : getOrders
	 * @param request 
	 * @return ResponseEntity<Object>
	 * @throws ParseException 
	 */
	@RequestMapping(value="/order/{start}/{end}", method= {RequestMethod.PUT})
	public ResponseEntity<Object> getOrders(HttpServletRequest request,@PathVariable("start") String start, @PathVariable("end")String end) throws ParseException{
		
		start = start.replace("-", "/");
		end = end.replace("-", "/");
		
		ResponseEntity<Object> entity = null;
		 
		 // 최종 결과인 OrderListVal들을 저장하는 변수 
		 List<List<OrderListVal>> rsList = new ArrayList<List<OrderListVal>>();
		 
		 // bottomNo, topsNo, ordersNo을 저장하는 map 
		 Map<String, Object> map;
		
		 //END_DATE 수정
		 end += " 23:59:59";
		 
		 // 회원번호
		 int no = (Integer)request.getSession().getAttribute("no");
		 map  =  new HashMap<String, Object>();
		 map.put("start",start);
		 map.put("end",end);
		 map.put("memberNo",no);
		 List<Orders> ordersList = ordersService.selectByMemNo(map);
			
			for (Orders orders : ordersList) {
				List<OrderListVal> smallOLV =  new ArrayList<OrderListVal>();
				
				List<OrderList> orderLists = listService.selectByOrdersNo(orders.getOrdersNo());
				for (OrderList orderList : orderLists) {
					map  =  new HashMap<String, Object>();
							
					map.put("bottomNo", orderList.getBottomNo());
					map.put("topsNo", orderList.getTopsNo());
					map.put("ordersNo", orders.getOrdersNo());
					
					List<OrderListVal> tmp = ordersService.selectByOrdersNo(map);
					
					for (OrderListVal orderListVal : tmp) {
						smallOLV.add(orderListVal);
					}
				}
				
				rsList.add(smallOLV);
			}

		 
		 entity = new ResponseEntity<Object>(rsList, HttpStatus.OK);
		 return entity;
	}
}
