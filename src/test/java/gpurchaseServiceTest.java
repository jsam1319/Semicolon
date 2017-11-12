import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.kosta.semicolon.common.PageBuilder;
import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.goods.dao.GoodsDao;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.goods.service.GoodsService;
import kr.or.kosta.semicolon.gpurchase.dao.gpurchaseDao;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;
import kr.or.kosta.semicolon.gpurchase.service.gpurchaseService;

@RunWith(SpringJUnit4ClassRunner.class)		// @RunWith->spring 빈컨테이너를 생성한다.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class gpurchaseServiceTest {
	
	Logger logger = Logger.getLogger(gpurchaseServiceTest.class);
	
	@Inject
	private gpurchaseService service;
	
//	@Test
	public void testSelect() throws Exception {
		logger.info(service.select(1));
	}
	
//	@Test
	public void testlistall() throws Exception {
		Map<String, Object> map = service.listall();
		
		List<Gpurchase> gplist = (List<Gpurchase>) map.get("gplist");
		List<Goods> glist = (List<Goods>) map.get("glist");
		
		for (Gpurchase gpurchase : gplist) {
			for (Goods goods : glist) {
				if (gpurchase.getGoodsNo() == goods.getGoodsNo()) {
					logger.info(gpurchase);
					logger.info(goods);
				}
			}
		}
		
	}
	
	@Test
	public void testlistAll() throws Exception {
		Params params = new Params();
		params.setPageSize(30);
		params.setProductOrder("endDate");
		int count = service.listCount();
		logger.info("count:"+count);
		PageBuilder pb = new PageBuilder(params, count);
		pb.build();
		
		Map<String, Object> map = service.listAll(params);
		
		List<Gpurchase> gplist = (List<Gpurchase>) map.get("gplist");
		List<Goods> glist = (List<Goods>) map.get("glist");
		logger.info("gplist:"+gplist);
		logger.info("glist:"+glist);
		for (Gpurchase gpurchase : gplist) {
			for (Goods goods : glist) {
				if (gpurchase.getGoodsNo() == goods.getGoodsNo()) {
					logger.info(gpurchase);
					logger.info(goods);
				}
			}
		}
		
	}
	
//	@Test
	public void testupdate() throws Exception {
		Gpurchase gpurchase = new Gpurchase();
		
		gpurchase.setGpurchaseNo(1);
		gpurchase.setPrice(17000);
		gpurchase.setMin(5);
		
		service.update(gpurchase);
		logger.info("gg");
	}
	
//	@Test
	public void testdelete() throws Exception {
		service.delete(1);
	}

//	@Test
	/*public void testlistAll1() throws Exception {
		Params params = new Params();
		
		List<Gpurchase> list = service.listAll(params);
		for (Gpurchase gpurchase : list) {
			logger.info(gpurchase);
		}
	}*/
	
//	@Test
	public void testCount() throws Exception {
		int count = service.listCount();
		
		logger.info(count);
	}
	
	
	


}
