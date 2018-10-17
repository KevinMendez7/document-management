package com.scm.dm.dao;

import java.util.List;

import com.scm.dm.domain.UserRole;

public interface UserRoleDao {
	
	List<UserRole> getAllUserRole();
	
	UserRole getByRoleName(String roleName);
	
	void createRoleName(UserRole userRole);

}
