package kr.or.kosta.semicolon.common;


public class EnumMain {

	public static void main(String[] args) {
		
		/* ENUM은 그 자체로 public static final 입니다. */
		EnumTest status = EnumTest.FIRST_STEP;
		
		System.out.println(status);
		System.out.println("ENUM.toString() : " + status.toString());
		/* DB 저장 시 Ordinal로 저장 */
		System.out.println("ENUM.ordinal() : " + status.ordinal());
		
		int intStatus = 0;
		
		System.out.println(EnumTest.values()[intStatus]);
		
		String strStatus = "FIRST_STEP";
		
		EnumTest enum1 = EnumTest.valueOf(strStatus);
		System.out.println(enum1);
	}
}
