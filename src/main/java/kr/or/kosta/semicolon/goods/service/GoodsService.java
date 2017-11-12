package kr.or.kosta.semicolon.goods.service;

import java.util.List;

import kr.or.kosta.semicolon.goods.domain.Goods;

public interface GoodsService {
	
	public List<Goods> listAll();
	
	public int insert(Goods goods);
}
