package com.scm.dm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dm.dao.UserAccountDao;
import com.scm.dm.domain.UserAccount;

@Service("UserAccountService")
@Transactional
public class UserAccountServiceImpl implements UserAccountService {
	
	@Autowired
	private UserAccountDao _userAccountDao;

	@Override
	public List<UserAccount> getAllUserAccount() {
		// TODO Auto-generated method stub		
		return _userAccountDao.getAllUserAccount();
	}

	@Override
	public UserAccount getUserAccountById(Long userAccountId) {
		// TODO Auto-generated method stub
		return _userAccountDao.getUserAccountById(userAccountId);
	}

	@Override
	public UserAccount getUserAccountByUsername(String username) {
		// TODO Auto-generated method stub		
		return _userAccountDao.getUserAccountByUsername(username);
	}

	@Override
	public void createUserAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		_userAccountDao.createUserAccount(userAccount);
	}

	@Override
	public void updateUserAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		_userAccountDao.updateUserAccount(userAccount);
	}

	@Override
	public void removeUserAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		_userAccountDao.removeUserAccount(userAccount);
	}

}
