package com.scm.dm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dm.dao.SubCategoryIndexDao;
import com.scm.dm.domain.SubCategoryIndex;

@Service("SubCategoryIndexService")
@Transactional
public class SubCategoryIndexServiceImpl implements SubCategoryIndexService {
	
	@Autowired
	private SubCategoryIndexDao _subCategoryIndexDao;

	@Override
	public List<SubCategoryIndex> getAllSubCategoryIndex() {
		// TODO Auto-generated method stub
		return _subCategoryIndexDao.getAllSubCategoryIndex();
	}

	@Override
	public SubCategoryIndex getSubCategoryIndexById(Long idSubCategoryIndex) {
		// TODO Auto-generated method stub
		return _subCategoryIndexDao.getSubCategoryIndexById(idSubCategoryIndex);
	}

	@Override
	public void addSubCategoryIndex(SubCategoryIndex subCategoryIndex) {
		// TODO Auto-generated method stub
		_subCategoryIndexDao.addSubCategoryIndex(subCategoryIndex);
	}

	@Override
	public void updateSubCategoryIndex(SubCategoryIndex subCategoryIndex) {
		// TODO Auto-generated method stub
		_subCategoryIndexDao.updateSubCategoryIndex(subCategoryIndex);
	}

	@Override
	public void removeSubCategoryIndexById(Long idSubCategoryIndex) {
		// TODO Auto-generated method stub
		_subCategoryIndexDao.removeSubCategoryIndexById(idSubCategoryIndex);
	}

}
