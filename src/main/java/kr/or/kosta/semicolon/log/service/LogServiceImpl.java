package kr.or.kosta.semicolon.log.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.kosta.semicolon.common.enumtype.LogType;
import kr.or.kosta.semicolon.keyword.util.HangulSeperator;
import kr.or.kosta.semicolon.log.dao.LogDao;
import kr.or.kosta.semicolon.log.domain.Log;

@Service
public class LogServiceImpl implements LogService{

	@Inject
	LogDao logDao;
	
	public int insert(Log log) {
		if(log.getType().equals(LogType.SEARCH.name())) {
			log.setContent(HangulSeperator.seperate(log.getContent()));
		}
		
		return logDao.insert(log);
	}
}
