package kr.or.kosta.semicolon.orders.dao;

import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.askresale.domain.AskResale;
import kr.or.kosta.semicolon.orders.domain.OrderDetail;
import kr.or.kosta.semicolon.orders.domain.OrderListVal;
import kr.or.kosta.semicolon.orders.domain.Orders;

/**
 * @packgename  	 kr.or.kosta.semicolon.orders.dao
 * @filename         OrdersDao.java
 * @author           박주연
 * @since            2017. 11. 16.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 16.       박주연        최초 생성
 * 2017. 11. 23.	   박연주		 selectOrderInfo 추가
 * 2017. 11. 24.	   박주연		 selectByMemNo, selectByOrdersNo
 * 2017. 11. 27.	   박주연		 selectDetail추가
 * 2017. 11. 29.	   박연주		 SelectOrderCheck 추가
 */
public interface OrdersDao {
	
	public int insert(Orders orders);
	
	public Orders select(int ordersNo);
	
	public List<Orders> listAll();
	
	public void delete(int ordersNo);
	
	public void update(Orders orders);
	
	// 주문할 때 필요한 상품 정보들 출력
	public Map<String, Object> selectOrderInfo(int gpurchaseNo);
	
	public List<OrderListVal> selectByOrdersNo(Map<String, Object> map);
	
	public List<Orders> selectByMemNo(Map<String, Object> map);
	
	public OrderDetail selectDetail(int no);
	
	// 리뷰 작성을 위한 주문한 회원 체크
	public int SelectOrderCheck(AskResale askResale);
	
}
