package kr.or.kosta.semicolon.orderlist.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.orderlist.dao.OrderListDao;
import kr.or.kosta.semicolon.orderlist.domain.OrderList;

/**
 * @packgename  	 kr.or.kosta.semicolon.orderlist.service
 * @filename         OrderListServiceImpl.java
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
@Service
public class OrderListServiceImpl implements OrderListService {

	@Inject
	OrderListDao listDao;
	
	@Override
	public List<OrderList> listAll() {
		return listDao.listAll();
	}

	@Override
	public int insert(OrderList orderList) {
		return listDao.insert(orderList);
	}
	
	@Override
	public OrderList select(int no) {
		return listDao.select(no);
	}

	@Override
	public List<OrderList> selectList(int no) {
		return listDao.selectList(no);
	}

	@Override
	public void update(OrderList orderList) {
		listDao.update(orderList);
	}

	@Override
	public void delete(int no) {
		listDao.delete(no);
	}
	
	@Override
	public List<OrderList> selectByOrdersNo(int no){
		return listDao.selectByOrdersNo(no);
	}

}
