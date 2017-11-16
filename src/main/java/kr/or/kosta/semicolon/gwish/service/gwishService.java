package kr.or.kosta.semicolon.gwish.service;

import kr.or.kosta.semicolon.gwish.domain.Gwish;

public interface gwishService {
	
	public void insert(Gwish gwish) throws Exception;
	
	public int selectCnt(Gwish gwish) throws Exception;
	
	public int select(Gwish gwish) throws Exception;
	
	public void delete(int gwishNo) throws Exception;

}
