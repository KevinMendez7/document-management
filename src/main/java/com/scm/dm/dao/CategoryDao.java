package com.scm.dm.dao;

import java.util.List;

import com.scm.dm.domain.Category;

public interface CategoryDao {
	
	List<Category> getCategories();
		
	Category getCategoryByName(String nameCategory);
	
	Category getCategoryById(Integer id);
	
	void addCategory(Category category);
	
	void removeCategoryById(Integer id);
	
	void updateCategory(Category category);

}
