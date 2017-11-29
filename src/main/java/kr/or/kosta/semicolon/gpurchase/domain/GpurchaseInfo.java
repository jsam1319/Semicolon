package kr.or.kosta.semicolon.gpurchase.domain;

public class GpurchaseInfo {
	
	private int goodsNo;
	private int category;
	private String gname;
	private String detail;
	private String frontImg;
	private String toggleImg;
	private int gpurchaseNo;
	private int min;
	private String endDate;
	private String startDate;
	private int price;
	private int likecnt;
	private int status;
	private int pnum;
	private String cname;
	
	
	public GpurchaseInfo() {}


	public GpurchaseInfo(int goodsNo, int category, String gname, String detail, String frontImg, String toggleImg,
			int gpurchaseNo, int min, String endDate, String startDate, int price, int likecnt, int status, int pnum,
			String cname) {
		super();
		this.goodsNo = goodsNo;
		this.category = category;
		this.gname = gname;
		this.detail = detail;
		this.frontImg = frontImg;
		this.toggleImg = toggleImg;
		this.gpurchaseNo = gpurchaseNo;
		this.min = min;
		this.endDate = endDate;
		this.startDate = startDate;
		this.price = price;
		this.likecnt = likecnt;
		this.status = status;
		this.pnum = pnum;
		this.cname = cname;
	}


	public int getGoodsNo() {
		return goodsNo;
	}


	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}


	public String getGname() {
		return gname;
	}


	public void setGname(String gname) {
		this.gname = gname;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public String getFrontImg() {
		return frontImg;
	}


	public void setFrontImg(String frontImg) {
		this.frontImg = frontImg;
	}


	public String getToggleImg() {
		return toggleImg;
	}


	public void setToggleImg(String toggleImg) {
		this.toggleImg = toggleImg;
	}


	public int getGpurchaseNo() {
		return gpurchaseNo;
	}


	public void setGpurchaseNo(int gpurchaseNo) {
		this.gpurchaseNo = gpurchaseNo;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getLikecnt() {
		return likecnt;
	}


	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getPnum() {
		return pnum;
	}


	public void setPnum(int pnum) {
		this.pnum = pnum;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	@Override
	public String toString() {
		return "GpurchaseInfo [goodsNo=" + goodsNo + ", category=" + category + ", gname=" + gname + ", detail="
				+ detail + ", frontImg=" + frontImg + ", toggleImg=" + toggleImg + ", gpurchaseNo=" + gpurchaseNo
				+ ", min=" + min + ", endDate=" + endDate + ", startDate=" + startDate + ", price=" + price
				+ ", likecnt=" + likecnt + ", status=" + status + ", pnum=" + pnum + ", cname=" + cname + "]";
	}
	
	
	
 
	
	
}
