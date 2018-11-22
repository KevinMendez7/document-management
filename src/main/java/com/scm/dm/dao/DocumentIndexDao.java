package com.scm.dm.dao;

import java.util.List;

import com.scm.dm.domain.DocumentIndex;

public interface DocumentIndexDao {
	
	List<DocumentIndex> getAllDocumentIndex();
	
	DocumentIndex getDocumentIndexById(Long idDocumentIndex); 
	
	void addDocumentIndex(DocumentIndex documentIndex);
	
	void updateDocumentIndex(DocumentIndex documentIndex);
	
	void removeDocumentIndexById(Long idDocumentIndex);

}
