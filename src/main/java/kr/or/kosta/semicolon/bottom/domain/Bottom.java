package kr.or.kosta.semicolon.bottom.domain;

import kr.or.kosta.semicolon.common.Clothing;

/**
 * 
 * @packgename  	 kr.or.kosta.semicolon.bottom.domain
 * @filename         Bottom.java
 * @author           김미소
 * @since            2017. 11. 18.
 * @see				 하의 사이즈를 담는 Bottom 테이블의 Domain
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 18.      김미소         최초 생성
 *
 *
 */
public class Bottom  implements Clothing{
	
	private int bottomNo;
	private int goodsNo;
	private String types;
	private String sizes;
	private Double waist;
	private Double rise;
	private Double hip;
	private Double thigh;
	private Double fullLength;
	
	public Bottom() {}

	public Bottom(int bottomNo, int goodsNo, String types, String sizes, Double waist, Double rise, Double hip,
			Double thigh, Double fullLength) {
		super();
		this.bottomNo = bottomNo;
		this.goodsNo = goodsNo;
		this.types = types;
		this.sizes = sizes;
		this.waist = waist;
		this.rise = rise;
		this.hip = hip;
		this.thigh = thigh;
		this.fullLength = fullLength;
	}

	public int getBottomNo() {
		return bottomNo;
	}

	public void setBottomNo(int bottomNo) {
		this.bottomNo = bottomNo;
	}

	public int getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public Double getWaist() {
		return waist;
	}

	public void setWaist(Double waist) {
		this.waist = waist;
	}

	public Double getRise() {
		return rise;
	}

	public void setRise(Double rise) {
		this.rise = rise;
	}

	public Double getHip() {
		return hip;
	}

	public void setHip(Double hip) {
		this.hip = hip;
	}

	public Double getThigh() {
		return thigh;
	}

	public void setThigh(Double thigh) {
		this.thigh = thigh;
	}

	public Double getFullLength() {
		return fullLength;
	}

	public void setFullLength(Double fullLength) {
		this.fullLength = fullLength;
	}

	@Override
	public String toString() {
		return "Bottom [bottomNo=" + bottomNo + ", goodsNo=" + goodsNo + ", types=" + types + ", sizes=" + sizes
				+ ", waist=" + waist + ", rise=" + rise + ", hip=" + hip + ", thigh=" + thigh + ", fullLength="
				+ fullLength + "]";
	}
	

}
