package com.scm.dm.payload;

public class AddSubCategoryResponse {
	
	private String reason;
	private String subCategory;
	
	public AddSubCategoryResponse(String reason, String subCategory) {
		super();
		this.reason = reason;
		this.subCategory = subCategory;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}	

}
