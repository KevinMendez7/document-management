package com.scm.dm.domain;

import java.io.Serializable;
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
@Table(name = "subcategory_index")
public class SubCategoryIndex implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3853289153233934108L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "id_subcategory_index")
	private Long idSubCategoryIndex;
	
	@Column(name = "name_index")
	private String nameIndex;
	
	@Column(name = "type_index")
	private String typeIndex;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY )
	@JoinColumn(name = "id_subcategory")
	private SubCategory subCategory;
	
	@OneToMany(mappedBy = "subCategoryIndex")
	@JsonIgnore
	private Set<DocumentIndex> documentIndex;

	public Long getIdSubCategoryIndex() {
		return idSubCategoryIndex;
	}

	public void setIdSubCategoryIndex(Long idSubCategoryIndex) {
		this.idSubCategoryIndex = idSubCategoryIndex;
	}

	public String getNameIndex() {
		return nameIndex;
	}

	public void setNameIndex(String nameIndex) {
		this.nameIndex = nameIndex;
	}

	public String getTypeIndex() {
		return typeIndex;
	}

	public void setTypeIndex(String typeIndex) {
		this.typeIndex = typeIndex;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSubCategoryIndex == null) ? 0 : idSubCategoryIndex.hashCode());
		result = prime * result + ((nameIndex == null) ? 0 : nameIndex.hashCode());
		result = prime * result + ((subCategory == null) ? 0 : subCategory.hashCode());
		result = prime * result + ((typeIndex == null) ? 0 : typeIndex.hashCode());
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
		SubCategoryIndex other = (SubCategoryIndex) obj;
		if (idSubCategoryIndex == null) {
			if (other.idSubCategoryIndex != null)
				return false;
		} else if (!idSubCategoryIndex.equals(other.idSubCategoryIndex))
			return false;
		if (nameIndex == null) {
			if (other.nameIndex != null)
				return false;
		} else if (!nameIndex.equals(other.nameIndex))
			return false;
		if (subCategory == null) {
			if (other.subCategory != null)
				return false;
		} else if (!subCategory.equals(other.subCategory))
			return false;
		if (typeIndex == null) {
			if (other.typeIndex != null)
				return false;
		} else if (!typeIndex.equals(other.typeIndex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubCategoryIndex [idSubCategoryIndex=" + idSubCategoryIndex + ", nameIndex=" + nameIndex
				+ ", typeIndex=" + typeIndex + ", subCategory=" + subCategory + "]";
	}	

}
