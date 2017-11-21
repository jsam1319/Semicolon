package kr.or.kosta.semicolon.tops.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.goods.domain.TakeAllThings;
import kr.or.kosta.semicolon.tops.dao.TopsDao;
import kr.or.kosta.semicolon.tops.domain.Tops;
/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.tops.service
 * @filename         TopsServiceImpl.java
 * @author           김미소
 * @since            2017. 11. 18.
 * @see 			 
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 18.      김미소         최초 생성
 * 2017. 11. 18.      박주연		 getBySize 추가
 *
 *
 */
@Service
public class TopsServiceImpl implements TopsService {

	@Inject
	TopsDao dao;
	
	@Override
	public void insert(Tops tops) {
		dao.insert(tops);
	}
	
	@Override
	public Tops getBySize(String size) {
		return dao.getBySize(size);
	}

	

}
