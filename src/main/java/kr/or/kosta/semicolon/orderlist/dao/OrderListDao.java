package kr.or.kosta.semicolon.orderlist.dao;

import java.util.List;

import kr.or.kosta.semicolon.member.domain.Member;
import kr.or.kosta.semicolon.orderlist.domain.OrderList;

/**
 * @packgename  	 kr.or.kosta.semicolon.orderlist.dao
 * @filename         OrderListDao.java
 * @author           박주연
 * @since            2017. 11. 23.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 23.       박주연        최초 생성
 *
 *
 */
public interface OrderListDao {
	
	public List<OrderList> listAll();

	public int insert(OrderList orderList);

	public OrderList select(int no);

	public void update(OrderList orderList);

	public void delete(int no);
}
