package kr.or.kosta.semicolon.orders.sevice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.orders.dao.OrdersDao;
import kr.or.kosta.semicolon.orders.domain.Orders;

@Service
public class OrdersServiceImpl implements OrdersService {
	@Inject
	OrdersDao dao;
	
	@Override
	public int insert(Orders orders) {
		return dao.insert(orders);
	}
	
	@Override
	public Orders select(int no) {
		return dao.select(no);
	}
	
	@Override
	public List<Orders> listAll(){
		return dao.listAll();
	}
	
	@Override
	public void delete(int no) {
		dao.delete(no);
	}
	
	@Override
	public void update(Orders orders) {
		dao.update(orders);
	}
}
