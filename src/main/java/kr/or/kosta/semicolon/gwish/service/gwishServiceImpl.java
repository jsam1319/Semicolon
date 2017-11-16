package kr.or.kosta.semicolon.gwish.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.gwish.dao.gwishDao;
import kr.or.kosta.semicolon.gwish.domain.Gwish;

/**
 * @packgename   kr.or.kosta.semicolon.gwish.service
 * @filename         gwishServiceImpl.java
 * @author          박연주
 * @since            2017. 11. 15.
 * @see			공구 조사 참여 관리 비즈니스 로직 처리 클래스
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 15.    박연주         최초 생성
 *
 *
 */
@Service
public class gwishServiceImpl implements gwishService {
	
	@Inject
	private gwishDao dao;

	
	@Override
	public void insert(Gwish gwish) throws Exception {
		dao.insert(gwish);
	}
	
	@Override
	public int selectCnt(Gwish gwish) throws Exception {
		return dao.selectCnt(gwish);
	}
	
	@Override
	public int select(Gwish gwish) throws Exception {
		return dao.select(gwish);
	}
	
	@Override
	public void delete(int gwishNo) throws Exception {
		dao.delete(gwishNo);
	}

}
