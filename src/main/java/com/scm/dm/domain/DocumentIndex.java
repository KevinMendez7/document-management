package com.scm.dm.domain;

import java.io.Serializable;

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
@Table(name = "document_index")
public class DocumentIndex implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -787774295061045207L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_document_index")
	private Long idDocumentIndex;	
	
	@Column(name = "value_")
	private String value;	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "idDocument")
	private Document document;
	
	public DocumentIndex() {
		super();
	}

	public Long getIdDocumentIndex() {
		return idDocumentIndex;
	}

	public void setIdDocumentIndex(Long idDocumentIndex) {
		this.idDocumentIndex = idDocumentIndex;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
		result = prime * result + ((idDocumentIndex == null) ? 0 : idDocumentIndex.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		DocumentIndex other = (DocumentIndex) obj;
		if (idDocumentIndex == null) {
			if (other.idDocumentIndex != null)
				return false;
		} else if (!idDocumentIndex.equals(other.idDocumentIndex))
			return false;	
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DocumentIndex [idDocumentIndex=" + idDocumentIndex + ", "  + ", value=" 
	+ value + "]";
	}
	

}
