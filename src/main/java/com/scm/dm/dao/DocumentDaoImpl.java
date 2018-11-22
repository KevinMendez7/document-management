package com.scm.dm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.dm.domain.Document;

@Repository
@Transactional
public class DocumentDaoImpl extends AbstractSession implements DocumentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Document> getAllDocument() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Document d "
				+ "join fetch d.subCategory s "
				+ "join fetch s.category c "
				+ "join fetch s.userAccount u "
				+ "join fetch d.DocumentIndex di"
				+ "where d.subCategory = s.idSubCategory and "
				+ "s.category = c.idCategory and "
				+ "s.userAccount = u.userId")
				.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Document> getDocumentBySubcategory(
			String nameCategory, String nameSubCategory){
		// TODO Auto-generated method stub
		return getSession().createQuery("from Document d "
				+ "join fetch d.subCategory s "
				+ "join fetch s.category c "
				+ "where d.subCategory = s.idSubCategory and "
				+ "s.category = c.idCategory and "
				+ "c.nameCategory = :nameCategory and "
				+ "s.nameSubCategory = :nameSubCategory")
				.setParameter("nameCategory", nameCategory)
				.setParameter("nameSubCategory", nameSubCategory).list();
	}	

	@Override
	public Document getDocumentById(Integer idDocument) {
		// TODO Auto-generated method stub		
		return getSession().get(Document.class, idDocument);
	}

	@Override
	public void removeDocumentById(Integer idDocument) {
		// TODO Auto-generated method stub
		Document document = getDocumentById(idDocument);
		if(document != null) {
			
			getSession().delete(document);
			
		}		
	}

	@Override
	public void addDocument(Document document) {
		// TODO Auto-generated method stub
		getSession().persist(document);
	}

	@Override
	public void updateDocument(Document document) {
		// TODO Auto-generated method stub
		getSession().update(document);
	}

}
