package kr.or.kosta.semicolon.keyword.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.common.KeywordParameter;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;
import kr.or.kosta.semicolon.gpurchase.domain.GpurchaseInfo;
import kr.or.kosta.semicolon.keyword.dao.KeywordDao;
import kr.or.kosta.semicolon.keyword.domain.Keyword;
import kr.or.kosta.semicolon.keyword.util.HangulSeperator;

@Service
public class KeywordServiceImpl implements KeywordService {

	@Inject
	KeywordDao keywordDao;

	@Override
	public int insert(Keyword keyword) {
		// TODO Auto-generated method stub
		keyword.setKeywordName(HangulSeperator.seperate(keyword.getKeywordName()));
		return keywordDao.insert(keyword);
	}

	@Override
	public List<GpurchaseInfo> listByKeyword(KeywordParameter keyword) {
		// TODO Auto-generated method stub'
		keyword.setKeywordName(HangulSeperator.seperate(keyword.getKeywordName()));
		return keywordDao.listByKeyword(keyword);
	}

	@Override
	public List<String> autoComplete(String keyword) {
		// TODO Auto-generated method stub
		List<String> strings = keywordDao.autoComplete(HangulSeperator.seperate(keyword));
		
		for(int i=0; i<strings.size(); i++) {
			strings.set(i, HangulSeperator.conHangul(strings.get(i)));
		}

		return strings;
	}
	
	
}
