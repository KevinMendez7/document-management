package com.scm.dm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.dm.domain.Category;

@Repository
@Transactional
public class CategoryDaoImpl extends AbstractSession implements CategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Category").list();
	}

	@Override
	public Category getCategoryByName(String nameCategory) {
		// TODO Auto-generated method stub
		return (Category) getSession().createQuery("from Category where nameCategory = :nameCategory")
				.setParameter("nameCategory", nameCategory)
				.uniqueResult();
	}

	@Override
	public Category getCategoryById(Integer id) {
		// TODO Auto-generated method stub
		return getSession().get(Category.class, id);
	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		getSession().persist(category);
	}

	@Override
	public void removeCategoryById(Integer id) {
		// TODO Auto-generated method stub
		Category category = getCategoryById(id);
		if(category!=null) {
			getSession().delete(category);
		}
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		getSession().update(category);
	}

}
