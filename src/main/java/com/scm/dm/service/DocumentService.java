package com.scm.dm.service;

import java.util.List;

import com.scm.dm.domain.Document;

public interface DocumentService {
	
	List<Document> getAllDocument();
	
	Document getDocumentById(Integer idDocument);
	
	void removeDocumentById(Integer idDocument);
	
	void addDocument(Document document);
	
	void updateDocument(Document document);

}
