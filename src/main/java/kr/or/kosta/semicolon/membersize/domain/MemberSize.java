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
	private double fullLength; /** 총길이 */
	private double skirt; /** 치마길이 */
	private double sleeve; /** 치마길이 */
	private double top; /** 치마길이 */
	private double shorPants; /** 치마길이 */
	
	
	/** 생성자 */
	public MemberSize() { }
	
	public MemberSize(int memberNo, double waist, double thigh, double rise, double hip, double pants,
			double fullLength, double skirt, double sleeve, double top, double shorPants) {
		super();
		this.memberNo = memberNo;
		this.waist = waist;
		this.thigh = thigh;
		this.rise = rise;
		this.hip = hip;
		this.pants = pants;
		this.fullLength = fullLength;
		this.skirt = skirt;
		this.sleeve = sleeve;
		this.top = top;
		this.shorPants = shorPants;
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
		return fullLength;
	}

	public void setTotalLength(double totalLength) {
		this.fullLength = totalLength;
	}

	public double getSkirt() {
		return skirt;
	}

	public void setSkirt(double skirt) {
		this.skirt = skirt;
	}
	
	

	public double getFullLength() {
		return fullLength;
	}

	public void setFullLength(double fullLength) {
		this.fullLength = fullLength;
	}

	public double getSleeve() {
		return sleeve;
	}

	public void setSleeve(double sleeve) {
		this.sleeve = sleeve;
	}

	public double getTop() {
		return top;
	}

	public void setTop(double top) {
		this.top = top;
	}

	public double getShorPants() {
		return shorPants;
	}

	public void setShorPants(double shorPants) {
		this.shorPants = shorPants;
	}

	@Override
	public String toString() {
		return "MemberSize [memberNo=" + memberNo + ", waist=" + waist + ", thigh=" + thigh + ", rise=" + rise
				+ ", hip=" + hip + ", pants=" + pants + ", fullLength=" + fullLength + ", skirt=" + skirt + ", sleeve="
				+ sleeve + ", top=" + top + ", shorPants=" + shorPants + "]";
	}
	
}
