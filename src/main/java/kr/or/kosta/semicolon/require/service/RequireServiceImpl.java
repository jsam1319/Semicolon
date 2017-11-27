package kr.or.kosta.semicolon.require.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.require.dao.RequireDao;
import kr.or.kosta.semicolon.require.domain.Require;
/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.require.service
 * @filename         RequireServiceImpl.java
 * @author           김미소
 * @since            2017. 11. 24.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 24.      김미소         최초 생성
 *
 *
 */
@Service
public class RequireServiceImpl implements RequireService {
	
	@Inject
	RequireDao dao;

	@Override
	public void insert(Require require) {
		dao.insert(require);
		
	}

	@Override
	public List<Require> listAll(int page) {
		return dao.listAll(page);
	}
	
	public Require readOne(int requireNo) {
		return dao.readOne(requireNo);
	}

	@Override
	public void update(Require require) {
		dao.update(require);
	}
		
}
