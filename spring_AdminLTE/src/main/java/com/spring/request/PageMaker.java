package com.spring.request;

public class PageMaker {

	private int totalCount;			// 전체 board 개수
	private int startPage = 1;		// 시작 페이지 번호
	private int endPage = 1;		// 마지막 페이지 번호
	private int realEndPage;		// 끝 페이지 번호
	private	boolean prev;			// 이전페이지 페이지 버튼 유무
	private boolean next;			// 다음페이지 페이지 버튼 유무
	
	private int displayPageNum = 10; // 한 페이지에 보여줄 페이지번호 개수
	
	private SearchCriteria cri;		// 현재 페이지 정보
	
	private void calData() {		//시작페이지, 끝페이지, 최종페이지, 이전, 다음 버튼 설정
		endPage = (int) (Math.ceil(cri.getPage()/(double) displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		realEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		
		if(startPage <0) {
			startPage = 1;
		}
		
		if (endPage > realEndPage) {
			endPage = realEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}
	
	public String makeQuery() {
		return makeQuery(cri.getPage());
	}
	public String makeQuery(int page) {
		String query = "?page="+page+"&perPageNum="+cri.getPerPageNum()
						+"&searchType="+cri.getSearchType()
						+"&keyword="+cri.getKeyword();
		
		return query;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calData();					// 전체 board 개수를 정해주면 메서드 실행
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

	public SearchCriteria getCri() {
		return cri;
	}

	public void setCri(SearchCriteria cri) {
		this.cri = cri;
	}
	
	
}
