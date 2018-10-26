package com.scm.dm.service;

import java.util.List;

import com.scm.dm.domain.SubCategory;

public interface SubCategoryService {
	
	List<SubCategory> getSubCategory();
	
	SubCategory getSubCategoryByName(String name);
	
	SubCategory getSubCategoryById(Integer id);
	
	void addSubCategory(SubCategory subCategory);
	
	void removeSubCategoryById(Integer id);
	
	void updateSubCategory(SubCategory subCategory);

}
