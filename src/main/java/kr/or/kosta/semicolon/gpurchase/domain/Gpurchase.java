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
 * 2017. 11. 10.      연주         최초 생성
 *
 *
 */
public class Gpurchase {
	
	int gpurchaseNo;
	int goodsNo;
	int min;
	int price;
	String startDate;
	String endDate;
	String status;
	
	public Gpurchase() {}
	
	public Gpurchase(int goodsNo, int min, int price, String startDate, String endDate) {
		this(0, goodsNo, min, price, startDate, endDate, null);
	}

	public Gpurchase(int gpurchaseNo, int goodsNo, int min, int price, String startDate, String endDate, String status) {
		this.gpurchaseNo = gpurchaseNo;
		this.goodsNo = goodsNo;
		this.min = min;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "gpurchase [gpurchaseNo=" + gpurchaseNo + ", goodsNo=" + goodsNo + ", min=" + min + ", price=" + price
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}
	
	
	
	

}
