package com.scm.dm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.dm.domain.SubCategory;

@Repository
@Transactional
public class SubCategoryDaoImpl extends AbstractSession implements SubCategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SubCategory> getSubCategory() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from SubCategory").list();
	}

	@Override
	public SubCategory getSubCategoryByName(String name) {
		// TODO Auto-generated method stub
		return (SubCategory) getSession().createQuery("from SubCategory where nameSubCategory = :name")
				.setParameter("name", name)
				.uniqueResult();
	}

	@Override
	public SubCategory getSubCategoryById(Integer id) {
		// TODO Auto-generated method stub
		return getSession().get(SubCategory.class, id);
	}

	@Override
	public void addSubCategory(SubCategory subCategory) {
		// TODO Auto-generated method stub
		getSession().persist(subCategory);
	}

	@Override
	public void removeSubCategoryById(Integer id) {
		// TODO Auto-generated method stub
		SubCategory subCategory = getSession().get(SubCategory.class, id);
		
		if(subCategory != null) {
			getSession().delete(subCategory);
		}
	}

	@Override
	public void updateSubCategory(SubCategory subCategory) {
		// TODO Auto-generated method stub
		getSession().update(subCategory);
	}

}
