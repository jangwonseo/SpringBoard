package org.zerock.domain;

public class PageMaker {
	//DB에서 가져온 전체 글 개수
	private int totalCount;

	//네비게이션바에 표시 될 끝페이지번호와 시작페이지 번호
	private int startPage;
	private int endPage;
	
	//네비게이션 바 양쪽끝에 좌측, 우측 화살표 활성/비활성화 변수
	private boolean prev;
	private boolean next;
	
	//페이지 네이베이션 바에 몇개씩 보여줄것인가 
	private int displayPageNum=10;
	
	//getPage->현재 페이지 번호 , getPerPageNum-> 한페이지당 몇개의 글을 보여줄것인가
	private Criteria cri;
	
	public void setCri(Criteria cri){
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
		
		calcData();
	}
	
	private void calcData(){
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		
		startPage = (endPage-displayPageNum)+1;
		
		int tempEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		
		if(endPage>tempEndPage){
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false:true;
		next = endPage*cri.getPerPageNum() >= totalCount ?false:true;
		
	}
	
	//////////////////////////////////////////////////
	//getter, setter, toString////////////////////////
	//////////////////////////////////////////////////
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

	public int getTotalCount() {
		return totalCount;
	}

	public Criteria getCri() {
		return cri;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
	

	
	
}
