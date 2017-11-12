package kr.or.kosta.semicolon.member.domain;

import java.util.Date;

/**
 * @packgename	kr.or.kosta.semicolon.member.domain
 * @filename			Member.java
 * @author 			JaeHyun
 * @since				2017. 11. 8.
 * @see					Member 테이블의 Damain 클래스
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE		  AUTHOR		 NOTE
 * --------		-----------	---------------------------------------
 * 2017. 11. 8.		JaeHyun	최초 생성
 *
 *
 */
public class Member {

	int memberNo;
	String id;
	String password;
	String email;
	String address;
	String name;	
	String postcode;
	String phone;
	String regdate;
	int age;
	String gender;
	String appToken;
	String sessionId;
	Date sessionLimit;
	String autoLogin ;
	static Date date = new Date(System.currentTimeMillis());
	
	/** 생성자 */
	public Member() {  }

	public Member(String id, String password, String email, String address, String name, String postcode,
			String phone, int age, String gender) {
		
		this(0,id,password,email,address,name,postcode,phone,null,age,gender,null,null,date,null);
	}
	
	public Member(int memberNo, String id, String password, String email, String address, String name, String postcode,
			String phone, String regdate, int age, String gender, String appToken, String sessionId,
			Date sessionLimit, String autoLogin) {
		this.memberNo = memberNo;
		this.id = id;
		this.password = password;
		this.email = email;
		this.address = address;
		this.name = name;
		this.postcode = postcode;
		this.phone = phone;
		this.regdate = regdate;
		this.age = age;
		this.gender = gender;
		this.appToken = appToken;
		this.sessionId = sessionId;
		this.sessionLimit = sessionLimit;
		this.autoLogin = autoLogin;
	}

	/** Getter, Setter */
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAppToken() {
		return appToken;
	}

	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getSessionLimit() {
		return sessionLimit;
	}

	public void setSessionLimit(Date sessionLimit) {
		this.sessionLimit = sessionLimit;
	}

	
	public String getAutoLogin() {
		return autoLogin;
	}

	public void setAutoLogin(String autoLogin) {
		this.autoLogin = autoLogin;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", id=" + id + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", name=" + name + ", postcode=" + postcode + ", phone=" + phone
				+ ", regdate=" + regdate + ", age=" + age + ", gender=" + gender + ", appToken=" + appToken
				+ ", sessionId=" + sessionId + ", sessionLimit=" + sessionLimit + ", autoLogin=" + autoLogin + "]";
	}

}
