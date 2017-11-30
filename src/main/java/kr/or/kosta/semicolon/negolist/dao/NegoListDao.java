package kr.or.kosta.semicolon.negolist.dao;

import kr.or.kosta.semicolon.negolist.domain.NegoList;
/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.negolist.dao
 * @filename         NegoListDao.java
 * @author           김미소
 * @since            2017. 11. 29.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 29.      김미소         최초 생성
 *
 *
 */
public interface NegoListDao {
	
	public void insert(NegoList negoList);
	
	public NegoList select(int goodsNo);

}
