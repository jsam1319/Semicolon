package kr.or.kosta.semicolon.payment.dao;

import kr.or.kosta.semicolon.payment.domain.Payment;

/**
 * @packgename   kr.or.kosta.semicolon.payment.dao
 * @filename         paymentDao.java
 * @author          박연주
 * @since            2017. 11. 27.
 * @see			Payment 테이블의 Dao
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 27.      박연주         최초 생성
 *
 *
 */
public interface paymentDao {
	
	public void insert(Payment payment) throws Exception;

}
