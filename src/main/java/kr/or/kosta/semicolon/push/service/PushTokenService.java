package kr.or.kosta.semicolon.push.service;

import kr.or.kosta.semicolon.push.domain.PushToken;

public interface PushTokenService {

	public void pushToken(PushToken token) throws Exception;
	
}
