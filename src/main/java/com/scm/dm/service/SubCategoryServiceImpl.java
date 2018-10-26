package com.scm.dm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dm.dao.SubCategoryDao;
import com.scm.dm.domain.SubCategory;

@Service("SubCategoryService")
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {
	
	@Autowired
	private SubCategoryDao
	_subCategoryDao; 

	@Override
	public List<SubCategory> getSubCategory() {
		// TODO Auto-generated method stub
		return _subCategoryDao.getSubCategory();
	}

	@Override
	public SubCategory getSubCategoryByName(String name) {
		// TODO Auto-generated method stub
		return _subCategoryDao.getSubCategoryByName(name);
	}

	@Override
	public SubCategory getSubCategoryById(Integer id) {
		// TODO Auto-generated method stub
		return _subCategoryDao.getSubCategoryById(id);
	}

	@Override
	public void addSubCategory(SubCategory subCategory) {
		// TODO Auto-generated method stub
		_subCategoryDao.addSubCategory(subCategory);
	}

	@Override
	public void removeSubCategoryById(Integer id) {
		// TODO Auto-generated method stub
		_subCategoryDao.removeSubCategoryById(id);
	}

	@Override
	public void updateSubCategory(SubCategory subCategory) {
		// TODO Auto-generated method stub
		_subCategoryDao.updateSubCategory(subCategory);
	}

}
