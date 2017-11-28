package kr.or.kosta.semicolon.gpurchase.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.bottom.dao.BottomDao;
import kr.or.kosta.semicolon.common.UseParameter;
import kr.or.kosta.semicolon.company.dao.CompanyDao;
import kr.or.kosta.semicolon.goods.dao.GoodsDao;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.gpurchase.dao.gpurchaseDao;
import kr.or.kosta.semicolon.gpurchase.domain.CategorySales;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;
import kr.or.kosta.semicolon.keyword.dao.KeywordDao;
import kr.or.kosta.semicolon.keyword.domain.Keyword;
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
 * 2017. 11. 10.     박연주   	최초 생성
 * 2017. 11. 23.	 박주연	    getSalesByCategory 추가
 * 2017. 11. 28.	 박연주		updateResearchCancle 추가
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
	
	@Inject
	private KeywordDao keyworddao;
	
	@Override
	public void insert(Gpurchase gpurchase) throws Exception {
		gpdao.insert(gpurchase);
	}
	
	@Override
	public Map<String, Object> select(int gpurchaseNo) throws Exception {
//		공구 정보 불러오기
		Gpurchase gpurchase = new Gpurchase();
		gpurchase = gpdao.select(gpurchaseNo);
		
//		상품 정보 불러오기
		Goods goods = new Goods();
		goods = goodsDao.select(gpurchase.getGoodsNo());
		
//		회사명 불러오기
		String companyName = comDao.selectCName(gpurchase.getGoodsNo());
		
//		상품 키워드 불러오기
		List<HashMap<String, String>> keywordList;
		keywordList = keyworddao.selectName(goods.getGoodsNo());
		
		List<String> keyword = new ArrayList<>();
		for (HashMap<String, String> kw : keywordList) {
			keyword.add(kw.get("KEYWORDNAME"));
		}
		
//		상품 사이즈 카테고리별 분리 및 불러오기
		List<HashMap<String, Object>> sizeList;
		
		if (goods.getCategory() < 200) {
			sizeList = topsdao.selectSize(gpurchaseNo);
		} else {
			sizeList = bottomDao.selectSize(gpurchaseNo);
		}
		
		List<Object> size = new ArrayList<>(); 
		for (HashMap<String, Object> list : sizeList) {
			size.add(list);
		}
	
		
		Map<String, Object> map = new HashMap<>();
		map.put("gpurchase", gpurchase);
		map.put("goods", goods);
		map.put("keyword", keyword);
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
	public Map<String, Object> listAll(UseParameter params, int category) throws Exception {
		List<Gpurchase> gplist = gpdao.listAll(params);
		List<Goods> glist = goodsDao.categoryListAll(category);
		List<Map<String, Object>> comlist = comDao.selectCNameListAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("gplist", gplist);
		map.put("glist", glist);
		map.put("comlist", comlist);
		
		return map;
	}
	
	@Override
	public void delete(int gpurchaseNo) throws Exception {
		gpdao.delete(gpurchaseNo);
	}
	
	@Override
	public void updateCntP(int gpurchaseNo) throws Exception {
		gpdao.updateCntP(gpurchaseNo);
	}
	
	@Override
	public void updateCntM(int gpurchaseNo) throws Exception {
		gpdao.updateCntM(gpurchaseNo);
	}
	
	@Override
	public Map<String, Object> glistAll(UseParameter params, int category) throws Exception {
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
	public Map<String, Object> endlistAll(UseParameter params, int category) throws Exception {
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
	
	@Override
	public List<CategorySales> getSalesByCategory(){
		return gpdao.getSalesByCategory();
	}
	
	@Override
	public void updateResearchCancle(int gpurchaseNo) throws Exception {
		gpdao.updateResearchCancle(gpurchaseNo);
	}
	
}
