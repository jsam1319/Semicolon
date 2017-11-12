

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.goods.dao.GoodsDao;
import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.goods.service.GoodsService;
import kr.or.kosta.semicolon.gpurchase.domain.Gpurchase;

/** 스프링 빈컨테이너에서 MyBatis 테스트 */
@RunWith(SpringJUnit4ClassRunner.class)		// @RunWith->spring 빈컨테이너를 생성한다.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class GoodsServiceTest {
	
	Logger logger = Logger.getLogger(GoodsServiceTest.class);
	
	@Inject
	private GoodsService goodsService;
	
	@Inject
	private GoodsDao dao;
	
//	@Test
	public void testCreate() throws Exception{
		Goods goods = new Goods();
		goods.setName("상품5");
		goods.setPrice(5200);
		goods.setDetail("테스트상품5 입니다.");
		goods.setFrontImg("테스트이미지5.jpg");
		goodsService.insert(goods);
		
		logger.debug("create 완료");
	}
	
//	@Test
/*	public void testlistAll() throws Exception {
		List<Goods> list = goodsService.listAll();
		
		for (Goods goods : list) {
			logger.info(goods);
		}
	}*/
	
//	@Test
	public void testSelect() throws Exception {
		logger.info(goodsService.select(1));
	}
	
//	@Test
	public void testlistAll1() throws Exception {
		Params params = new Params();
		
		List<Goods> list = goodsService.listAll(params);
		for (Goods goods : list) {
			logger.info(goods);
		}
	}
	
//	@Test
	public void testCount() throws Exception {
		int count = goodsService.listCount();
		
		logger.info(count);
	}
	
	@Test
	public void listtest() throws Exception {
		List<Goods> list = dao.listall();
		
		for (Goods goods : list) {
			logger.info(goods);
		}
	}
	
}








