package com.scm.dm.dao;

import java.util.List;

import com.scm.dm.domain.SubCategoryIndex;

public interface SubCategoryIndexDao {
	
	List<SubCategoryIndex> getAllSubCategoryIndex();
	
	SubCategoryIndex getSubCategoryIndexById(Long idSubCategoryIndex); 
	
	void addSubCategoryIndex(SubCategoryIndex subCategoryIndex);
	
	void updateSubCategoryIndex(SubCategoryIndex subCategoryIndex);
	
	void removeSubCategoryIndexById(Long idSubCategoryIndex);

}
