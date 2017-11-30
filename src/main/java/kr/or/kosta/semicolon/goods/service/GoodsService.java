package kr.or.kosta.semicolon.goods.service;

import java.util.List;

import kr.or.kosta.semicolon.common.UseParameter;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.gpurchase.domain.GpurchaseInfo;

public interface GoodsService {
	
	public List<Goods> allList();
	
	public int insert(Goods goods);
	
	public Goods select(int goodsNo) throws Exception;
	
	public int selectNo(String name) throws Exception;
	
	public List<Goods> listAll(UseParameter params) throws Exception;
	
	public int listCount() throws Exception;
	
	public List<GpurchaseInfo> adminGoodsList();
	
}
