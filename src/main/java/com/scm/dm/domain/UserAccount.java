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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_account")
public class UserAccount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2323060689540995742L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "username")
	private String username;
	
	@NotBlank
	@Email
	@Column(name = "email")
	private String email;
	
	@Column(name = "password_")
	private String password;
	
	@ManyToOne(optional=true, fetch=FetchType.LAZY)
	@JoinColumn(name = "user_role_id")
	private UserRole userRole;
	
	@OneToMany(mappedBy = "userAccount")
	@JsonIgnore
	private Set<Category> category;
	
	@OneToMany(mappedBy = "userAccount")
	@JsonIgnore
	private Set<SubCategory> subCategory;
	
	@OneToMany(mappedBy = "userAccount")
	@JsonIgnore
	private Set<Document> document;
	
	@OneToMany(mappedBy = "userAccount")
	@JsonIgnore
	private Set<DocumentComment> DocumentComment;
	
	@OneToMany(mappedBy = "userAccount")
	@JsonIgnore
	private Set<DocumentFile> DocumentFile;
	
	@OneToMany(mappedBy = "userAccount")
	@JsonIgnore
	private Set<DocumentLog> DocumentLog;
	
	public UserAccount() {		
		
	}

	public UserAccount(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}

	public Set<SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Set<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}

	public Set<Document> getDocument() {
		return document;
	}

	public void setDocument(Set<Document> document) {
		this.document = document;
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
		result = prime * result + ((DocumentComment == null) ? 0 : DocumentComment.hashCode());
		result = prime * result + ((DocumentFile == null) ? 0 : DocumentFile.hashCode());
		result = prime * result + ((DocumentLog == null) ? 0 : DocumentLog.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((subCategory == null) ? 0 : subCategory.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserAccount other = (UserAccount) obj;
		if (DocumentComment == null) {
			if (other.DocumentComment != null)
				return false;
		} else if (!DocumentComment.equals(other.DocumentComment))
			return false;
		if (DocumentFile == null) {
			if (other.DocumentFile != null)
				return false;
		} else if (!DocumentFile.equals(other.DocumentFile))
			return false;
		if (DocumentLog == null) {
			if (other.DocumentLog != null)
				return false;
		} else if (!DocumentLog.equals(other.DocumentLog))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (subCategory == null) {
			if (other.subCategory != null)
				return false;
		} else if (!subCategory.equals(other.subCategory))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserAccount [userId=" + userId + ", username=" + username + ", email=" + email + ", password="
				+ password + ", userRole=" + userRole + ", category=" + category + ", subCategory=" + subCategory
				+ ", document=" + document + ", DocumentComment=" + DocumentComment + ", DocumentFile=" + DocumentFile
				+ ", DocumentLog=" + DocumentLog + "]";
	}
		
	
	

}
