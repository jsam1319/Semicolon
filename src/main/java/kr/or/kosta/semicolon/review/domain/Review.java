package kr.or.kosta.semicolon.review.domain;

/**
 * @packgename   kr.kosta.semicolon.review.domain
 * @filename         Review.java
 * @author          전세종
 * @since            2017. 11. 15.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 15.      세종         최초 생성
 *
 *
 */
public class Review {
	
	private int reviewNo;
	private int goodsNo;
	private int memberNo;
	private String attachFile;
	private String content;
	private String regdate;
	private int grade;
	
	public Review() {}

	public Review(int reviewNo, int goodsNo, int memberNo, String attachFile, String content, String regdate, int grade) {
		this.reviewNo = reviewNo;
		this.goodsNo = goodsNo;
		this.memberNo = memberNo;
		this.attachFile = attachFile;
		this.content = content;
		this.regdate = regdate;
		this.grade = grade;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", goodsNo=" + goodsNo + ", memberNo=" + memberNo + ", attachFile="
				+ attachFile + ", content=" + content + ", regdate=" + regdate + ", grade=" + grade + "]";
	}

}
