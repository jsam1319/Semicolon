package kr.or.kosta.semicolon.qna.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.qna.domain.Qna;

public interface QnaService {
	
//	public List<Qna> listAll(int memberNo);
	public List<Qna> allList();
	
	public int insert(Qna qna);
	
	public Qna select(int qnaNo) throws Exception;
	
	public void update(Qna qna);

	public void modify(Qna qna) throws Exception;
	
	public Map<String, Object> listAll(Params params) throws Exception;
	
}
