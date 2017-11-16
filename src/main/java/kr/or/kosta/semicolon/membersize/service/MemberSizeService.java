package kr.or.kosta.semicolon.membersize.service;

import java.util.List;

import kr.or.kosta.semicolon.membersize.domain.MemberSize;

public interface MemberSizeService {
	public int insert(MemberSize size);
	public MemberSize select(int no);
	public void update(MemberSize size);
	public void delete(int no);
	public List<MemberSize> listAll();
}
