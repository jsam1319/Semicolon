package kr.or.kosta.semicolon.review.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.common.UseParameter;
import kr.or.kosta.semicolon.member.dao.MemberDao;
import kr.or.kosta.semicolon.member.domain.Member;
import kr.or.kosta.semicolon.qna.domain.Qna;
import kr.or.kosta.semicolon.review.dao.ReviewDao;
import kr.or.kosta.semicolon.review.domain.Review;

/**
 * @packgename   kr.or.kosta.semicolon.review.service
 * @filename         ReviewServiceImpl.java
 * @author          Jeon SeJong
 * @since            2017. 11. 16.
 * @see			 리뷰 관리 비지니스 로직 클래스
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 16.      sejong         최초 생성
 * 2017. 11. 20.      sejong         remove(), listAvg() 메소드 추가
 *
 */
@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Inject
	ReviewDao reviewDao;
	
	@Inject
	MemberDao memberDao;

	@Override
	public List<Review> allList() {
		
		return reviewDao.allList();
	}

	@Override
	public int insert(Review review) {
		
		return reviewDao.insert(review);
	}

	@Override
	public Review select(int reviewNo) throws Exception {
		
		return reviewDao.select(reviewNo);
	}
	
	@Override
	public void update(Review review) throws Exception {
		
		reviewDao.update(review);
	}
	
	@Override
	public void delete(int reviewNo) throws Exception {
		
		reviewDao.delete(reviewNo);
	}

	@Override
	public Map<String, Object> listAll(UseParameter params) throws Exception {
		
		List<Review> list = reviewDao.listAll(params);
		List<Member> mlist = memberDao.listAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("mlist", mlist);
		
		return map;
	}

	@Override
	public int listAvg(int goodsNo) throws Exception {
		int cnt = reviewDao.selectReviewCount(goodsNo);
		
		if (cnt == 0) {
			return 0;
		} else {
			return reviewDao.listAvg(goodsNo);
		}
		
	}
	
	@Override
	public String getFile(int reivewNo) throws Exception {
		
		return reviewDao.getFile(reivewNo);
	}
	
}
