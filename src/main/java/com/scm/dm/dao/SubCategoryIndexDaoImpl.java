package com.scm.dm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.dm.domain.SubCategoryIndex;

@Repository
@Transactional
public class SubCategoryIndexDaoImpl extends AbstractSession implements SubCategoryIndexDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SubCategoryIndex> getAllSubCategoryIndex() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from SubCategoryIndex sci "
				+ "join fetch sci.subCategory sc "
				+ "join fetch sc.category c "
				+ "join fetch sc.userAccount ua "
				+ "where sc.idSubCategory = sci.subCategory and "
				+ "sc.category = c.idCategory and "
				+ "sc.userAccount = ua.userId").list();
	}
	
	@Override
	public SubCategoryIndex getSubCategoryIndexById(Long idSubCategoryIndex) {
		// TODO Auto-generated method stub
		return getSession().get(SubCategoryIndex.class, idSubCategoryIndex);
	}

	@Override
	public void addSubCategoryIndex(SubCategoryIndex subCategoryIndex) {
		// TODO Auto-generated method stub
		getSession().persist(subCategoryIndex);
	}

	@Override
	public void updateSubCategoryIndex(SubCategoryIndex subCategoryIndex) {
		// TODO Auto-generated method stub
		getSession().update(subCategoryIndex);
	}

	@Override
	public void removeSubCategoryIndexById(Long idSubCategoryIndex) {
		// TODO Auto-generated method stub
		SubCategoryIndex subCategoryIndex = getSubCategoryIndexById(idSubCategoryIndex);
		
		if(subCategoryIndex != null) {
			
			getSession().delete(subCategoryIndex);
		}
	}

}
