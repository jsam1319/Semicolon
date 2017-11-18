package kr.or.kosta.semicolon.orders.domain;

/**
 * @packgename  	 kr.or.kosta.semicolon.orders.domain
 * @filename         Orders.java
 * @author           박주연
 * @since            2017. 11. 18.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 14.        박연주        최초 생성
 * 2017. 11. 18.		박주연		  orderNo 변수 이름변경
 *
 */
public class Orders {
	
	//변수 12개
	int ordersNo;
	int memberNo;
	int gpurchaseNo;
	String oDate;
	int price;
	String address;
	String receiver;
	String phone;
	int qty;
	String message;
	String postcode;
	String status;
	
	/** 생성자 */
	
	public Orders() {}
	
	public Orders(int memberNo, int gpurchaseNo, int price, String address, String receiver, String phone, int qty, String message, String postcode, String status) {
		this(0, memberNo, gpurchaseNo, null, price, address, receiver, phone, qty, message, postcode, status);
	}
	
	public Orders(int ordersNo, int memberNo, int gpurchaseNo, String oDate, int price, String address, String receiver, String phone, int qty, String message, String postcode, String status) {
		this.ordersNo = ordersNo;
		this.memberNo = memberNo;
		this.gpurchaseNo = gpurchaseNo;
		this.oDate = oDate;
		this.price = price;
		this.address = address;
		this.receiver = receiver;
		this.phone = phone;
		this.qty = qty;
		this.message = message;
		this.postcode = postcode;
		this.status = status;
	}

	public int getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(int orderNo) {
		this.ordersNo = orderNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getGpurchaseNo() {
		return gpurchaseNo;
	}

	public void setGpurchaseNo(int gpurchaseNo) {
		this.gpurchaseNo = gpurchaseNo;
	}

	public String getODate() {
		return oDate;
	}

	public void setODate(String oDate) {
		this.oDate = oDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [ordersNo=" + ordersNo + ", memberNo=" + memberNo + ", gpurchaseNo=" + gpurchaseNo + ", oDate="
				+ oDate + ", price=" + price + ", address=" + address + ", receiver=" + receiver + ", phone=" + phone
				+ ", qty=" + qty + ", message=" + message + ", postcode=" + postcode + ", status=" + status + "]";
	}
	
	

}
