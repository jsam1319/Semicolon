package kr.or.kosta.semicolon.membersize.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.membersize.dao.MemberSizeDao;
import kr.or.kosta.semicolon.membersize.domain.MemberSize;

@Service
public class MemberSizeServiceImpl implements MemberSizeService {
	@Inject
	MemberSizeDao sizeDao;
	
	@Override
	public int insert(MemberSize size) {
		return sizeDao.insert(size);
	}

	@Override
	public MemberSize select(int no) {
		return sizeDao.select(no);
	}

	@Override
	public int update(MemberSize size) {
		return sizeDao.update(size);
	}

	@Override
	public void delete(int no) {
		sizeDao.delete(no);
	}

	@Override
	public List<MemberSize> listAll() {
		return sizeDao.listAll();
	}

}
