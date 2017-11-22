package kr.or.kosta.semicolon.askresale.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.askresale.dao.AskresaleDao;
import kr.or.kosta.semicolon.askresale.domain.AskResale;

@Service
public class askResaleServiceImpl implements askResaleService {
	
	@Inject
	private AskresaleDao dao;

	@Override
	public int selectCnt(AskResale askResale) throws Exception {
		return dao.selectCnt(askResale);
	}

	@Override
	public void insert(AskResale askResale) throws Exception {
		dao.insert(askResale);
	}

	@Override
	public int select(AskResale askResale) throws Exception {
		return dao.select(askResale);
	}

	@Override
	public void delete(int askResaleNo) throws Exception {
		dao.delete(askResaleNo);
	}

}
