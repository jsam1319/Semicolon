package kr.or.kosta.semicolon.member.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @packgename			kr.or.kosta.semicolon.member.domain
 * @filename			Member.java
 * @author 				박주연
 * @since				2017. 11. 8.
 * @see					Member 테이블의 Damain 클래스
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE		  AUTHOR		 NOTE
 * --------		-----------	---------------------------------------
 * 2017. 11. 8.		JaeHyun		최초 생성
 * 2017. 11. 14		박주연		authorities 추가
 * 2017. 11. 15		박주연		isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled, publicEncoded, privateEncoded 추가
 *
 */
public class Member implements UserDetails{

	
	int memberNo; /** 회원번호 */
	String id; /** 아이디 */
	String password; /** 비밀번호 */
	String email; /** 이메일 */
	String address; /** 주소 */
	String name; /** 이름 */	
	String postcode; /** 우편번호 */
	String phone; /** 휴대폰 번호 */
	String regdate; /** 가입날짜 */
	int age; /** 나이 */
	String gender; /** 성별 */
	String appToken; /** 앱 토큰 */
	String sessionId; /** 세션 아이디 */
	Date sessionLimit; /** 세션 만료되는 날짜 */
	String autoLogin ; /** 자동로그인이 선택되었는지 확인하는 변수 */
	boolean isAccountNonExpired; /** 계정 만료 되었는지 확인하는 변수 */
	boolean isAccountNonLocked; /** 계정 잠겼는지 확인하는 변수 */
	boolean isCredentialsNonExpired; /** 패스워드 만료되었는지 확인하는 변수 */
	boolean isEnabled; /** 계정활성화 되었는지 확인하는 변수 */
	String publicEncoded; /** publicKey 인코딩 변수 */
	String privateEncoded; /** privateKey 인코딩 변수  */
	
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
	public String getUsername() {
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getPublicEncoded() {
		return publicEncoded;
	}

	public void setPublicEncoded(String publicEncoded) {
		this.publicEncoded = publicEncoded;
	}

	public String getPrivateEncoded() {
		return privateEncoded;
	}

	public void setPrivateEncoded(String privateEncoded) {
		this.privateEncoded = privateEncoded;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", id=" + id + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", name=" + name + ", postcode=" + postcode + ", phone=" + phone
				+ ", regdate=" + regdate + ", age=" + age + ", gender=" + gender + ", appToken=" + appToken
				+ ", sessionId=" + sessionId + ", sessionLimit=" + sessionLimit + ", autoLogin=" + autoLogin
				+ ", isAccountNonExpired=" + isAccountNonExpired + ", isAccountNonLocked=" + isAccountNonLocked
				+ ", isCredentialsNonExpired=" + isCredentialsNonExpired + ", isEnabled=" + isEnabled
				+ ", publicEncoded=" + publicEncoded + ", privateEncoded="
				+ privateEncoded + "]";
	}
}
