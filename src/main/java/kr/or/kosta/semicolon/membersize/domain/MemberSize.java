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
	private String waist; /** 허리둘레 */
	private String thigh; /** 허벅지둘레 */
	private String rise; /** 밑위둘레 */
	private String hip; /** 엉덩이둘레 */
	private String pants; /** 바지길이 */
	private String fullLength; /** 총길이 */
	private String skirt; /** 치마길이 */
	private String sleeve; /** 치마길이 */
	private String top; /** 치마길이 */
	private String shorPants; /** 치마길이 */
	
	
	/** 생성자 */
	public MemberSize() { }
	
	public MemberSize(int memberNo, String waist, String thigh, String rise, String hip, String pants,
			String fullLength, String skirt, String sleeve, String top, String shorPants) {
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

	public String getWaist() {
		return waist;
	}

	public void setWaist(String waist) {
		this.waist = waist;
	}

	public String getThigh() {
		return thigh;
	}

	public void setThigh(String thigh) {
		this.thigh = thigh;
	}

	public String getRise() {
		return rise;
	}

	public void setRise(String rise) {
		this.rise = rise;
	}

	public String getHip() {
		return hip;
	}

	public void setHip(String hip) {
		this.hip = hip;
	}

	public String getPants() {
		return pants;
	}

	public void setPants(String pants) {
		this.pants = pants;
	}

	public String getTotalLength() {
		return fullLength;
	}

	public void setTotalLength(String totalLength) {
		this.fullLength = totalLength;
	}

	public String getSkirt() {
		return skirt;
	}

	public void setSkirt(String skirt) {
		this.skirt = skirt;
	}
	
	

	public String getFullLength() {
		return fullLength;
	}

	public void setFullLength(String fullLength) {
		this.fullLength = fullLength;
	}

	public String getSleeve() {
		return sleeve;
	}

	public void setSleeve(String sleeve) {
		this.sleeve = sleeve;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getShorPants() {
		return shorPants;
	}

	public void setShorPants(String shorPants) {
		this.shorPants = shorPants;
	}

	@Override
	public String toString() {
		return "MemberSize [memberNo=" + memberNo + ", waist=" + waist + ", thigh=" + thigh + ", rise=" + rise
				+ ", hip=" + hip + ", pants=" + pants + ", fullLength=" + fullLength + ", skirt=" + skirt + ", sleeve="
				+ sleeve + ", top=" + top + ", shorPants=" + shorPants + "]";
	}
	
}
