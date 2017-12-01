package kr.or.kosta.semicolon.gpurchase.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.askresale.dao.AskresaleDao;
import kr.or.kosta.semicolon.askresale.domain.AskResale;
import kr.or.kosta.semicolon.bottom.dao.BottomDao;
import kr.or.kosta.semicolon.common.UseParameter;
import kr.or.kosta.semicolon.common.enumtype.TopsSize;
import kr.or.kosta.semicolon.gpurchase.dao.gpurchaseDao;
import kr.or.kosta.semicolon.gpurchase.domain.CategorySales;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;
import kr.or.kosta.semicolon.gpurchase.domain.GpurchaseInfo;
import kr.or.kosta.semicolon.keyword.dao.KeywordDao;
import kr.or.kosta.semicolon.keyword.util.HangulSeperator;
import kr.or.kosta.semicolon.orders.dao.OrdersDao;
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
 * 2017. 11. 29.	 박연주		listAll, glistAll, endlistAll 삭제, ListAll 추가
 */
@Service
public class gpurchaseServiceImpl implements gpurchaseService {

	@Inject
	private gpurchaseDao gpdao;
	
	@Inject
	private BottomDao bottomDao;
	
	@Inject
	private TopsDao topsdao;
	
	@Inject
	private KeywordDao keyworddao;
	
	@Inject
	private OrdersDao ordersDao;
	
	@Inject
	private AskresaleDao resaleDao;
	
	
	Logger logger = Logger.getLogger(gpurchaseServiceImpl.class);
	
	@Override
	public void insert(Gpurchase gpurchase) throws Exception {
		gpdao.insert(gpurchase);
	}
	
	@Override
	public Map<String, Object> select(int gpurchaseNo, int memberNo) throws Exception {
		
		// 공구 정보 불러오기
		GpurchaseInfo gpurchase = new GpurchaseInfo();
		gpurchase = gpdao.select(gpurchaseNo);
		
		// 상품 키워드 불러오기
		List<String> keyword;
		keyword = keyworddao.selectName(gpurchase.getGoodsNo());
		for(int i=0; i<keyword.size(); i++) {
			keyword.set(i,HangulSeperator.conHangul(keyword.get(i)));
		}
		
		// 상품 사이즈 카테고리별 분리 및 불러오기
		List<HashMap<String, Object>> sizeList;
		
		if (gpurchase.getCategory() < 200) {
			sizeList = topsdao.selectSize(gpurchaseNo);
		} else {
			sizeList = bottomDao.selectSize(gpurchaseNo);
		}
		
		sizeList = sort(sizeList);
		
		
		// 회원 주문 여부 반환
		AskResale askResale = new AskResale(gpurchaseNo, memberNo);
		int orderCheck = ordersDao.SelectOrderCheck(askResale);
		
		Map<String, Object> map = new HashMap<>();
		map.put("gpurchase", gpurchase);
		map.put("keyword", keyword);
		map.put("size", sizeList);
		map.put("orderCheck", orderCheck);
		
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
	public List<GpurchaseInfo> ListAll(UseParameter parameter) throws Exception {
		List<GpurchaseInfo> list = gpdao.ListAll(parameter);
		
		return list;
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
	public List<Integer> selectGolist() throws Exception {
		return gpdao.selectGolist();
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
	
	//상의 사이즈 순서대로 정렬
	public List<HashMap<String,Object>> sort(List<HashMap<String,Object>> sizeList){
		
		for(int i=0; i<sizeList.size(); i++) {
			for(int j=0; j<sizeList.size(); j++) {
				
				int cmp1 = TopsSize.valueOfNo(sizeList.get(i).get("SIZES").toString());
				int cmp2 = TopsSize.valueOfNo(sizeList.get(j).get("SIZES").toString());

				if(cmp1 < cmp2){
					HashMap<String, Object> mapI;
					HashMap<String, Object> mapJ;
					
					mapI = sizeList.get(j);
					mapJ = sizeList.get(i);
					
					sizeList.set(i, mapI);
					sizeList.set(j, mapJ);
				}
			}
		}
		
		return sizeList;
	}
	
}
