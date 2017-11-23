package kr.or.kosta.semicolon.orderlist.domain;

public class OrderList {
	private int orderListNo;
	private int topsNo;
	private int bottomNo;
	private int gpurchaseNo;
	private int ordersNo;
	private int qty;
	
	public OrderList() {} 
	
	public OrderList(int topsNo, int bottomNo, int gpurchaseNo, int ordersNo, int qty) {
		this(0,topsNo,bottomNo, gpurchaseNo, ordersNo, qty);
	}
	
	public OrderList(int orderListNo, int topsNo, int bottomNo, int gpurchaseNo, int ordersNo, int qty) {
		this.orderListNo = orderListNo;
		this.topsNo = topsNo;
		this.bottomNo = bottomNo;
		this.gpurchaseNo = gpurchaseNo;
		this.ordersNo = ordersNo;
		this.qty = qty;
	}
	public int getOrderListNo() {
		return orderListNo;
	}
	public void setOrderListNo(int orderListNo) {
		this.orderListNo = orderListNo;
	}
	public int getTopsNo() {
		return topsNo;
	}
	public void setTopsNo(int topsNo) {
		this.topsNo = topsNo;
	}
	public int getBottomNo() {
		return bottomNo;
	}
	public void setBottomNo(int bottomNo) {
		this.bottomNo = bottomNo;
	}
	public int getGpurchaseNo() {
		return gpurchaseNo;
	}
	public void setGpurchaseNo(int gpurchaseNo) {
		this.gpurchaseNo = gpurchaseNo;
	}
	public int getOrdersNo() {
		return ordersNo;
	}
	public void setOrdersNo(int ordersNo) {
		this.ordersNo = ordersNo;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "OrderList [orderListNo=" + orderListNo + ", topsNo=" + topsNo + ", bottomNo=" + bottomNo
				+ ", gpurchaseNo=" + gpurchaseNo + ", ordersNo=" + ordersNo + ", qty=" + qty + "]";
	}
	
}
