package com.codingSchool.webApp.Services;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserService {

    UserDetails loadUserByEmail(String email) throws AuthenticationException, javax.naming.AuthenticationException;

}
