package kr.or.kosta.semicolon.goods.dao;

import java.util.List;

import kr.or.kosta.semicolon.goods.domain.Goods;

/**
 * @packgename   kr.or.kosta.semicolon.goods.dao
 * @filename         GoodsDao.java
 * @author          전세종
 * @since            2017. 11. 10.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 10.      kosta         최초 생성
 *
 *
 */
public interface GoodsDao {
	
	public List<Goods> listAll();
	
	public int insert(Goods goods);
}
