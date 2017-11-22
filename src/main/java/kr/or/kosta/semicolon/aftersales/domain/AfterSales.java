package kr.or.kosta.semicolon.aftersales.domain;

/**
 * @packgename   
 * @filename         Service.java
 * @author          Jeon sejong
 * @since            2017. 11. 20.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 20.      sejong         최초 생성
 *
 *
 */
public class AfterSales {
	
	private int aftersalesNo;
	private int goodsNo;
	private int memberNo;
	private String attachFile;
	private String content;
	private String password;
	private String status;
	private String regdate;
	
	public AfterSales() { }

	public AfterSales(int aftersalesNo, int goodsNo, int memberNo, String attachFile, String content, String password,
			String status, String regdate) {
		this.aftersalesNo = aftersalesNo;
		this.goodsNo = goodsNo;
		this.memberNo = memberNo;
		this.attachFile = attachFile;
		this.content = content;
		this.password = password;
		this.status = status;
		this.regdate = regdate;
	}


	public int getAftersalesNo() {
		return aftersalesNo;
	}

	public void setAftersalesNo(int aftersalesNo) {
		this.aftersalesNo = aftersalesNo;
	}

	public int getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "SalesService [aftersalesNo=" + aftersalesNo + ", goodsNo=" + goodsNo + ", memberNo=" + memberNo
				+ ", attachFile=" + attachFile + ", content=" + content + ", password=" + password + ", status="
				+ status + ", regdate=" + regdate + "]";
	}
	
}
