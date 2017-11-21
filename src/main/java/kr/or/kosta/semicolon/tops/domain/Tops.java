package kr.or.kosta.semicolon.tops.domain;

import kr.or.kosta.semicolon.common.Clothing;
 
public class Tops implements Clothing{
	
	private int topsNo;
	private int goodsNo;
	private String types;
	private String sizes;
	private double sleeveLength;
	private double fullLength;
	
	public Tops() {}

	public Tops(int topsNo, int goodsNo, String types, String sizes, Double sleeveLength, Double fullLength) {
		super();
		this.topsNo = topsNo;
		this.goodsNo = goodsNo;
		this.types = types;
		this.sizes = sizes;
		this.sleeveLength = sleeveLength;
		this.fullLength = fullLength;
	}
	
	public int getTopsNo() {
		return topsNo;
	}

	public void setTopsNo(int topsNo) {
		this.topsNo = topsNo;
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

	public Double getSleeveLength() {
		return sleeveLength;
	}

	public void setSleeveLength(Double sleeveLength) {
		this.sleeveLength = sleeveLength;
	}

	public Double getFullLength() {
		return fullLength;
	}

	public void setFullLength(Double fullLength) {
		this.fullLength = fullLength;
	}

	@Override
	public String toString() {
		return "Tops [topsNo=" + topsNo + ", goodsNo=" + goodsNo + ", types=" + types + ", sizes=" + sizes
				+ ", sleeveLength=" + sleeveLength + ", fullLength=" + fullLength + "]";
	}
	
	
	
	
	
	
	
	

}
