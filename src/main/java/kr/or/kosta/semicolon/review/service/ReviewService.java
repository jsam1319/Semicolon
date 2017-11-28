package kr.or.kosta.semicolon.review.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.common.UseParameter;
import kr.or.kosta.semicolon.review.domain.Review;

public interface ReviewService {
	
	public List<Review> allList();
	
	public int insert(Review review);
	
	public Review select(int reviewNo) throws Exception;
	
	public void update(Review review) throws Exception;
	
	public void delete(int reviewNo) throws Exception;
	
	public Map<String, Object> listAll(UseParameter params) throws Exception;
	
	public int listAvg(int goodsNo) throws Exception;
	
	public String getFile(int reivewNo) throws Exception;
}
