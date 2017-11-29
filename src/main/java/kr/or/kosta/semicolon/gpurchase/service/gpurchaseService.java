package kr.or.kosta.semicolon.gpurchase.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.common.UseParameter;
import kr.or.kosta.semicolon.gpurchase.domain.CategorySales;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;
import kr.or.kosta.semicolon.gpurchase.domain.GpurchaseInfo;

public interface gpurchaseService {
	
	public void insert(Gpurchase gpurchase) throws Exception;
	 
	public List<Gpurchase> gpListAll() throws Exception;
	
	public Map<String, Object> select(int gpurchaseNo) throws Exception;
	
	public int selectGoodsNo(int gpurchaseNo) throws Exception;
	
//	public void update(Gpurchase gpurchase) throws Exception;
	
	public void delete(int gpurchaseNo) throws Exception;
	
//	public List<Gpurchase> listAll(Params params) throws Exception;
	
	// 공구 조사(research) 리스트
	public Map<String, Object> listAll(UseParameter params, int category) throws Exception;
	
	// 공구 진행(ongoing) 리스트
	public Map<String, Object> glistAll(UseParameter params, int category) throws Exception;
	
	// 공구 완료(end) 리스트
	public Map<String, Object> endlistAll(UseParameter params, int category) throws Exception;
	
	public List<GpurchaseInfo> ListAll(UseParameter parameter) throws Exception;
	
	// 조사 공구 카운트 +/-
	public void updateCntP(int gpurchaseNo) throws Exception;
	public void updateCntM(int gpurchaseNo) throws Exception;

	// 기한 내에 목표 인원 채운 조사 공구 리스트
	public List<Integer> selectGolist() throws Exception;
	
	// 조사 및 진행 공구 상태 업데이트(+1)
	public void statusUpdate(Gpurchase gpurchase) throws Exception;

	//카테고리별 판매량
	public List<CategorySales> getSalesByCategory();
	
	// 목표 인원을 채우지 못한 조사 공구 상태 업데이트(-1)
	public void updateResearchCancle(int gpurchaseNo) throws Exception;
}
