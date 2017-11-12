package kr.or.kosta.semicolon.goods.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
 * 2017. 11. 10.      kosta         최초 생성
 *
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Inject
	GoodsDao goodsDao;
	
	@Override
	public List<Goods> listAll() {
		
		return goodsDao.listAll();
	}

	@Override
	public int insert(Goods goods) {
		
		return goodsDao.insert(goods);
	}

}
