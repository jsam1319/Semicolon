package kr.or.kosta.semicolon.log.dao;

import java.util.List;

import kr.or.kosta.semicolon.gpurchase.domain.GpurchaseInfo;
import kr.or.kosta.semicolon.log.domain.Log;

public interface LogDao {

	public int insert(Log log);
	
	public List<GpurchaseInfo> mostCategory(int memberNo);
	
	public List<GpurchaseInfo> popularPurchase();
}
