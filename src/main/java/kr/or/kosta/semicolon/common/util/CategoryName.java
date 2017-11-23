package kr.or.kosta.semicolon.common.util;

import kr.or.kosta.semicolon.common.enumtype.Category;

/**
 * @packgename  	 kr.or.kosta.semicolon.common.util
 * @filename         CategoryName.java
 * @author           박주연
 * @since            2017. 11. 23.
 * @see				 카테고리 enum 반환 
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 23.       박주연        최초 생성
 *
 *
 */
public class CategoryName {
	public Category getCategoryName(int no) {
			switch(no) {
			case 110:
				return Category.COAT;
			case 120:
				return Category.JACKET;
			case 130:
				return Category.ONEPIECE;
			case 140:
				return Category.KNIT;
			case 150:
				return Category.SWEATSHIRT;
			case 210:
				return Category.SKIRT;
			case 220:
				return Category.SHORTPANTS;
			case 230:
				return Category.PANTS;
			default:
				return null;
		}
	}
}
