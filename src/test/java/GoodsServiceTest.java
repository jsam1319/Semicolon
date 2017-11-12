

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.kosta.semicolon.goods.domain.Goods;
import kr.or.kosta.semicolon.goods.service.GoodsService;

/** 스프링 빈컨테이너에서 MyBatis 테스트 */
@RunWith(SpringJUnit4ClassRunner.class)		// @RunWith->spring 빈컨테이너를 생성한다.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class GoodsServiceTest {
	
	@Inject
	private GoodsService goodsService;
	
	@Test
	public void testCreate() throws Exception{
		Goods goods = new Goods();
		goods.setName("상품5");
		goods.setPrice(5200);
		goods.setDetail("테스트상품5 입니다.");
		goods.setFrontImg("테스트이미지5.jpg");
		goodsService.insert(goods);
	}
	
}








