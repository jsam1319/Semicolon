package kr.or.kosta.semicolon.qna.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;
import kr.or.kosta.semicolon.qna.dao.QnaDao;
import kr.or.kosta.semicolon.qna.domain.Qna;

/**
 * @packgename   kr.or.kosta.semicolon.qna.service
 * @filename         QnaServiceImpl.java
 * @author          전세종
 * @since            2017. 11. 13.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 13.      세종         최초 생성
 *
 *
 */

@Service
public class QnaServiceImpl implements QnaService{
	
	@Inject
	QnaDao qnaDao;

	@Override
	public List<Qna> allList() {
		
		return qnaDao.allList();
	}

	@Override
	public int insert(Qna qna) {
		
		return qnaDao.insert(qna);
	}

	@Override
	public Qna select(int qnaNo) throws Exception {
		
		return qnaDao.select(qnaNo);
	}
	
	@Override
	public void update(Qna qna) {
		
		qnaDao.update(qna);
	}
	
	@Override
	public void modify(Qna qna) throws Exception {
		
		qnaDao.modify(qna);
	}
	
	@Override
	public Map<String, Object> listAll(Params params) throws Exception {
		List<Qna> list = qnaDao.listAll(params);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
				
		return map;
	}
}
