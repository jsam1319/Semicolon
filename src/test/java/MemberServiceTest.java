import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.kosta.semicolon.member.domain.Member;
import kr.or.kosta.semicolon.member.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**.xml"})
public class MemberServiceTest {
	
    @Inject
    private MemberService service;
	
    Logger logger = Logger.getLogger(MemberServiceTest.class);
    
  //  @Test
    public void test() {
    	logger.debug(service);
        Member member = new Member("jo1o1","1111", "legm011117@naver.com", "서울특별시 금천구 두산로3가길 8-8", "박주연2", "12345", "010-2408-9952", 24, "여");
        member.setAppToken("1");
        member.setSessionId("1");
        member.setSessionLimit(null);
        int num = service.insert(member);
        logger.debug(num);
    }
    
//    @Test
    public void isMember() {
    	Member dto = new Member();
    	dto.setId("joo");
    	dto.setPassword("1111");
    	logger.debug(service.isMember(dto));
    }
    
//    @Test
    public void update() throws Exception {
    	Member member = new Member();
    	member.setId("park");
    	member.setSessionId("12345123124233132123123");
    	member.setSessionLimit(null);
    	service.updateLogin(member);
    }
    
    @Test
    public void test2() throws ParseException {
    	 int days = 60 * 60 * 24 * 14; //14일간 저장
         Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * days));
         SimpleDateFormat format = new SimpleDateFormat("YYYYMMDDHHMMSS");
         sessionLimit = format.parse(sessionLimit.toString());
         
         logger.info("session_limitmit : " + sessionLimit.toString());
    }
	 
}
