package com.jsp.command;

// 키워드 + 검색기 세트로 가지고 검색하기 위한 클래스
public class Criteria {
	
	private int page=1; // 페이지번호
	private int perPageNum = 10; // 정렬개수
	private String searchType="";
	private String keyword="";
	
	private int startRowNum=0;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page<1) {
			this.page=1;
		}else {
			this.page = page;
		}
		setStartRowNum();
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		if(perPageNum < 1) {
			this.perPageNum = 10;
		}else {
			this.perPageNum = perPageNum;
		}
		setStartRowNum();
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	// 페이지 세팅(종속적으로 작용) -> 안에 있으니까 파라미터도 없음
	// setPage, setPerPage 할때 해야함
	private void setStartRowNum() {
		this.startRowNum=(this.page-1)*perPageNum;		
	}
	public int getStartRowNum() {
		return this.startRowNum;
	}
}






