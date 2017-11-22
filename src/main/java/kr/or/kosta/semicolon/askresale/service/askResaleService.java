package kr.or.kosta.semicolon.askresale.service;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.askresale.domain.AskResale;

/**
 * @packgename   kr.or.kosta.semicolon.askresale.service
 * @filename         askResaleService.java
 * @author          박연주
 * @since            2017. 11. 22.
 * @see			공구재요청 확인 및 처리를 위한 Service Interface
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 22.      박연주         최초 생성
 *
 *
 */
public interface askResaleService {
	
	public int selectCnt(AskResale askResale) throws Exception;
	
	public void insert(AskResale askResale) throws Exception;
	
	public int select(AskResale askResale) throws Exception;
	
	public void delete(int askResaleNo) throws Exception;

}
