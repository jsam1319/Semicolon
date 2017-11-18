package kr.or.kosta.semicolon.orders.dao;

import java.util.List;

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
 *
 *
 */
public interface OrdersDao {
	public int insert(Orders orders);
	public Orders select(int no);
	public List<Orders> listAll();
	public void delete(int no);
	public void update(Orders orders);
}
