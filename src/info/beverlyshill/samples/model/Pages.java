package com.beverlyshill.samples.model;

/**
 * Model class for Pages table
 * 
 * @author bhill2
 */
public class Pages {
	int pageId;
	String name;
	String textDesc;

	public int getPageId() {
		return this.pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTextDesc() {
		return textDesc;
	}

	public void setTextDesc(String textDesc) {
		this.textDesc = textDesc;
	}
}
