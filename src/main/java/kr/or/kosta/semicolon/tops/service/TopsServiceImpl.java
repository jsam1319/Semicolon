package kr.or.kosta.semicolon.tops.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.tops.dao.TopsDao;
import kr.or.kosta.semicolon.tops.domain.Tops;

@Service
public class TopsServiceImpl implements TopsService {

	@Inject
	TopsDao dao;
	
	@Override
	public Tops getBySize(String size) {
		return dao.getBySize(size);
	}

}
