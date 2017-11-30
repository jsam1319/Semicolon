package kr.or.kosta.semicolon.keyword.service;

import java.util.List;

import kr.or.kosta.semicolon.common.KeywordParameter;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;
import kr.or.kosta.semicolon.gpurchase.domain.GpurchaseInfo;
import kr.or.kosta.semicolon.keyword.domain.Keyword;

public interface KeywordService {

	public int insert(Keyword keyword);
	
	public List<GpurchaseInfo> listByKeyword(KeywordParameter keyword);
	
	public List<String> autoComplete(String keyword);
	
	public List<String> listByCount();
}
