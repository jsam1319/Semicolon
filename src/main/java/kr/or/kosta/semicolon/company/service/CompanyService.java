package kr.or.kosta.semicolon.company.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.company.domain.Company;
import kr.or.kosta.semicolon.membersize.domain.MemberSize;

/**
 * @packgename  	 kr.or.kosta.semicolon.company.service
 * @filename         CompanyService.java
 * @author           박주연
 * @since            2017. 11. 18.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 18.       박주연        최초 생성
 * 
 *
 */
public interface CompanyService {
	public int insert(Company company);
	public Company select(int no);
	public void update(Company company);
	public void delete(int no);
	public List<Company> listAll();
	public int count();
}
