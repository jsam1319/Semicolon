package kr.or.kosta.semicolon.keyword.dao;

import java.util.List;

import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.keyword.domain.Keyword;

public interface KeywordDao {

	public int insert(Keyword keyword);
	
	public List<Goods> listByKeyword(String keyword);
}
