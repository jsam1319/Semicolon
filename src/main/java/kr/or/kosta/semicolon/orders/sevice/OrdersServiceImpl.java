package kr.or.kosta.semicolon.orders.sevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.kosta.semicolon.gpurchase.dao.gpurchaseDao;
import kr.or.kosta.semicolon.orderlist.domain.OrderList;
import kr.or.kosta.semicolon.orderlist.service.OrderListService;
import kr.or.kosta.semicolon.orders.dao.OrdersDao;
import kr.or.kosta.semicolon.orders.domain.OrderDetail;
import kr.or.kosta.semicolon.orders.domain.OrderListVal;
import kr.or.kosta.semicolon.orders.domain.Orders;
import kr.or.kosta.semicolon.payment.dao.paymentDao;
import kr.or.kosta.semicolon.payment.domain.Payment;

/**
 * @packgename  	 kr.or.kosta.semicolon.orders.sevice
 * @filename         OrdersServiceImpl.java
 * @author           박주연
 * @since            2017. 11. 24.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 16.       박주연        최초 생성
 * 2017. 11. 23.	   박연주		 selectOrderInfo 추가
 * 2017. 11. 24.	   박주연		 selectByMemNo
 * 2017. 11. 27.	   박주연		 selectDetail추가
 *
 */
@Service
public class OrdersServiceImpl implements OrdersService {
	@Inject
	OrdersDao dao;
	
	@Inject
	OrderListService orderListdao;
	
	@Inject
	paymentDao paymetdao;
	
	@Inject
	gpurchaseDao gpurchasedao;
	
	
	Logger logger = Logger.getLogger(OrdersServiceImpl.class);
	
	
	@Override
	@Transactional
	public void insertOrder(Orders order, String orderList, Payment payment) throws Exception {
		dao.insert(order);
		logger.info(orderList);
		/*
		for (OrderList list : orderList) {
			logger.info(list);
		}*/
		/** 공구 상품에 대한 정보 받아오기 */
//		ObjectMapper mapper = new ObjectMapper();
//		ArrayList<String> list;
		
//		readValue(arg, type) : arg를 type으로 변환
//		list = mapper.readValue(orderList, ArrayList.class);
		
//		ArrayList 선언
//		ArrayList<OrderList> orders = new ArrayList<OrderList>();
		
		
//		for(int i=0; i<list.size(); i++) {
//			writeValueAsString(value) : value를 String 타입으로 변환 
//			orders.add(mapper.readValue(new ObjectMapper().writeValueAsString(list.get(i)), OrderList.class));
//		}
		
		/*
		for (OrderList orderlist : orders) {
			logger.info(order.getOrdersNo());
			logger.info(orderlist);
			
			orderlist.setOrdersNo(order.getOrdersNo());
			orderListdao.insert(orderlist);
			
			logger.info("gpurchaseNo : "+gpurchaseNo);
		}
		
		paymetdao.insert(payment);
		
		gpurchasedao.updatePnum(gpurchaseNo);
		*/
		
		// 주문 insert -> +주문pk : 주문List insert -> 결제 insert -> gpurchase pNum+
	}
	
	
	
	@Override
	public int insert(Orders orders) {
		return dao.insert(orders);
	}
 
	@Override
	public Orders select(int ordersNo) {
		return dao.select(ordersNo);
	}
	
	@Override
	public List<Orders> listAll(){
		return dao.listAll();
	}

	@Override
	public void delete(int ordersNo) {
		dao.delete(ordersNo);
	}
	
	@Override
	public void update(Orders orders) {
		dao.update(orders);
	}
	
	@Override
	public Map<String, Object> selectOrderInfo(int gpurchaseNo) {
		return dao.selectOrderInfo(gpurchaseNo);
	}
	
	@Override
	public List<OrderListVal> selectByOrdersNo(Map<String, Object> map){
		return dao.selectByOrdersNo(map);
	}
	
	@Override
	public List<Orders> selectByMemNo(Map<String, Object> map){
		return dao.selectByMemNo(map);
	}
	
	@Override
	public OrderDetail selectDetail(int no) {
		return dao.selectDetail(no);
	}
	
	
}
