package kr.or.kosta.semicolon.tops.dao;

import kr.or.kosta.semicolon.tops.domain.Tops;

public interface TopsDao {
	/** 사이즈에 따른 상세정보 조회 (체형별 정보에 사용할 상세정보들) */
	public Tops getBySize(String size);
}
