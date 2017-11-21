package kr.or.kosta.semicolon.company.dao;

import java.util.List;
import java.util.Map;

import kr.or.kosta.semicolon.company.domain.Company;
import kr.or.kosta.semicolon.membersize.domain.MemberSize;

/**
 * @packgename  	 kr.or.kosta.semicolon.company.dao
 * @filename         CompanyDao.java
 * @author           박주연
 * @since            2017. 11. 16.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 16.       박주연        최초 생성
 * 2017. 11. 20.	       박연주	  selectCName(회사이름 가져오기) 추가   
 *
 */
public interface CompanyDao {
	public int insert(Company company);
	public Company select(int no);
	public void update(Company company);
	public void delete(int no);
	public List<MemberSize> listAll();
	public List<Map<String, Object>> selectCName();
	
}
