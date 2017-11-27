package kr.or.kosta.semicolon.log.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.log.dao.LogDao;
import kr.or.kosta.semicolon.log.domain.Log;

@Service
public class LogServiceImpl {

	@Inject
	LogDao logDao;
	
	public int insert(Log log) {
		return logDao.insert(log);
	}
}
