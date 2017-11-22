package kr.or.kosta.semicolon.goods.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.goods.dao.GoodsDao;
import kr.or.kosta.semicolon.goods.domain.Goods;

/**
 * @packgename   kr.or.kosta.semicolon.goods.service
 * @filename         GoodsServiceImpl.java
 * @author          전세종
 * @since            2017. 11. 10.
 * @see					상품관리의 비지니스 로직을 처리하는 클래스
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 10.      세종         최초 생성
 * 2017. 11. 11.	  연주			listAll(Params params) 추가
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Inject
	GoodsDao goodsDao;
	
	@Override
	public List<Goods> allList() {
		return goodsDao.allList();
	}

	@Override
	public int insert(Goods goods) {
		return goodsDao.insert(goods);
	}
	
	@Override
	public Goods select(int goodsNo) throws Exception {
		return goodsDao.select(goodsNo);
	}
	
	@Override
	public int selectNo(String name) throws Exception {
		return goodsDao.selectNo(name);
	}

	@Override
	public List<Goods> listAll(Params params) throws Exception {
		return goodsDao.listAll(params);
	}
	
	@Override
	public int listCount() throws Exception {
		return goodsDao.listCount();
	}
}
