package kr.or.kosta.semicolon.push.domain;

import java.util.Arrays;

/**
 * @packgename   kr.or.kosta.semicolon.push.domain
 * @filename         PushToken.java
 * @author          Jeon SeJong
 * @since            2017. 11. 28.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 28.      sejong         최초 생성
 *
 *
 */
public class PushToken {
	
	private String title;
	private String message;
	private String pushToken;
	private boolean allPush;
	
	public PushToken() {}

	public PushToken(String title, String message, String pushToken, boolean allPush) {
		this.title = title;
		this.message = message;
		this.pushToken = pushToken;
		this.allPush = allPush;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPushToken() {
		return pushToken;
	}

	public void setPushToken(String pushToken) {
		this.pushToken = pushToken;
	}

	public boolean isAllPush() {
		return allPush;
	}

	public void setAllPush(boolean allPush) {
		this.allPush = allPush;
	}

	@Override
	public String toString() {
		return "PushToken [title=" + title + ", message=" + message + ", pushToken=" + pushToken + ", allPush="
				+ allPush + "]";
	}

	
}
