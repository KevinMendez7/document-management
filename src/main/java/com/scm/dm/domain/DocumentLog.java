package com.scm.dm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "document_log")
public class DocumentLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4728390929595564436L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_document_log")
	private Long idDocumentLog;
	
	@Column(name = "date_creation")
	private Date dateCreation;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")	
	private UserAccount userAccount;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "idDocument")
	private Document document;
		
	public DocumentLog() {
		super();
	}
	
	public Long getIdDocumentLog() {
		return idDocumentLog;
	}
		
	public void setIdDocumentLog(Long idDocumentLog) {
		this.idDocumentLog = idDocumentLog;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}	
	
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((idDocumentLog == null) ? 0 : idDocumentLog.hashCode());
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
		DocumentLog other = (DocumentLog) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (idDocumentLog == null) {
			if (other.idDocumentLog != null)
				return false;
		} else if (!idDocumentLog.equals(other.idDocumentLog))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DocumentLog [idDocumentLog=" + idDocumentLog + ", dateCreation=" + dateCreation + "]";
	}
	
	
	
}
