package com.scm.dm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dm.dao.DocumentIndexDao;
import com.scm.dm.domain.DocumentIndex;

@Service("DocumentIndexService")
@Transactional
public class DocumentIndexServiceImpl implements DocumentIndexService {
	
	@Autowired
	private DocumentIndexDao _documentIndexDao;

	@Override
	public List<DocumentIndex> getAllDocumentIndex() {
		// TODO Auto-generated method stub
		return _documentIndexDao.getAllDocumentIndex();
	}

	@Override
	public DocumentIndex getDocumentIndexById(Long idDocumentIndex) {
		// TODO Auto-generated method stub
		return _documentIndexDao.getDocumentIndexById(idDocumentIndex);
	}

	@Override
	public void addDocumentIndex(DocumentIndex documentIndex) {
		// TODO Auto-generated method stub
		_documentIndexDao.addDocumentIndex(documentIndex);
	}

	@Override
	public void updateDocumentIndex(DocumentIndex documentIndex) {
		// TODO Auto-generated method stub
		_documentIndexDao.updateDocumentIndex(documentIndex);
	}

	@Override
	public void removeDocumentIndexById(Long idDocumentIndex) {
		// TODO Auto-generated method stub
		_documentIndexDao.removeDocumentIndexById(idDocumentIndex);
	}

}
