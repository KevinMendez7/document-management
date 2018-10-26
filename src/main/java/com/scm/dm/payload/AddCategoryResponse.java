package com.scm.dm.payload;

public class AddCategoryResponse {
	
	private String reason;
	private String category;
	
	public AddCategoryResponse(String reason, String category) {
		super();
		this.reason = reason;
		this.category = category;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}	

}
