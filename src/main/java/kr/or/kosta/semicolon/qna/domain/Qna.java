package kr.or.kosta.semicolon.qna.domain;

/**
 * @packgename   kr.or.kosta.semicolon.qna.domain
 * @filename         Qna.java
 * @author          전세종
 * @since            2017. 11. 13.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 13.      세종         최초 생성
 *
 *
 */
public class Qna {
	private int qnaNo; 		
	private int goodsNo;   
	private int memberNo; 
	private String title; 	
	private String content; 
	private String answerContent; 
	private String status; 	
	private String regdate;
	
	public Qna() {}

	public Qna(int qnaNo, int goodsNo, int memberNo, String title, String content, String answerContent, String status,
			String regdate) {
		this.qnaNo = qnaNo;
		this.goodsNo = goodsNo;
		this.memberNo = memberNo;
		this.title = title;
		this.content = content;
		this.answerContent = answerContent;
		this.status = status;
		this.regdate = regdate;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Qna [qnaNo=" + qnaNo + ", goodsNo=" + goodsNo + ", memberNo=" + memberNo + ", title=" + title
				+ ", content=" + content + ", answerContent=" + answerContent + ", status=" + status + ", regdate="
				+ regdate + "]";
	}	
	
}
