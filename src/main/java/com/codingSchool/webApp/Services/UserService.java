package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.User;
import org.springframework.security.core.AuthenticationException;


public interface UserService {

    User login(String email, String password) throws AuthenticationException, javax.naming.AuthenticationException;

}
