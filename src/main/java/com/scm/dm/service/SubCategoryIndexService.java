package com.scm.dm.service;

import java.util.List;

import com.scm.dm.domain.SubCategoryIndex;

public interface SubCategoryIndexService {
	
	List<SubCategoryIndex> getAllSubCategoryIndex();
	
	SubCategoryIndex getSubCategoryIndexById(Long idSubCategoryIndex); 
	
	void addSubCategoryIndex(SubCategoryIndex subCategoryIndex);
	
	void updateSubCategoryIndex(SubCategoryIndex subCategoryIndex);
	
	void removeSubCategoryIndexById(Long idSubCategoryIndex);

}
