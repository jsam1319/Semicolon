package kr.or.kosta.semicolon.bottom.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.bottom.dao.BottomDao;
import kr.or.kosta.semicolon.bottom.domain.Bottom;

@Service
public class BottomServiceImpl implements BottomService {

	@Inject
	BottomDao dao;
	
	@Override
	public void insert(Bottom bottom) {
		dao.insert(bottom);
	}

}
