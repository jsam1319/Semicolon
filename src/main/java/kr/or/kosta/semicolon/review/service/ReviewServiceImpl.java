package kr.or.kosta.semicolon.review.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.qna.domain.Qna;
import kr.or.kosta.semicolon.review.dao.ReviewDao;
import kr.or.kosta.semicolon.review.domain.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Inject
	ReviewDao reviewDao;

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
	public Map<String, Object> listAll(Params params) throws Exception {
		
		List<Review> list = reviewDao.listAll(params);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
				
		return map;
	}

	@Override
	public int listCount() throws Exception {
		
		return reviewDao.listCount();
	}

}
