package com.codingSchool.webApp.Services;

import org.springframework.security.core.AuthenticationException;


public interface UserService {

    void login(String username, String password) throws AuthenticationException;

}
