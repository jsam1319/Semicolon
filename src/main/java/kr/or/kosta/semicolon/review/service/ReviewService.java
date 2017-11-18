package kr.or.kosta.semicolon.review.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.common.Params;
import kr.or.kosta.semicolon.review.domain.Review;

public interface ReviewService {
	
	public List<Review> allList();
	
	public int insert(Review review);
	
	public Review select(int reviewNo) throws Exception;
	
	public void update(Review review) throws Exception;
	
	public void delete(int reviewNo) throws Exception;
	
	public Map<String, Object> listAll(Params params) throws Exception;
	
	public int listCount() throws Exception;
}