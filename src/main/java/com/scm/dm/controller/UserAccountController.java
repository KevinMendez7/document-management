package com.scm.dm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;
import com.scm.dm.domain.UserAccount;
import com.scm.dm.service.UserAccountService;
//import com.scm.dm.security.JwtTokenProvider;
//import com.scm.dm.security.UserPrincipal;

@Controller
@RequestMapping("/v1")
public class UserAccountController {
	
//	@Autowired
//    AuthenticationManager authenticationManager;   
//
//    @Autowired
//    PasswordEncoder passwordEncoder;

//    @Autowired
//    JwtTokenProvider tokenProvider;
	
	@Autowired
	private UserAccountService _userAccountService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers= "Accept=application/json")
	public ResponseEntity<?> getUser(@RequestBody UserAccount userAccount, UriComponentsBuilder uriComponentsBuilder){					
//		Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                		userAccount.getUsername(),
//                		userAccount.getPassword()
//                )
//        );
//				
//        SecurityContextHolder.getContext().setAuthentication(authentication);   
//        UserPrincipal userPrincipal = tokenProvider.generateToken(authentication);
        return new ResponseEntity("ok", HttpStatus.OK);

	}

}
