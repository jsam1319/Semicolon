package kr.or.kosta.semicolon.keyword.domain;

public class Keyword {

	int keywordNo;
	int goodsNo;
	String keywordName;
	
	public Keyword() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Keyword(int keywordNo, int goodsNo, String keywordName) {
		super();
		this.keywordNo = keywordNo;
		this.goodsNo = goodsNo;
		this.keywordName = keywordName;
	}

	public int getKeywordNo() {
		return keywordNo;
	}

	public void setKeywordNo(int keywordNo) {
		this.keywordNo = keywordNo;
	}

	public int getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getKeywordName() {
		return keywordName;
	}

	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}

	@Override
	public String toString() {
		return "Keyword [keywordNo=" + keywordNo + ", goodsNo=" + goodsNo + ", keywordName=" + keywordName + "]";
	}
}
