package kr.or.kosta.semicolon.orders.domain;

public class OrderListVal {
	private int ordersNo;/** 주문번호 */
	private String img;/** 이미지 경로 */
	private String sizes;/** 사이즈 */
	private String name; /** 상품명 */
	private int unitPrice; /** 개별 가격 */
	private int totalPrice; /** 총 가격 */
	private int qty; /** 갯수 */
	private String status; /** 주문상태 */
	
	public OrderListVal() { }
	
	public OrderListVal(int ordersNo, String img, String sizes, String name, int unitPrice, int totalPrice, int qty,
			String status) {
		super();
		this.ordersNo = ordersNo;
		this.img = img;
		this.sizes = sizes;
		this.name = name;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.qty = qty;
		this.status = status;
	}

	public int getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(int ordersNo) {
		this.ordersNo = ordersNo;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrdersList [ordersNo=" + ordersNo + ", img=" + img + ", sizes=" + sizes + ", name=" + name
				+ ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + ", qty=" + qty + ", status=" + status
				+ "]";
	}
	
}
