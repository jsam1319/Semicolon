package kr.or.kosta.semicolon.aftersales.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.aftersales.dao.AfterSalesDao;
import kr.or.kosta.semicolon.aftersales.domain.AfterSales;
import kr.or.kosta.semicolon.common.UseParameter;

@Service
public class AfterSalesServiceImpl implements AfterSalesService {
	
	@Inject
	AfterSalesDao aftersalesDao;

	@Override
	public int insert(AfterSales aftersales) {
		
		return aftersalesDao.insert(aftersales);
	}

	@Override
	public AfterSales select(int aftersalesNo) {
		
		return aftersalesDao.select(aftersalesNo);
	}

	@Override
	public void update(int aftersalesNo) {
		
		aftersalesDao.update(aftersalesNo);
	}

	@Override
	public void delete(int aftersalesNo) {
		
		aftersalesDao.delete(aftersalesNo);
	}

	@Override
	public Map<String, Object> listAll(UseParameter params) {
		
		List<AfterSales> list = aftersalesDao.listAll(params);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}

}
