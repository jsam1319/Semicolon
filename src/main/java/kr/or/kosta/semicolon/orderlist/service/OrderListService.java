package kr.or.kosta.semicolon.orderlist.service;

import java.util.List;

import kr.or.kosta.semicolon.orderlist.domain.OrderList;

/**
 * @packgename  	 kr.or.kosta.semicolon.orderlist.service
 * @filename         OrderListService.java
 * @author           박주연
 * @since            2017. 11. 23.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 23.       박주연        최초 생성
 * 2017. 11. 24.	   박주연		 selectByOrdersNo추가
 *
 */
public interface OrderListService {
	
	public List<OrderList> listAll();

	public int insert(OrderList orderList);

	public OrderList select(int no);
	
	public List<OrderList> selectList(int no);

	public void update(OrderList orderList);

	public void delete(int no);
	
	public List<OrderList> selectByOrdersNo(int no);
}
