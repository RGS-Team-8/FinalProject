package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.User;
import org.springframework.security.core.AuthenticationException;


public interface UserService {

    void login(String username, String password) throws AuthenticationException;

}
