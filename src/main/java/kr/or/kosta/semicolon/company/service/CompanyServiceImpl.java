package kr.or.kosta.semicolon.company.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.company.dao.CompanyDao;
import kr.or.kosta.semicolon.company.domain.Company;
import kr.or.kosta.semicolon.membersize.domain.MemberSize;

/**
 * @packgename  	 kr.or.kosta.semicolon.company.service
 * @filename         CompanyServiceImpl.java
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
@Service
public class CompanyServiceImpl implements CompanyService {

	@Inject
	CompanyDao dao;
	
	@Override
	public int insert(Company company) {
		return dao.insert(company);
	}

	@Override
	public Company select(int no) {
		return dao.select(no);
	}

	@Override
	public void update(Company company) {
		dao.update(company);
	}

	@Override
	public void delete(int no) {
		dao.delete(no);
	}

	@Override
	public List<Company> listAll() {
		return dao.listAll();
	}
	
	@Override
	public int count() {
		return dao.count();
	}

}
