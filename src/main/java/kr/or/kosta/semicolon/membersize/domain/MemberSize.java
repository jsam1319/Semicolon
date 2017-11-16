package kr.or.kosta.semicolon.membersize.domain;

/**
 * @packgename  	 kr.or.kosta.semicolon.membersize.domain
 * @filename         MemberSize.java
 * @author           박주연
 * @since            2017. 11. 16.
 * @see
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 16.     박주연     최초 생성
 *
 *
 */
public class MemberSize {
	
	private int memberNo; /** 회원번호 */
	private double waist; /** 허리둘레 */
	private double thigh; /** 허벅지둘레 */
	private double rise; /** 밑위둘레 */
	private double hip; /** 엉덩이둘레 */
	private double pants; /** 바지길이 */
	private double totalLength; /** 총길이 */
	
	/** 생성자 */
	public MemberSize() { }
	
	public MemberSize(double waist, double thigh, double rise, double hip, double pants, double totalLength) {
		this(0, waist, thigh, rise, hip, pants, totalLength);
	}
	
	public MemberSize(int memberNo, double waist, double thigh, double rise, double hip, double pants,
			double totalLength) {
		this.memberNo = memberNo;
		this.waist = waist;
		this.thigh = thigh;
		this.rise = rise;
		this.hip = hip;
		this.pants = pants;
		this.totalLength = totalLength;
	}
	
	/** Getter, Setter */

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public double getWaist() {
		return waist;
	}

	public void setWaist(double waist) {
		this.waist = waist;
	}

	public double getThigh() {
		return thigh;
	}

	public void setThigh(double thigh) {
		this.thigh = thigh;
	}

	public double getRise() {
		return rise;
	}

	public void setRise(double rise) {
		this.rise = rise;
	}

	public double getHip() {
		return hip;
	}

	public void setHip(double hip) {
		this.hip = hip;
	}

	public double getPants() {
		return pants;
	}

	public void setPants(double pants) {
		this.pants = pants;
	}

	public double getTotalLength() {
		return totalLength;
	}

	public void setTotalLength(double totalLength) {
		this.totalLength = totalLength;
	}

	@Override
	public String toString() {
		return "MemberSize [memberNo=" + memberNo + ", waist=" + waist + ", thigh=" + thigh + ", rise=" + rise
				+ ", hip=" + hip + ", pants=" + pants + ", totalLength=" + totalLength + "]";
	}
	
}
