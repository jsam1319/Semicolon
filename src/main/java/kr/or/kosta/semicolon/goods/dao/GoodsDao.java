package kr.or.kosta.semicolon.goods.dao;

import java.util.List;

import kr.or.kosta.semicolon.common.UseParameter;
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
 * 2017. 11. 10.      세종         최초 생성
 * 2017. 11. 11.	  연주			listAll(UseParameter params) 추가
 * 2017. 11. 13. 	김미소			insert생성
 * 2017. 11. 29		김미소			adminGoodsList생성
 *
 */
public interface GoodsDao {
	
	public List<Goods> allList();
	
	public int insert(Goods goods);
	
	public Goods select(int goodsNo) throws Exception;
	
	public int selectNo(String name) throws Exception;
	
	public List<Goods> listAll(UseParameter params) throws Exception;
	
	public int listCount() throws Exception;
	
	public List<Goods> adminGoodsList();
	
}
