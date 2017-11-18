package kr.or.kosta.semicolon.orders.sevice;

import java.util.List;

import kr.or.kosta.semicolon.orders.domain.Orders;

public interface OrdersService {
	public int insert(Orders orders);
	public Orders select(int no);
	public List<Orders> listAll();
	public void delete(int no);
	public void update(Orders orders);
}
