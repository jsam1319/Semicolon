package kr.or.kosta.semicolon.aftersales.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.aftersales.domain.AfterSales;
import kr.or.kosta.semicolon.common.Params;

public interface AfterSalesService {
	
public int insert(AfterSales aftersales);
	
	public AfterSales select(int aftersalesNo);
	
	public void update(int aftersalesNo);
	
	public void delete(int aftersalesNo);
	
	public Map<String, Object> listAll(Params params);
	
	
}
