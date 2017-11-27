package kr.or.kosta.semicolon.require.dao;

import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.require.domain.Require;
/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.require.dao
 * @filename         RequireDao.java
 * @author           김미소
 * @since            2017. 11. 24.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 24.      김미소         최초 생성
 *
 *
 */
public interface RequireDao {
	
	public void insert(Require require); 
	
	public List<Require> listAll(int page);
	
	public Require readOne(int requireNo);
	
	public void update(Require require);
	

}
