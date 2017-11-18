package kr.or.kosta.semicolon.company.domain;

public class Company {
	private int companyNo;
	private String name;
	private String tel;
	
	/** 생성자 */
	
	public Company() { }
	
	public Company( String name, String tel) {
		this(0,name,tel);
	}
	public Company(int companyNo, String name, String tel) {
		super();
		this.companyNo = companyNo;
		this.name = name;
		this.tel = tel;
	}

	/** Getter, Setter */
	
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Company [companyNo=" + companyNo + ", name=" + name + ", tel=" + tel + "]";
	}
	
	
	
}
