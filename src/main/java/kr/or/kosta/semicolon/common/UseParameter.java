package kr.or.kosta.semicolon.common;

/**
 * 페이징에 필요한 파라미터들을 저장하기 위한 자바빈
 * (사용자 요청 페이지, 필요 데이터, 정렬기준)
 */
public class UseParameter {
	private int page;         
	private String value;    
	private String productOrder;
	private int status;
	private int category;
	
	
	public UseParameter() {}
	
	public UseParameter(int page, String productOrder, int status, int category) {
		this(page, null, productOrder, status, category);
	}


	public UseParameter(int page, String value, String productOrder, int status, int category) {
		super();
		this.page = page;
		this.value = value;
		this.productOrder = productOrder;
		this.status = status;
		this.category = category;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getProductOrder() {
		return productOrder;
	}


	public void setProductOrder(String productOrder) {
		this.productOrder = productOrder;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "UseParameter [page=" + page + ", value=" + value + ", productOrder=" + productOrder + ", status="
				+ status + ", category=" + category + "]";
	}
	
	

	
	
	

	
}
