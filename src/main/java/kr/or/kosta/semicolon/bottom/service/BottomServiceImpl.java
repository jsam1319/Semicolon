package kr.or.kosta.semicolon.bottom.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.bottom.dao.BottomDao;
import kr.or.kosta.semicolon.bottom.domain.Bottom;

/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.bottom.service
 * @filename         BottomServiceImpl.java
 * @author           김미소
 * @since            2017. 11. 20.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 20.      	김미소      최초 생성
 * 2017. 11. 20.		박주연		getByTypesSize추가, select 추가
 * 2017. 11. 21.		박주연		getBySizeGoodsNo추가
 * 2017. 11. 24.		박연주		selectOrderSizes 추가
 */
@Service
public class BottomServiceImpl implements BottomService {

	@Inject
	BottomDao dao;
	
	@Override
	public void insert(Bottom bottom) {
		dao.insert(bottom);
	}
	
	@Override
	public Bottom getByTypesSize(String types, String size) {
		Bottom bottom = new Bottom();
		bottom.setTypes(types);
		bottom.setSizes(size);
		
		return dao.getByTypesSize(bottom);
	}
	
	@Override
	public List<Bottom> selectByGoodsNum(int no) {
		return dao.selectByGoodsNum(no);
	}
	
	@Override
	public Bottom getBySizeGoodsNo(Bottom bottom) {
		return dao.getBySizeGoodsNo(bottom);
	}
	
	@Override
	public String selectOrderSizes(int bottomNo) throws Exception {
		return dao.selectOrderSizes(bottomNo);
	}

}
