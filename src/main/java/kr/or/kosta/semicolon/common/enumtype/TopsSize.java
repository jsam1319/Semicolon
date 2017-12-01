package kr.or.kosta.semicolon.common.enumtype;

/**
 * @packgename  	 kr.or.kosta.semicolon.common.enumtype
 * @filename         TopsSize.java
 * @author           박주연
 * @since            2017. 12. 1.
 * @see				 TopsSize 관리를 위한 enum
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 12. 1.       박주연        최초 생성
 *
 *
 */
public enum TopsSize {
	XS("xs", 1), 
	S("s", 2), 
	M("m", 3), 
	L("l", 4), 
	XL("xl", 5), 
	FREE("free", 6); 
	
	String size;
	int seq;
	
	
	TopsSize(String size, int seq) {
		this.size = size;
		this.seq = seq;
	}
	
	public static int valueOfNo(String size) {
		TopsSize[] topsSizes = TopsSize.values();
		
		for (TopsSize topsSize : topsSizes) {
			if(topsSize.size.equals(size)) {
				return topsSize.seq;
			}
		}//end for
		
		return 0;
	}
}
