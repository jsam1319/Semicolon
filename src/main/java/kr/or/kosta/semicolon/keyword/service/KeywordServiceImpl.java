package kr.or.kosta.semicolon.keyword.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.keyword.dao.KeywordDao;
import kr.or.kosta.semicolon.keyword.domain.Keyword;

@Service
public class KeywordServiceImpl implements KeywordService {

	@Inject
	KeywordDao keywordDao;

	@Override
	public int insert(Keyword keyword) {
		// TODO Auto-generated method stub
		return keywordDao.insert(keyword);
	}

	@Override
	public List<Goods> listByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return keywordDao.listByKeyword(keyword);
	}
	
}
