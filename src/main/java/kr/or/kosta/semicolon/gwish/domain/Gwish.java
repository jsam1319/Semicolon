package kr.or.kosta.semicolon.gwish.domain;

/**
 * @packgename   kr.or.kosta.semicolon.gwish
 * @filename         Gwish.java
 * @author          박연주
 * @since            2017. 11. 15.
 * @see			Gwish 테이블의 Domain
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 15.      박연주         최초 생성
 *
 *
 */
public class Gwish {
	
	int gwishNo;
	int gpurchaseNo;
	int memberNo;
	String regdate;
	
	public Gwish(){}
	
	public Gwish(int gpurchaseNo, int memberNo) {
		this(0, gpurchaseNo, memberNo, null);
	}
	
	public Gwish(int gwishNo, int gpurchaseNo, int memberNo, String regdate){
		this.gwishNo = gwishNo;
		this.gpurchaseNo = gpurchaseNo;
		this.memberNo = memberNo;
		this.regdate = regdate;
	}

	public int getGwishNo() {
		return gwishNo;
	}

	public void setGwishNo(int gwishNo) {
		this.gwishNo = gwishNo;
	}

	public int getGpurchaseNo() {
		return gpurchaseNo;
	}

	public void setGpurchaseNo(int gpurchaseNo) {
		this.gpurchaseNo = gpurchaseNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "GWish [gwishNo=" + gwishNo + ", gpurchaseNo=" + gpurchaseNo + ", memberNo=" + memberNo + ", regdate="
				+ regdate + "]";
	}
	
	

}
