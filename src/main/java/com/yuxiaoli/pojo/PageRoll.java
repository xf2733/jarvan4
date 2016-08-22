package com.yuxiaoli.pojo;

public class PageRoll {
	private int currPage=1;//��ǰҳ��
	private int pageSize=10;//ÿҳ�ļ�¼��
	private int pageCount;//��ҳ��
	private int totalCount;//�ܼ�¼��
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		if(totalCount%pageSize==0){
			pageCount=totalCount/pageSize;
		}else{
			pageCount=totalCount/pageSize+1;
		}
		return pageCount;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
