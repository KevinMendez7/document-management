package com.scm.dm.service;

import java.util.List;

import com.scm.dm.domain.DocumentIndex;

public interface DocumentIndexService {
	
	List<DocumentIndex> getAllDocumentIndex();
	
	DocumentIndex getDocumentIndexById(Long idDocumentIndex); 
	
	void addDocumentIndex(DocumentIndex documentIndex);
	
	void updateDocumentIndex(DocumentIndex documentIndex);
	
	void removeDocumentIndexById(Long idDocumentIndex);

}
