

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
import kr.or.kosta.semicolon.qna.domain.Qna;
import kr.or.kosta.semicolon.qna.service.QnaService;

/** 스프링 빈컨테이너에서 MyBatis 테스트 */
@RunWith(SpringJUnit4ClassRunner.class)		// @RunWith->spring 빈컨테이너를 생성한다.
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class QnaServiceTest {
	
	Logger logger = Logger.getLogger(QnaServiceTest.class);
	
	@Inject
	private QnaService qnaService;
	
//	@Test
	public void testCreate() throws Exception{
		
		Qna qna = new Qna();
		qna.setGoodsNo(1);
		qna.setMemberNo(1);
		qna.setTitle("이 바지..");
		qna.setContent("더 작은것 있나요?");
		
		qnaService.insert(qna);
		
		logger.debug("create 완료");
	}
	
//	@Test
	public void testSelect() throws Exception{
		
		Qna qna = qnaService.select(7);
		
		logger.info(qna);
		logger.info("상세보기 완료");
	}

//	@Test
	public void testUpdate() throws Exception{
		
		Qna qna = new Qna();
		qna.setQnaNo(7);
		qna.setAnswerContent("더 작은것은 없습니다..");
		
		qnaService.update(qna);
		
		logger.info(qna);
		logger.info("답글 완료");
	}
	
	@Test
	public void testList() throws Exception{
		
	}
}








