package com.scm.dm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "category")
public class Category implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2524971074855023086L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_category")
	private Integer idCategory;
	
	@Column(name = "code_category")
	private Integer codeCategory;
	
	@Column(name = "name_category")
	private String nameCategory;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_creation", insertable = false, updatable = false)
	private Date dateCreation;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name="id_user")	
	private UserAccount userAccount;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Set<SubCategory> subCategory;
	
	public Category() {
		
	}
	
	public Integer getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}
	public Integer getCodeCategory() {
		return codeCategory;
	}
	public void setCodeCategory(Integer codeCategory) {
		this.codeCategory = codeCategory;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
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

	public Set<SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Set<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeCategory == null) ? 0 : codeCategory.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((idCategory == null) ? 0 : idCategory.hashCode());
		result = prime * result + ((nameCategory == null) ? 0 : nameCategory.hashCode());
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
		Category other = (Category) obj;
		if (codeCategory == null) {
			if (other.codeCategory != null)
				return false;
		} else if (!codeCategory.equals(other.codeCategory))
			return false;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (idCategory == null) {
			if (other.idCategory != null)
				return false;
		} else if (!idCategory.equals(other.idCategory))
			return false;
		if (nameCategory == null) {
			if (other.nameCategory != null)
				return false;
		} else if (!nameCategory.equals(other.nameCategory))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", codeCategory=" + codeCategory + ", nameCategory="
				+ nameCategory + ", dateCreation=" + dateCreation + "]";
	}
	
	

}
