package kr.or.kosta.semicolon.orders.domain;

public class Orders {
	
	int orderNo;
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
	
	public Orders() {}
	
	public Orders(int memberNo, int gpurchaseNo, int price, String address, String receiver, String phone, int qty, String message, String postcode) {
		this(0, memberNo, gpurchaseNo, null, price, address, receiver, phone, qty, message, postcode, null);
	}
	
	public Orders(int orderNo, int memberNo, int gpurchaseNo, String oDate, int price, String address, String receiver, String phone, int qty, String message, String postcode, String status) {
		this.orderNo = orderNo;
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

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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

	public String getoDate() {
		return oDate;
	}

	public void setoDate(String oDate) {
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
		return "Orders [orderNo=" + orderNo + ", memberNo=" + memberNo + ", gpurchaseNo=" + gpurchaseNo + ", oDate="
				+ oDate + ", price=" + price + ", address=" + address + ", receiver=" + receiver + ", phone=" + phone
				+ ", qty=" + qty + ", message=" + message + ", postcode=" + postcode + ", status=" + status + "]";
	}
	
	

}
