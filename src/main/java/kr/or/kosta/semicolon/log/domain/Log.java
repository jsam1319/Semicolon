package kr.or.kosta.semicolon.log.domain;

/**
 * @packgename   kr.or.kosta.semicolon.log.domain
 * @filename         Log.java
 * @author          jaehyun
 * @since            2017. 11. 27.
 * @see					Log의 Domain
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 27.      jaehyun         최초 생성
 *
 *
 */
public class Log {

	int logNo;
	int memberNo;
	String type;
	String content;
	String regdate;
	
	/* Content Case
	 * * SESRCH -> Keyword
	 * * PURCHASE, BEFORELIKE, AFTERLIKE, VIEW -> gpurchase_no
	 * */
	
	
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Log(int logNo, int memberNo, String type, String content, String regdate) {
		super();
		this.logNo = logNo;
		this.memberNo = memberNo;
		this.type = type;
		this.content = content;
		this.regdate = regdate;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	public int getLogNo() {
		return logNo;
	}
	public void setLogNo(int logNo) {
		this.logNo = logNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "Log [logNo=" + logNo + ", memberNo=" + memberNo + ", type=" + type + ", content=" + content + "]";
	}
	
	
	
}
