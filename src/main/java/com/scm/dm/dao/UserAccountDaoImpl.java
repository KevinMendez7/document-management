package com.scm.dm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.dm.domain.UserAccount;

@Repository
@Transactional
public class UserAccountDaoImpl extends AbstractSession implements UserAccountDao {

	@SuppressWarnings("unchecked")	
	@Override
	public List<UserAccount> getAllUserAccount() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from UserAccount").list();
	}
	
	@Override
	public UserAccount getUserAccountById(Long userAccountId) {
		// TODO Auto-generated method stub
		return getSession().get(UserAccount.class, userAccountId);
	}

	@Override
	public UserAccount getUserAccountByUsername(String username) {
		// TODO Auto-generated method stub
		return (UserAccount) getSession().createQuery("from UserAccount where username = :username")
				.setParameter("username", username)
				.uniqueResult();
	}

	@Override
	public void createUserAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		getSession().persist(userAccount);
	}

	@Override
	public void updateUserAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		getSession().update(userAccount);
	}

	@Override
	public void removeUserAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		getSession().delete(userAccount);
	}

}
