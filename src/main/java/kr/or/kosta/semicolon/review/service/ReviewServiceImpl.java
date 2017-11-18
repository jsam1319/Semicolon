package kr.or.kosta.semicolon.review.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.common.Params;
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
/*
	@Override
	public List<Review> listAll(Params params) throws Exception {
		
		return null;
	}
*/
	@Override
	public int listCount() throws Exception {
		
		return reviewDao.listCount();
	}

}
