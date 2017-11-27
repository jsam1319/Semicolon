package kr.or.kosta.semicolon.require.domain;
/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.require.domain
 * @filename         Require.java
 * @author           김미소
 * @since            2017. 11. 24.
 * @see				 사용자가 요청하는 공구에 대한 Domain Class
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 24.      김미소         최초 생성
 *	
 *
 */
public class Require {
	
	private int requireNo;
	private int memberNo;
	private String title;
	private int price;
	private String company;
	private String content;
	private String image;
	private String regdate;
	private String comments;
	
	public Require() {}

	public Require(int requireNo, int memberNo, String title, int price, String company, String content, String image,
			String regdate, String comments) {
		super();
		this.requireNo = requireNo;
		this.memberNo = memberNo;
		this.title = title;
		this.price = price;
		this.company = company;
		this.content = content;
		this.image = image;
		this.regdate = regdate;
		this.comments = comments;
	}

	public int getRequireNo() {
		return requireNo;
	}

	public void setRequireNo(int requireNo) {
		this.requireNo = requireNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Require [requireNo=" + requireNo + ", memberNo=" + memberNo + ", title=" + title + ", price=" + price
				+ ", company=" + company + ", content=" + content + ", image=" + image + ", regdate=" + regdate
				+ ", comments=" + comments + "]";
	}

	

}
