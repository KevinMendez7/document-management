package com.scm.dm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dm.dao.UserRoleDao;
import com.scm.dm.domain.UserRole;

@Service("UserRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private UserRoleDao _userRoleDao;

	@Override
	public List<UserRole> getAllUserRole() {
		// TODO Auto-generated method stub
		return _userRoleDao.getAllUserRole();
	}

	@Override
	public UserRole getByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return _userRoleDao.getByRoleName(roleName);
	}

	@Override
	public void createRoleName(UserRole userRole) {
		// TODO Auto-generated method stub
		_userRoleDao.createRoleName(userRole);
	}
	
	

}
