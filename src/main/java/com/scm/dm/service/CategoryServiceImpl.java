package com.scm.dm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dm.dao.CategoryDao;
import com.scm.dm.domain.Category;

@Service("CategoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao _categoryDao;

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return _categoryDao.getCategories();
	}

	@Override
	public Category getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return _categoryDao.getCategoryByName(name);
	}

	@Override
	public Category getCategoryById(Integer id) {
		// TODO Auto-generated method stub
		return _categoryDao.getCategoryById(id);
	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		_categoryDao.addCategory(category);
	}

	@Override
	public void removeCategoryById(Integer id) {
		// TODO Auto-generated method stub
		_categoryDao.removeCategoryById(id);
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		_categoryDao.updateCategory(category);
	}

}
