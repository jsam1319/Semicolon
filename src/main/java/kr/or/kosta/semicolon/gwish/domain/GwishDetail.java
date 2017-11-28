package kr.or.kosta.semicolon.gwish.domain;

/**
 * @packgename  	 kr.or.kosta.semicolon.gwish.domain
 * @filename         GwishDetail.java
 * @author           박주연
 * @since            2017. 11. 27.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 27.       박주연        최초 생성
 *
 *
 */
public class GwishDetail {
	
	//8개
	private String img; /** 이미지 경로 */
	private String company; /** 회사이름 */
	private String name;/** 상품명 */
	private String price;/** 공구가격 */
	private String endDate;/** 공구 종료 날짜 */
	private String startDate;/** 공구 시작 날짜 */
	private String regdate; /** 공구찜 날짜 */
	private int gwishNo; /** 공구찜 번호 */
	
	public GwishDetail() {}

	public GwishDetail(String img, String company, String name, String price, String endDate, String startDate,
			String regdate) {
		super();
		this.img = img;
		this.company = company;
		this.name = name;
		this.price = price;
		this.endDate = endDate;
		this.startDate = startDate;
		this.regdate = regdate;
	}



	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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



	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getGwishNo() {
		return gwishNo;
	}

	public void setGwishNo(int gwishNo) {
		this.gwishNo = gwishNo;
	}

	@Override
	public String toString() {
		return "GwishDetail [img=" + img + ", company=" + company + ", name=" + name + ", price=" + price + ", endDate="
				+ endDate + ", startDate=" + startDate + ", regdate=" + regdate + ", gwishNo=" + gwishNo + "]";
	}

}
