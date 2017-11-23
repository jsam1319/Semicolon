package kr.or.kosta.semicolon.chart.domain;

/**
 * @packgename  	 kr.or.kosta.semicolon.chart.domain
 * @filename         Chart.java
 * @author           박주연
 * @since            2017. 11. 21.
 * @see				 회사별로 매출액을 디비에서 추출한 뒤 저장하는 도메인
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 21.       박주연        최초 생성
 *
 *
 */
public class Chart {
	private int companyNo;
	private String name;
	private int sales;
	
	public Chart() { }
	
	public Chart(int companyNo, String name, int sales) {
		super();
		this.companyNo = companyNo;
		this.name = name;
		this.sales = sales;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Chart [companyNo=" + companyNo + ", name=" + name + ", sales=" + sales + "]";
	}
	
}
