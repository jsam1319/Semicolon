package kr.or.kosta.semicolon.orders.domain;

/**
 * @packgename  	 kr.or.kosta.semicolon.orders.domain
 * @filename         OrderDetail.java
 * @author           박주연
 * @since            2017. 11. 27.
 * @see				 주문상세보기를 위해 필요한 주문에 관한 정보들
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 27.       박주연        최초 생성
 *
 *
 */
public class OrderDetail {
	private int ordersNo; /** 주문번호 */
	private String odate; /** 주문날짜 */
	private int price; /** 주문금액 */
	private String address;/** 수취인 주소 */
	private String postcode; /** 우편번호 */
	private String receiver; /** 수취인 이름 */
	private String phone; /** 휴대폰번호 */
	private String message; /** 주문 메세지 */
	private String status;/** 주문상태 */
	private String method; /** 결제 방법 */
	private String pdate; /** 결제 날짜 */
	private String cardInfo;/** 결제 카드 정보 */
	private String name; /** 주문자 이름 */
	
	public OrderDetail() {}
	
	public OrderDetail(int ordersNo, String odate, int price, String address, String postcode, String receiver,
			String phone, String message, String status, String method, String pdate, String cardInfo, String name) {
		super();
		this.ordersNo = ordersNo;
		this.odate = odate;
		this.price = price;
		this.address = address;
		this.postcode = postcode;
		this.receiver = receiver;
		this.phone = phone;
		this.message = message;
		this.status = status;
		this.method = method;
		this.pdate = pdate;
		this.cardInfo = cardInfo;
		this.name = name;
	}


	public int getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(int ordersNo) {
		this.ordersNo = ordersNo;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(String cardInfo) {
		this.cardInfo = cardInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetail [ordersNo=" + ordersNo + ", odate=" + odate + ", price=" + price + ", address=" + address
				+ ", postcode=" + postcode + ", receiver=" + receiver + ", phone=" + phone + ", message=" + message
				+ ", status=" + status + ", method=" + method + ", pdate=" + pdate + ", cardInfo=" + cardInfo
				+ ", name=" + name + "]";
	}

}
