package kr.or.kosta.semicolon.common;

public class KeywordParameter {
	
	int page;
	int status;
	String keywordName;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getKeywordName() {
		return keywordName;
	}
	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}
	public KeywordParameter(int page, int status, String keywordName) {
		super();
		this.page = page;
		this.status = status;
		this.keywordName = keywordName;
	}
	public KeywordParameter() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "KeywordParameter [page=" + page + ", status=" + status + ", keywordName=" + keywordName + "]";
	}
	
}
