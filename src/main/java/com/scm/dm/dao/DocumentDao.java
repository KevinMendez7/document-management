package com.scm.dm.dao;

import java.util.List;

import com.scm.dm.domain.Document;

public interface DocumentDao {
	
	List<Document> getAllDocument();
	
	List<Document> getDocumentBySubcategory(String nameCategory, String nameSubCategory);	
	
	Document getDocumentById(Integer idDocument);
	
	void removeDocumentById(Integer idDocument);
	
	void addDocument(Document document);
	
	void updateDocument(Document document);

}
