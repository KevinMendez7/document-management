package com.scm.dm.service;

import java.util.List;

import com.scm.dm.domain.UserRole;

public interface UserRoleService {
	
	List<UserRole> getAllUserRole();
	
	UserRole getByRoleName(String roleName);
	
	void createRoleName(UserRole userRole);

}
