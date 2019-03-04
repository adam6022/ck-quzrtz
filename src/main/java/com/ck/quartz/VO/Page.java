/*
 * Copyright @2007-2008 by Infowarelab Webapps.
 */
package com.ck.quartz.VO;

public class Page {
	public static int PAGE_SIZE = 10;
	public static int MAX_PAGE_SIZE = 50;
	private int pageSize;		//number of records per page
	private int totalPages;
	private int currentPage;	//no. of current page	
	private int beginIndex;		//begin index of the records of current page
	private int totalRecords;

	public Page() {
		this.pageSize = PAGE_SIZE;
		this.totalPages = 1;
		this.currentPage = 1;
		this.beginIndex = 0;
		this.totalRecords = 0;
	}

	public Page(int currentPage, int totalRecords) {
		this(currentPage, PAGE_SIZE, totalRecords);
	}

	public Page(int currentPage, int pageSize, int totalRecords) {
		this.currentPage = (currentPage < 1)? 1 : currentPage;
		this.pageSize = pageSize;
		this.totalRecords = totalRecords;
		
		initPage();
	}
	
	public void initPage() {
		this.totalPages = totalRecords / pageSize + ((totalRecords % pageSize > 0)? 1: 0);
		
		if (this.totalPages < 1) {
			this.totalPages = 1;
		}			
		if (this.currentPage > this.totalPages) {
			this.currentPage = this.totalPages;
		}
		
		this.beginIndex = (this.currentPage - 1) * pageSize;
	}


	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		this.beginIndex = (this.currentPage - 1) * pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}	

    public int getNextPage() {
    	currentPage = (currentPage < totalPages) ? currentPage + 1 : currentPage;
        return currentPage;
    }

    public int getPrevPage() {
    	currentPage = (currentPage > 1) ? currentPage - 1 : currentPage;
        return currentPage;
    }

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
		
		initPage();
	}

	public String toString() {
	    final String tab = "\r\n\t";
	    
	    String retValue = "";
	    
	    retValue = "Page ( "
	        + super.toString() + tab
	        + "pageSize = " + this.pageSize + tab
	        + "totalPages = " + this.totalPages + tab
	        + "currentPage = " + this.currentPage + tab
	        + "beginIndex = " + this.beginIndex + tab
	        + "totalRecords = " + this.totalRecords + tab
	        + " )";
	
	    return retValue;
	}
	
}
