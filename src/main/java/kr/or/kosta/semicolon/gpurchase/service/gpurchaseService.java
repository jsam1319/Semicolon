package kr.or.kosta.semicolon.gpurchase.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;

public interface gpurchaseService {
	
	public void insert(Gpurchase gpurchase) throws Exception;
	
	public List<Gpurchase> gpListAll() throws Exception;
	
	public Map<String, Object> select(int gpurchaseNo) throws Exception;
	
	public int selectGoodsNo(int gpurchaseNo) throws Exception;
	
//	public void update(Gpurchase gpurchase) throws Exception;
	
	public void delete(int gpurchaseNo) throws Exception;
	
//	public List<Gpurchase> listAll(Params params) throws Exception;
	
	// 공구 조사(research) 리스트
	public Map<String, Object> listAll(Params params, int category) throws Exception;
	
	// 공구 진행(ongoing) 리스트
	public Map<String, Object> glistAll(Params params, int category) throws Exception;
	
	// 공구 완료(end) 리스트
	public Map<String, Object> endlistAll(Params params, int category) throws Exception;
	
	public void updateCntP(int gpurchaseNo) throws Exception;

	public void updateCntM(int gpurchaseNo) throws Exception;
	
	public List<Integer> selectGolist() throws Exception;
	
	public void statusUpdate(Gpurchase gpurchase) throws Exception;
	

}
