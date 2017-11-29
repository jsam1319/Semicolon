package kr.or.kosta.semicolon.negolist.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.negolist.dao.NegoListDao;
import kr.or.kosta.semicolon.negolist.domain.NegoList;
/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.negolist.service
 * @filename         NegoListServiceImpl.java
 * @author           김미소
 * @since            2017. 11. 29.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 29.      김미소         최초 생성
 *
 *
 */
@Service
public class NegoListServiceImpl implements NegoListService {
	
	@Inject
	NegoListDao dao;

	@Override
	public void insert(NegoList negoList) {
		dao.insert(negoList);
	}

}
