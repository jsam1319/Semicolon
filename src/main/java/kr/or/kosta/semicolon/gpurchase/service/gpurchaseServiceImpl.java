package kr.or.kosta.semicolon.gpurchase.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.goods.dao.GoodsDao;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.gpurchase.dao.gpurchaseDao;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;

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
		
		Map<String, Object> map = new HashMap<>();
		map.put("gpurchase", gpurchase);
		map.put("goods", goods);
		
		return map;
	}
	
	/*
	@Override
	public Map<String, Object> listall() throws Exception {
		List<Gpurchase> gplist = gpdao.listall();
		List<Goods> glist = goodsDao.listall();
		
		Map<String, Object> map = new HashMap<>();
		map.put("gplist", gplist);
		map.put("glist", glist);
		
		return map;
	}
	*/
	
	@Override
	public Map<String, Object> listAll(Params params) throws Exception {
		List<Gpurchase> gplist = gpdao.listAll(params);
		List<Goods> glist = goodsDao.listall();
		
		Map<String, Object> map = new HashMap<>();
		map.put("gplist", gplist);
		map.put("glist", glist);
		
		return map;
	}
	
	@Override
	public void update(Gpurchase gpurchase) throws Exception {
		gpdao.update(gpurchase);
	}
	
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
	public int listCount() throws Exception {
		return gpdao.listCount();
	}
}
