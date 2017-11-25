package kr.or.kosta.semicolon.common.enumtype;

/**
 * @packgename   kr.or.kosta.semicolon.common.enumtype
 * @filename         Category.java
 * @author          jaehyun
 * @since            2017. 11. 24.
 * @see						Category를 분류하기 위한 Enum 
 * 								카테고리 번호와 카테고리에 대한 한글이름 등록
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 24.      jaehyun         최초 생성
 *
 *
 */
public enum Category {
	NOTFOUND(0, "알수없음"),
	
	COAT(110, "코트"),
	JACKET(120, "자켓"),
	ONEPIECE(130, "원피스"), 
	KNIT(140, "니트"),
	SWEATSHIRT(150, "맨투맨"), 
	
	SKIRT(210, "스커트"), 
	SHORTPANTS(220, "반바지"), 
	PANTS(230, "바지");
	
	int categoryNo;
	String koreanName;
	
	Category(int categoryNo, String koreanName) {
		this.categoryNo = categoryNo;
		this.koreanName = koreanName;
	}

	public static Category valueOfNo(int categoryNo) {
		Category[] categories = Category.values();
		
		for (Category category : categories) {
			if(category.categoryNo == categoryNo)
				return category;
		}
		
		return Category.NOTFOUND;
	}
	
	public static Category valueOfKorean(String koreanName) {
		Category[] categories = Category.values();
		
		for (Category category : categories) {
			if(category.koreanName.equals(koreanName))
				return category;
		}
		
		return Category.NOTFOUND;
	}
	
	public int getCategoryNo() {
		return categoryNo;
	}

	public String getKoreanName() {
		return koreanName;
	}
	
	
	/**
	 * <pre>
	 * 1. 개      요 : Enum 사용에 대한 방법 
	 * 2. 처리내용 : Enum 사용에 대한 방법을 적어 놓은 Main Method 입니다. 주석 처리 해주세요!
	 * </pre>
	 * @Method Name : main
	 * @param args
	 */
/*	public static void main(String[] args) {
		 카테고리 Enum으로 부터 이름과 번호 가져오기 
		String name = Category.COAT.koreanName;
		int no = Category.COAT.categoryNo;
		
		 카테고리의 이름으로부터 Enum 가져오기 
		Category category1 = Category.valueOf("COAT");
		Category category2 = Category.valueOfKorean("코트");
		Category category3 = Category.valueOfNo(110);
		
		System.out.println("NAME : " + name);
		System.out.println("NO : " + no);
		
		System.out.println(category1);
		System.out.println(category2);
		System.out.println(category3);
	}*/
}


