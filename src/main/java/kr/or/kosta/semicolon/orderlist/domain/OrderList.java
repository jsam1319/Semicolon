package kr.or.kosta.semicolon.orderlist.domain;

import java.util.Arrays;

/**
 * @packgename   kr.or.kosta.semicolon.orderlist.domain
 * @filename         OrderList.java
 * @author          박주연
 * @since            2017. 11. 24.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 23.      박주연         최초 생성
 * 
 *
 */
public class OrderList {
	private int orderListNo;
	private int topsNo; 
	private int bottomNo; 
	private int gpurchaseNo;
	private int ordersNo;
	private int qty; 
	private String sizes;
	
	private String list[];
	
	public OrderList() {} 
	
	public OrderList(int topsNo, int bottomNo, int gpurchaseNo, int ordersNo, int qty, String sizes) {
		this(0, topsNo, bottomNo, gpurchaseNo, ordersNo, qty, sizes);
	}
	
	public OrderList(int orderListNo, int topsNo, int bottomNo, int gpurchaseNo, int ordersNo, int qty, String sizes) {
		this.orderListNo = orderListNo;
		this.topsNo = topsNo;
		this.bottomNo = bottomNo;
		this.gpurchaseNo = gpurchaseNo;
		this.ordersNo = ordersNo;
		this.qty = qty;
		this.sizes = sizes;
	}
	
	

	public OrderList(int orderListNo, int topsNo, int bottomNo, int gpurchaseNo, int ordersNo, int qty, String sizes,
			String[] list) {
		super();
		this.orderListNo = orderListNo;
		this.topsNo = topsNo;
		this.bottomNo = bottomNo;
		this.gpurchaseNo = gpurchaseNo;
		this.ordersNo = ordersNo;
		this.qty = qty;
		this.sizes = sizes;
		this.list = list;
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

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	
	
	public String[] getList() {
		return list;
	}

	public void setList(String[] list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "OrderList [orderListNo=" + orderListNo + ", topsNo=" + topsNo + ", bottomNo=" + bottomNo
				+ ", gpurchaseNo=" + gpurchaseNo + ", ordersNo=" + ordersNo + ", qty=" + qty + ", sizes=" + sizes
				+ ", list=" + Arrays.toString(list) + "]";
	}

	
	
	

	
}
