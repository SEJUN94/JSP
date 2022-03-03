package com.jsp.command;

public class PageMaker {
	
	private int totalCount; // ★ 전체 행의 개수(모든 페이지 번호는 totalCount에 있어야 함) = DB에서 오는 데이터
	private int startPage = 1; // 시작 페이지 번호
	private int endPage = 1; // 마지막 페이지 번호
	private int realEndPage; // 끝 페이지 번호
	private boolean prev; // 이전페이지 버튼 유무(endPage-1)
	private boolean next; // 다음페이지 버튼 유무(endPage+1)

	private int displayPageNum = 10; // 한 페이지에 보여줄 페이지번호 개수
	
	// 외부주입
	Criteria cri = new Criteria(); 
	
	// starPage,endPage, prev, next 설정. by totalCount
	private void calcData() {
		// 마지막페이지
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		// 시작페이지					
		startPage = (endPage - displayPageNum) + 1;
		// 화면에 실제로 존재하는 마지막 페이지
		realEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		
		// 시작페이지, 마지막페이지 처리
		if (startPage < 0) {
			startPage = 1;
		}
		if (endPage > realEndPage) {
			endPage = realEndPage;
		}
		
		// 이전/다음 버튼 처리
		prev = startPage == 1 ? false : true;
		next = endPage >= realEndPage ? false : true;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRealEndPage() {
		return realEndPage;
	}

	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
}
