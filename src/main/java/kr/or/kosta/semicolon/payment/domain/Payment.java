package kr.or.kosta.semicolon.payment.domain;

/**
 * @packgename   kr.or.kosta.semicolon.payment
 * @filename         Payment.java
 * @author          박연주
 * @since            2017. 11. 27.
 * @see			Payment 테이블의 Domain
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 27.      kosta         최초 생성
 *
 *
 */
public class Payment {
	
	private int paymentNo;
	private int ordersNo;
	private String method;
	private int payPrice;
	private String regdate;
	private String cardInfo;
	
	
	public Payment() {}
	
	public Payment(int paymentNo, int ordersNo, String method, int payPrice, String regdate, String cardInfo) {
		super();
		this.paymentNo = paymentNo;
		this.ordersNo = ordersNo;
		this.method = method;
		this.payPrice = payPrice;
		this.regdate = regdate;
		this.cardInfo = cardInfo;
	}

	public int getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}

	public int getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(int ordersNo) {
		this.ordersNo = ordersNo;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(String cardInfo) {
		this.cardInfo = cardInfo;
	}

	@Override
	public String toString() {
		return "payment [paymentNo=" + paymentNo + ", ordersNo=" + ordersNo + ", method=" + method + ", payPrice="
				+ payPrice + ", regdate=" + regdate + ", cardInfo=" + cardInfo + "]";
	}
	
	
	

}
