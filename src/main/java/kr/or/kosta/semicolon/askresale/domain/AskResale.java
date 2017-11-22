package kr.or.kosta.semicolon.askresale.domain;

/**
 * @packgename kr.or.kosta.semicolon.askresale.domain
 * @filename AskResale.java
 * @author 박연주
 * @since 2017. 11. 22.
 * @see 공구재요청 Domain
 *
 *      == Modification Infomation (수정 이력) ==
 * 
 *      DATE AUTHOR NOTE -------- -----------
 *      --------------------------------------- 2017. 11. 22. 박연주 최초 생성
 *
 *
 */
public class AskResale {

	private int askResaleNo;
	private int gpurchaseNo;
	private int memberNo;
	private String date;

	public AskResale(int gpurchaseNo, int memberNo) {
		this(0, gpurchaseNo, memberNo, null);
	}

	public AskResale(int askResaleNo, int gpurchaseNo, int memberNo, String date) {
		this.askResaleNo = askResaleNo;
		this.gpurchaseNo = gpurchaseNo;
		this.memberNo = memberNo;
		this.date = date;
	}

	public int getAskResaleNo() {
		return askResaleNo;
	}

	public void setAskResaleNo(int askResaleNo) {
		this.askResaleNo = askResaleNo;
	}

	public int getGpurchaseNo() {
		return gpurchaseNo;
	}

	public void setGpurchaseNo(int gpuchaseNo) {
		this.gpurchaseNo = gpuchaseNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "askResale [askResaleNo=" + askResaleNo + ", gpurchaseNo=" + gpurchaseNo + ", memberNo=" + memberNo
				+ ", date=" + date + "]";
	}

}
