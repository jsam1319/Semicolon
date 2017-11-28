package kr.or.kosta.semicolon.orders.sevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.orderlist.domain.OrderList;
import kr.or.kosta.semicolon.orders.domain.OrderDetail;
import kr.or.kosta.semicolon.orders.domain.OrderListVal;
import kr.or.kosta.semicolon.orders.domain.Orders;
import kr.or.kosta.semicolon.payment.domain.Payment;

/**
 * @packgename  	 kr.or.kosta.semicolon.orders.sevice
 * @filename         OrdersService.java
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
 * 2017. 11. 24.	   박주연		 selectByMemNo, getOrdersByMem 추가
 * 2017. 11. 27.	   박주연		 selectDetail추가
 *
 */
public interface OrdersService {
	
	public int insert(Orders orders);
	
	public Orders select(int ordersNo);
	
	public List<Orders> listAll();
	
	public void delete(int no);
	
	public void update(Orders orders);
	
	/** 주문할 때 필요한 상품 정보들 출력 */
	public Map<String, Object> selectOrderInfo(int gpurchaseNo);
	
	public List<OrderListVal> selectByOrdersNo(Map<String, Object> map);
	
	public List<Orders> selectByMemNo(Map<String, Object> map);
	
	public OrderDetail selectDetail(int no);
	
	public void insertOrder(Orders orders, ArrayList<OrderList> orderlist, Payment payment) throws Exception;
}
