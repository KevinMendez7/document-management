package com.scm.dm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "document")
public class Document implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1734357173555921442L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_document")
	private Long idDocument;	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_subcategory")	
	private SubCategory subCategory;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	private UserAccount userAccount;
	
	@OneToMany(mappedBy = "document")
	@JsonIgnore
	private Set<DocumentComment> DocumentComment;
	
	@JsonIgnore
	@OneToMany(mappedBy = "document", fetch = FetchType.LAZY)
	private Set<DocumentFile> DocumentFile;
	
	@OneToMany(mappedBy = "document")
	@JsonIgnore
	private Set<DocumentIndex> DocumentIndex;
	
	@OneToMany(mappedBy = "document")
	@JsonIgnore
	private Set<DocumentLog> DocumentLog;
	
	@Column(name = "date_creation")
	private Date dateCreation;
	
	public Document() {
		super();
	}

	public Long getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}	

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public Set<DocumentComment> getDocumentComment() {
		return DocumentComment;
	}

	public void setDocumentComment(Set<DocumentComment> documentComment) {
		DocumentComment = documentComment;
	}

	public Set<DocumentFile> getDocumentFile() {
		return DocumentFile;
	}

	public void setDocumentFile(Set<DocumentFile> documentFile) {
		DocumentFile = documentFile;
	}

	public Set<DocumentIndex> getDocumentIndex() {
		return DocumentIndex;
	}

	public void setDocumentIndex(Set<DocumentIndex> documentIndex) {
		DocumentIndex = documentIndex;
	}

	public Set<DocumentLog> getDocumentLog() {
		return DocumentLog;
	}

	public void setDocumentLog(Set<DocumentLog> documentLog) {
		DocumentLog = documentLog;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((idDocument == null) ? 0 : idDocument.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (idDocument == null) {
			if (other.idDocument != null)
				return false;
		} else if (!idDocument.equals(other.idDocument))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Document [idDocument=" + idDocument + ", dateCreation=" + dateCreation + "]";
	}	

}
