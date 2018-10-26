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
@Table(name = "document_file")
public class DocumentFile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3465323754447188557L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_document_file")
	private Long idDocumentFile;
	
	@Column(name = "version")
	private Integer version;
	
	@Column(name = "file_path")
	private String filePath;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserAccount userAccount;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "idDocument")
	private Document document;
	
	@Column(name = "date_creation")
	private Date dateCreation;
	
	public DocumentFile() {
		super();
	}

	public Long getIdDocumentFile() {
		return idDocumentFile;
	}

	public void setIdDocumentFile(Long idDocumentFile) {
		this.idDocumentFile = idDocumentFile;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + ((idDocumentFile == null) ? 0 : idDocumentFile.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		DocumentFile other = (DocumentFile) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (idDocumentFile == null) {
			if (other.idDocumentFile != null)
				return false;
		} else if (!idDocumentFile.equals(other.idDocumentFile))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DocumentFile [idDocumentFile=" + idDocumentFile + ", version=" + version + ", filePath=" + filePath
				+ ", dateCreation=" + dateCreation + "]";
	}
		
}
