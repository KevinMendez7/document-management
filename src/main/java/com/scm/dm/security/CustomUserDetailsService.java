package com.scm.dm.security;

import com.scm.dm.exception.ResourceNotFoundException;
import com.scm.dm.domain.UserAccount;
import com.scm.dm.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserAccountService _userAccountService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        UserAccount user = _userAccountService.getUserAccountByUsername(username);        
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        UserAccount user = _userAccountService.getUserAccountById(id);
        return UserPrincipal.create(user);
    }
}