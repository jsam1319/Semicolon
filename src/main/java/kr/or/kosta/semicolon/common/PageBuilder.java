package kr.or.kosta.semicolon.common;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 
 * @packgename   kr.or.kosta.semicolon.common
 * @filename         PageBuilder.java
 * @author          박연주
 * @since            2017. 11. 13.
 * @see			페이징 계산 및 페이지 번호 출력 재사용을 위한 유틸리티 클래스
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE        AUTHOR       NOTE
 * --------      -----------   ---------------------------------------
 * 2017. 11. 12.      kosta         최초 생성
 *
 *
 */

public class PageBuilder {
	
	private Params params;            /** 요청 파라메터 */
	
	private int totalRowCount;        /** 테이블로부터 검색된 행의 수 */
	private int totalPageCount;       /** 연산에 따른 전체페이지 수 */
	private int listNo;               /** 목록 번호 */
	private int currentStartPage;     /** 현재 목록의 시작페이지 번호 */
	private int currentEndPage;       /** 현재 목록의 마지막페이지 번호 */
	private int previousStartPage;    /** 이전 목록의 시작페이지 번호 */
	private int nextStartPage;        /** 다음 목록의 시작페이지 번호 */
	
	
	public PageBuilder() {
		this(null, 0);
	}
	
	/**
	 * @param params           요청 파라메터
	 * @param totalRowCount    검색타입별 검색된 행의 수
	 */
	public PageBuilder(Params params, int totalRowCount ) {
		this.params = params;
		this.totalRowCount = totalRowCount;
	}

	public Params getParams() {
		return params;
	}

	public void setParams(Params params) {
		this.params = params;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getListNo() {
		return listNo;
	}

	public void setListNo(int listNo) {
		this.listNo = listNo;
	}
	
	public int getCurrentStartPage() {
		return currentStartPage;
	}

	public void setCurrentStartPage(int currentStartPage) {
		this.currentStartPage = currentStartPage;
	}

	public int getCurrentEndPage() {
		return currentEndPage;
	}

	public void setCurrentEndPage(int currentEndPage) {
		this.currentEndPage = currentEndPage;
	}

	public int getPreviousStartPage() {
		return previousStartPage;
	}

	public void setPreviousStartPage(int previousStartPage) {
		this.previousStartPage = previousStartPage;
	}

	public int getNextStartPage() {
		return nextStartPage;
	}

	public void setNextStartPage(int nextStartPage) {
		this.nextStartPage = nextStartPage;
	}

	@Override
	public String toString() {
		return "PageBuilder [params=" + params + ", totalRowCount=" + totalRowCount + ", totalPageCount="
				+ totalPageCount + ", listNo=" + listNo + ", currentStartPage=" + currentStartPage + ", currentEndPage="
				+ currentEndPage + ", previousStartPage=" + previousStartPage + ", nextStartPage=" + nextStartPage
				+ "]";
	}

	/** 페이징 계산 */
	public void build(){
		// DB로부터 검색된 행의 수에 따른 전체페이지수 계산
		totalPageCount = (int)Math.ceil((double)totalRowCount / params.getPageSize());
		
		// 목록별 번호
		listNo = (params.getPage() - 1) / params.getPageNum();
		//(1~5): 0, (6~10): 1, (11~15): 2, .....
		
		// 현재 목록의 시작페이지번호와 마지막페이지번호 계산
		currentStartPage = (listNo * params.getPageNum()) + 1;
		currentEndPage = (listNo * params.getPageNum()) + params.getPageNum();
		
		/*
		if (currentStartPage > totalPageCount){
			currentStartPage = currentStartPage - params.getPageNum() + 1;
		}
		*/
		if (currentEndPage > totalPageCount){
			currentEndPage = totalPageCount;
		}
		
		// 이전 목록의 시작페이지 번호 계산
		previousStartPage = currentStartPage - params.getPageNum();
		// 첫번째 목록인 경우 1페이지로 설정
		if (previousStartPage < 0)  previousStartPage = 1;
		
		// 다음 목록의 시작페이지 번호 계산
		nextStartPage = currentStartPage + params.getPageNum();
	}
	
	/** 현재 목록에서 [처음으로] 출력 여부 반환 */
	public boolean isShowFirst() {
		return listNo > 0;
	}
	
	/** 현재 목록에서 [끝으로] 출력 여부 반환 */
	public boolean isShowLast() {
		return currentEndPage < totalPageCount;
	}
	
	/** 현재 목록에서 [이전목록] 출력 여부 반환 */
	public boolean isShowPrevious() {
		return listNo > 0;
	}
	
	/** 현재 목록에서 [다음목록] 출력 여부 반환 */
	public boolean isShowNext() {
		return currentEndPage < totalPageCount;
	}
	
	/** 동적 쿼리스트링 반환 */
	public String getQueryString(int page) {
		String queryString = "?page=" + page;
		// 조건검색이 있는 경우
		queryString += params.getType() != null ? "&type=" + params.getType() + "&value=" + params.getValue()  :  "";
		return queryString;
	}
	
	
	  public String makeQuery(int page) {

		    UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
		        .queryParam("pageNum", params.getPageNum()).build();

		    return uriComponents.toUriString();
		  }
	


	
}
