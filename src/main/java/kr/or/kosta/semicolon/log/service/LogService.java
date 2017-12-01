package kr.or.kosta.semicolon.log.service;

import java.util.List;

import kr.or.kosta.semicolon.gpurchase.domain.GpurchaseInfo;
import kr.or.kosta.semicolon.log.domain.Log;

public interface LogService {

	public int insert(Log log);
	
	public List<GpurchaseInfo> mostCategory(int memberNo);
	
	public List<GpurchaseInfo> popularPurchase();
}
