package com.scm.dm.service;

import java.util.List;

import com.scm.dm.domain.Category;

public interface CategoryService {
		
	List<Category> getCategories();
	
	Category getCategoryByName(String name);
	
	Category getCategoryById(Integer id);
	
	void addCategory(Category category);
	
	void removeCategoryById(Integer id);
	
	void updateCategory(Category category);

}
