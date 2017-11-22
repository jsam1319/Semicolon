package kr.or.kosta.semicolon.goods.service;

import java.util.List;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.goods.domain.Goods;

public interface GoodsService {
	
	public List<Goods> allList();
	
	public int insert(Goods goods);
	
	public Goods select(int goodsNo) throws Exception;
	
	public int selectNo(String name) throws Exception;
	
	public List<Goods> listAll(Params params) throws Exception;
	
	public int listCount() throws Exception;
}
