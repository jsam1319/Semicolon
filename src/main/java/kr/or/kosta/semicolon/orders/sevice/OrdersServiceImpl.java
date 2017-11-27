package kr.or.kosta.semicolon.orders.sevice;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.orders.dao.OrdersDao;
import kr.or.kosta.semicolon.orders.domain.OrderDetail;
import kr.or.kosta.semicolon.orders.domain.OrderListVal;
import kr.or.kosta.semicolon.orders.domain.Orders;

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
 * 2017. 11. 24.	   박주연		 selectByMemNo
 * 2017. 11. 27.	   박주연		 selectDetail추가
 *
 */
@Service
public class OrdersServiceImpl implements OrdersService {
	@Inject
	OrdersDao dao;
	
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
