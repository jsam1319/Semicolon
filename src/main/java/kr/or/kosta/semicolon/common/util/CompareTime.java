package kr.or.kosta.semicolon.common.util;

import java.util.Calendar;

/**
 * @packgename   kr.or.kosta.semicolon.gpurchase
 * @filename         CompareTime.java
 * @author          박연주
 * @since            2017. 11. 22.
 * @see			DB의 end_date와 현재 날짜를 비교해 과거인지 체크하는 Method
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 22.      박연주         최초 생성
 *
 *
 */
public class CompareTime {
	
	private String currentTime;
	private String standardTime;
	
	private Calendar cal = Calendar.getInstance();
	
	private String year = String.valueOf(cal.get(cal.YEAR));
	private String month = String.valueOf(cal.get(cal.MONTH)+1);
	private String date = String.valueOf(cal.get(cal.DATE));
	
	
	public CompareTime() {
		this(null);
	}
	
	public CompareTime(String standardTime) {
		this.standardTime = standardTime;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public String getStandardTime() {
		return standardTime;
	}

	public void setStandardTime(String standardTime) {
		this.standardTime = standardTime;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String timeCount() {
		// return 변수
		String compare = null;
		
		// 월, 일의 숫자가 10미만일 경우 앞에 0 더해주기
		if (Integer.parseInt(date) < 10) {
			date = "0"+date;
		} else if (Integer.parseInt(month) < 10) {
			month = "0"+month;
		}
		
		// year 형태 변환(2017->17)
		String changeYear[] = year.split("");
		
		year = "";
		for (int i = 2; i < changeYear.length; i++) {
			year += changeYear[i];
		}
		
		// 현재 날짜
		currentTime = year + month + date;
		
		// 비교할 기준 날짜 데이터 -을 기준으로 재조립
		String date[] = standardTime.split("-");
		
		standardTime="";
		
		for (int i = 0; i < date.length; i++) {
			standardTime += date[i];
		}
		
		// 기준 날짜가 현재 날짜보다 과거인지 비교
		if(currentTime.compareTo(standardTime) > 0) {
			compare = "past";
		}
		
		return compare;
	}

}
