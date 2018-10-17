package com.scm.dm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.dm.domain.UserRole;

@Repository
@Transactional
public class UserRoleDaoImpl extends AbstractSession implements UserRoleDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getAllUserRole() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from UserRole").list();
	}

	@Override
	public UserRole getByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return (UserRole) getSession().createQuery("from UserRole where roleName = :roleName")
				.setParameter("roleName", roleName)
				.uniqueResult();
	}

	@Override
	public void createRoleName(UserRole userRole) {
		// TODO Auto-generated method stub
		getSession().persist(userRole);
	}

}
