package kr.or.kosta.semicolon.membersize.service;

import java.util.List;

import kr.or.kosta.semicolon.common.Clothing;
import kr.or.kosta.semicolon.membersize.domain.MemberSize;

/**
 * @packgename  	 kr.or.kosta.semicolon.membersize.service
 * @filename         MemberSizeService.java
 * @author           박주연
 * @since            2017. 11. 20.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 16.        박주연        최초 생성
 * 2017. 11. 20.		박주연		update return type 1로 변경
 * 2017. 11. 21.		박주연		compare, getGap 추가
 *
 */
public interface MemberSizeService {
	public int insert(MemberSize size);
	public MemberSize select(int no);
	public int update(MemberSize size);
	public void delete(int no);
	public List<MemberSize> listAll();
	public Clothing compare(List<? extends Clothing> goods, MemberSize size);
	public Clothing getGap(Clothing cloth, MemberSize size);
}