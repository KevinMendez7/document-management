package com.scm.dm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dm.dao.DocumentDao;
import com.scm.dm.domain.Document;

@Service("DocumentService")
@Transactional
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	private DocumentDao _documentService;

	@Override
	public List<Document> getAllDocument() {
		// TODO Auto-generated method stub
		return _documentService.getAllDocument();
	}

	@Override
	public Document getDocumentById(Integer idDocument) {
		// TODO Auto-generated method stub
		return _documentService.getDocumentById(idDocument);
	}

	@Override
	public void removeDocumentById(Integer idDocument) {
		// TODO Auto-generated method stub
		_documentService.removeDocumentById(idDocument);
	}

	@Override
	public void addDocument(Document document) {
		// TODO Auto-generated method stub
		_documentService.addDocument(document);
	}

	@Override
	public void updateDocument(Document document) {
		// TODO Auto-generated method stub
		_documentService.updateDocument(document);
	}
	
	

}
