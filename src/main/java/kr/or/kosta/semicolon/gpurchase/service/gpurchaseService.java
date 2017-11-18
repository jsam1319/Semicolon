package kr.or.kosta.semicolon.gpurchase.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;

public interface gpurchaseService {
	
	public void insert(Gpurchase gpurchase) throws Exception;
	
//	public Map<String, Object> listall() throws Exception;
	
	public Map<String, Object> select(int gpurchaseNo) throws Exception;
	
	public int selectGoodsNo(int gpurchaseNo) throws Exception;
	
//	public void update(Gpurchase gpurchase) throws Exception;
	
	public void delete(int gpurchaseNo) throws Exception;
	
//	public List<Gpurchase> listAll(Params params) throws Exception;
	
	public Map<String, Object> listAll(Params params) throws Exception;
	
	public void updateCntP(int gpurchaseNo) throws Exception;

	public void updateCntM(int gpurchaseNo) throws Exception;
	
	public Map<String, Object> glistAll(Params params) throws Exception;
	
	public List<Integer> selectGolist() throws Exception;
	

}
