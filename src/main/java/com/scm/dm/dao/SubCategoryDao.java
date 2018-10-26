package com.scm.dm.dao;

import java.util.List;

import com.scm.dm.domain.SubCategory;

public interface SubCategoryDao {
	
	List<SubCategory> getSubCategory();
	
	SubCategory getSubCategoryByName(String name);
	
	SubCategory getSubCategoryById(Integer id);
	
	void addSubCategory(SubCategory subCategory);
	
	void removeSubCategoryById(Integer id);
	
	void updateSubCategory(SubCategory subCategory);

}
