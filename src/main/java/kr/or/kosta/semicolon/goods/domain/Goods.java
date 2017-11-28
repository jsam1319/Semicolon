package kr.or.kosta.semicolon.goods.domain;

/**
 * @packgename   kr.or.kosta.semicolon.goods.domain
 * @filename         Goods.java
 * @author          전세종
 * @since            2017. 11. 10.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 10.      전세종         최초 생성
 * 
 *
 */
public class Goods {
	
	private int goodsNo;
	private String name;
	private int price;
	private String detail;
	private String frontImg;
	private String toggleImg;
	private int category;
	
	public Goods() {}

	public Goods(int goodsNo, String name, int price, String detail, String frontImg, String toggleImg, int category) {
		super();
		this.goodsNo = goodsNo;
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.frontImg = frontImg;
		this.toggleImg = toggleImg;
		this.category = category;
	}

	public int getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
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

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Goods [goodsNo=" + goodsNo + ", name=" + name + ", price=" + price + ", detail=" + detail
				+ ", frontImg=" + frontImg + ", toggleImg=" + toggleImg + ", category=" + category + "]";
	}

	
	
	
}
