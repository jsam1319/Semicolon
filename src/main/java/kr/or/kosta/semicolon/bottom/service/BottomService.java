package kr.or.kosta.semicolon.bottom.service;

import kr.or.kosta.semicolon.bottom.domain.Bottom;

/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.bottom.service
 * @filename         BottomService.java
 * @author           김미소
 * @since            2017. 11. 20.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 20.      김미소         최초 생성
 *
 *
 */
public interface BottomService {
	
	/** 상품 등록시 작성한 하의 사이즈 등록 */
	public void insert(Bottom bottom);

}
