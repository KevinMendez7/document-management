package com.scm.dm.dao;

import java.util.List;

import com.scm.dm.domain.UserAccount;

public interface UserAccountDao {
	
	List<UserAccount> getAllUserAccount();
	
	UserAccount getUserAccountById(Long userAccountId);
	
	UserAccount getUserAccountByUsername(String username);
	
	void createUserAccount(UserAccount userAccount);
	
	void updateUserAccount(UserAccount userAccount);
	
	void removeUserAccount(UserAccount userAccount);

}
