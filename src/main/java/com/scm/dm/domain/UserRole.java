package com.scm.dm.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2246864464850552130L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id")
	private int userRoleId;
	
	@NotBlank
	@Column(name = "role_name")
	private String roleName;
	
	@OneToMany(mappedBy = "userRole")
	@JsonIgnore
	private Set<UserAccount> userAccount;
	
	public UserRole() {

	}

	public UserRole(String roleName) {
		super();
		this.roleName = roleName;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<UserAccount> getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(Set<UserAccount> userAccount) {
		this.userAccount = userAccount;
	}
	
	

}
