package com.scm.dm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.dm.domain.DocumentIndex;

@Repository
@Transactional
public class DocumentIndexDaoImpl extends AbstractSession implements DocumentIndexDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentIndex> getAllDocumentIndex() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from DocumentIndex di "
				+ "join fetch di.document d "
				+ "join fetch di.subCategoryIndex sci "
				+ "where di.document = d.idDocument and "
				+ "di.subCategoryIndex = sci.idSubCategoryIndex").list();
	}

	@Override
	public DocumentIndex getDocumentIndexById(Long idDocumentIndex) {
		// TODO Auto-generated method stub
		return getSession().get(DocumentIndex.class, idDocumentIndex);
	}

	@Override
	public void addDocumentIndex(DocumentIndex documentIndex) {
		// TODO Auto-generated method stub
		getSession().persist(documentIndex);
	}

	@Override
	public void updateDocumentIndex(DocumentIndex documentIndex) {
		// TODO Auto-generated method stub
		getSession().update(documentIndex);
	}

	@Override
	public void removeDocumentIndexById(Long idDocumentIndex) {
		// TODO Auto-generated method stub
		DocumentIndex documentIndex = getSession().get(DocumentIndex.class, idDocumentIndex);
		
		if(documentIndex != null) {
			
			getSession().delete(documentIndex);
			
		}
	}

}
