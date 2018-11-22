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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subcategory")
public class SubCategory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7123340322169843553L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_subcategory")
	private Integer idSubCategory;
	
	@Column(name = "code_subcategory")
	private Integer codeSubCategory;
	
	@Column(name = "name_subcategory")
	private String nameSubCategory;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_creation", insertable = false, updatable = false)
	private Date dateCreation;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private Category category;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	private UserAccount userAccount;
	
	@OneToMany(mappedBy = "subCategory")
	@JsonIgnore
	private Set<Document> document;
	
	@OneToMany(mappedBy = "subCategory")
	@JsonIgnore
	private Set<SubCategoryIndex> subCategoryIndex;
	
	public SubCategory() {
		super();
	}

	public Integer getIdSubCategory() {
		return idSubCategory;
	}

	public void setIdSubCategory(Integer idSubCategory) {
		this.idSubCategory = idSubCategory;
	}

	public Integer getCodeSubCategory() {
		return codeSubCategory;
	}

	public void setCodeSubCategory(Integer codeSubCategory) {
		this.codeSubCategory = codeSubCategory;
	}

	public String getNameSubCategory() {
		return nameSubCategory;
	}

	public void setNameSubCategory(String nameSubCategory) {
		this.nameSubCategory = nameSubCategory;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public Set<Document> getDocument() {
		return document;
	}

	public void setDocument(Set<Document> document) {
		this.document = document;
	}	

	public Set<SubCategoryIndex> getSubCategoryIndex() {
		return subCategoryIndex;
	}

	public void setSubCategoryIndex(Set<SubCategoryIndex> subCategoryIndex) {
		this.subCategoryIndex = subCategoryIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeSubCategory == null) ? 0 : codeSubCategory.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((idSubCategory == null) ? 0 : idSubCategory.hashCode());
		result = prime * result + ((nameSubCategory == null) ? 0 : nameSubCategory.hashCode());
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
		SubCategory other = (SubCategory) obj;
		if (codeSubCategory == null) {
			if (other.codeSubCategory != null)
				return false;
		} else if (!codeSubCategory.equals(other.codeSubCategory))
			return false;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (idSubCategory == null) {
			if (other.idSubCategory != null)
				return false;
		} else if (!idSubCategory.equals(other.idSubCategory))
			return false;
		if (nameSubCategory == null) {
			if (other.nameSubCategory != null)
				return false;
		} else if (!nameSubCategory.equals(other.nameSubCategory))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubCategory [idSubCategory=" + idSubCategory + ", codeSubCategory=" + codeSubCategory
				+ ", nameSubCategory=" + nameSubCategory + ", dateCreation=" + dateCreation + "]";
	}
		

}
