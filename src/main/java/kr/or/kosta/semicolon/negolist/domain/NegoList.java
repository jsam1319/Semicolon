package kr.or.kosta.semicolon.negolist.domain;
/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.negolist.domain
 * @filename         NegoList.java
 * @author           김미소
 * @since            2017. 11. 29.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 29.      김미소         최초 생성
 *
 *
 */
public class NegoList {
	
	private int negoListNo;
	private int goodsNo;
	private int negoNo;
	private int negoPrice;
	private int negoMin;
	
	private int companyNo;
	
	public NegoList() {}

	public NegoList(int negoListNo, int goodsNo, int negoNo, int negoPrice, int negoMin, int companyNo) {
		super();
		this.negoListNo = negoListNo;
		this.goodsNo = goodsNo;
		this.negoNo = negoNo;
		this.negoPrice = negoPrice;
		this.negoMin = negoMin;
		this.companyNo = companyNo;
	}

	public int getNegoListNo() {
		return negoListNo;
	}

	public void setNegoListNo(int negoListNo) {
		this.negoListNo = negoListNo;
	}

	public int getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}

	public int getNegoNo() {
		return negoNo;
	}

	public void setNegoNo(int negoNo) {
		this.negoNo = negoNo;
	}

	public int getNegoPrice() {
		return negoPrice;
	}

	public void setNegoPrice(int negoPrice) {
		this.negoPrice = negoPrice;
	}

	public int getNegoMin() {
		return negoMin;
	}

	public void setNegoMin(int negoMin) {
		this.negoMin = negoMin;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	@Override
	public String toString() {
		return "NegoList [negoListNo=" + negoListNo + ", goodsNo=" + goodsNo + ", negoNo=" + negoNo + ", negoPrice="
				+ negoPrice + ", negoMin=" + negoMin + ", companyNo=" + companyNo + "]";
	}


}
