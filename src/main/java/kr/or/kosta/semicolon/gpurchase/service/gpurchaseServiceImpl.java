package kr.or.kosta.semicolon.gpurchase.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.bottom.dao.BottomDao;
import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.common.util.CompareTime;
import kr.or.kosta.semicolon.company.dao.CompanyDao;
import kr.or.kosta.semicolon.goods.dao.GoodsDao;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.gpurchase.dao.gpurchaseDao;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;
import kr.or.kosta.semicolon.gwish.dao.gwishDao;
import kr.or.kosta.semicolon.tops.dao.TopsDao;

/**
 * @packgename   kr.or.kosta.semicolon.gpurchase.service
 * @filename         gpurchaseServiceImpl.java
 * @author          박연주
 * @since            2017. 11. 10.
 * @see				공구 관리 비지니스 로직 처리 클래스
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 10.      연주         최초 생성
 *
 */
@Service
public class gpurchaseServiceImpl implements gpurchaseService {

	@Inject
	private gpurchaseDao gpdao;
	
	@Inject
	private GoodsDao goodsDao;
	
	@Inject
	private CompanyDao comDao;
	
	@Inject
	private BottomDao bottomDao;
	
	@Inject
	private TopsDao topsdao;
	
	@Override
	public void insert(Gpurchase gpurchase) throws Exception {
		gpdao.insert(gpurchase);
	}
	
	@Override
	public Map<String, Object> select(int gpurchaseNo) throws Exception {
		Gpurchase gpurchase = new Gpurchase();
		gpurchase = gpdao.select(gpurchaseNo);
		
		Goods goods = new Goods();
		goods = goodsDao.select(gpurchase.getGoodsNo());
		
		String companyName = comDao.selectCName(gpurchase.getGoodsNo());
		
		List<HashMap<String, String>> sizeList;
		
		if (goods.getCategory() < 200) {
			sizeList = topsdao.selectSize(gpurchaseNo);
		} else {
			sizeList = bottomDao.selectSize(gpurchaseNo);
		}
		
		List<String> size = new ArrayList<String>(); 
		for (HashMap<String, String> list : sizeList) {
			size.add(list.get("SIZES"));
		}
	
		Map<String, Object> map = new HashMap<>();
		map.put("gpurchase", gpurchase);
		map.put("goods", goods);
		map.put("companyName", companyName);
		map.put("size", size);

		return map;
	}
	
	@Override
	public int selectGoodsNo(int gpurchaseNo) throws Exception {
		return gpdao.selectGoodsNo(gpurchaseNo);
	}
	
	
	@Override
	public List<Gpurchase> gpListAll() throws Exception {
		return gpdao.gpListAll();
	}
	
	
	@Override
	public Map<String, Object> listAll(Params params, int category) throws Exception {
		List<Gpurchase> gplist = gpdao.listAll(params);
		List<Goods> glist = goodsDao.categoryListAll(category);
		List<Map<String, Object>> comlist = comDao.selectCNameListAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("gplist", gplist);
		map.put("glist", glist);
		map.put("comlist", comlist);
		
		
		
		
		return map;
	}
	/*
	@Override
	public void update(Gpurchase gpurchase) throws Exception {
		gpdao.update(gpurchase);
	}
	*/
	@Override
	public void delete(int gpurchaseNo) throws Exception {
		gpdao.delete(gpurchaseNo);
	}
	/*
	@Override
	public List<Gpurchase> listAll(Params params) throws Exception {
		return gpdao.listAll(params);
	}
	*/
	@Override
	public void updateCntP(int gpurchaseNo) throws Exception {
		gpdao.updateCntP(gpurchaseNo);
	}
	
	@Override
	public void updateCntM(int gpurchaseNo) throws Exception {
		gpdao.updateCntM(gpurchaseNo);
	}
	
	
	@Override
	public Map<String, Object> glistAll(Params params, int category) throws Exception {
		List<Gpurchase> gplist = gpdao.glistAll(params);
		List<Goods> glist = goodsDao.categoryListAll(category);
		List<Map<String, Object>> comlist = comDao.selectCNameListAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("gplist", gplist);
		map.put("glist", glist);
		map.put("comlist", comlist);
		
		return map;
	}
	
	@Override
	public Map<String, Object> endlistAll(Params params, int category) throws Exception {
		List<Gpurchase> gplist = gpdao.endlistAll(params);
		List<Goods> glist = goodsDao.categoryListAll(category);
		List<Map<String, Object>> comlist = comDao.selectCNameListAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("gplist", gplist);
		map.put("glist", glist);
		map.put("comlist", comlist);
		
		return map;
	}
	
	
	@Override
	public List<Integer> selectGolist() throws Exception {
		List<Integer> list = gpdao.selectGolist();
		
		return list;
	}
	
	@Override
	public void statusUpdate(Gpurchase gpurchase) throws Exception {
		gpdao.statusUpdate(gpurchase);
	}
	
	
}
