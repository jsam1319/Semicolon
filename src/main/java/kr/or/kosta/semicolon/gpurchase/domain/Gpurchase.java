package kr.or.kosta.semicolon.gpurchase.domain;

/**
 * @packgename   kr.or.kosta.semicolon.gpurchase.domain
 * @filename         Gpurchase.java
 * @author          박연주
 * @since            2017. 11. 10.
 * @see				Gpurchase Table의 Domain 클래스
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 10.      	연주        최초 생성
 * 2017. 11. 21. 		박주연		pNum 추가
 *
 */
public class Gpurchase {
	
	int gpurchaseNo;
	int goodsNo;
	int min;
	int price;
	String startDate;
	String endDate;
	int status;
	int likeCnt;
	int pNum; //참여인원
	
	public Gpurchase() {}
	
	public Gpurchase(int goodsNo, int min, int price, String startDate, String endDate) {
		this(0, goodsNo, min, price, startDate, endDate, 0, 0, 0);
	}

	public Gpurchase(int gpurchaseNo, int goodsNo, int min, int price, String startDate, String endDate, int status, int likeCnt, 
			int pNum) {
		super();
		this.gpurchaseNo = gpurchaseNo;
		this.goodsNo = goodsNo;
		this.min = min;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.pNum = pNum;
	}

	public int getGpurchaseNo() {
		return gpurchaseNo;
	}

	public void setGpurchaseNo(int gpurchaseNo) {
		this.gpurchaseNo = gpurchaseNo;
	}

	public int getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	@Override
	public String toString() {
		return "Gpurchase [gpurchaseNo=" + gpurchaseNo + ", goodsNo=" + goodsNo + ", min=" + min + ", price=" + price
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + ", likeCnt=" + likeCnt
				+ ", pNum=" + pNum + "]";
	}


}
