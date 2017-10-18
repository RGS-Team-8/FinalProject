package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.User;
import org.springframework.security.core.AuthenticationException;

import java.util.List;


public interface UserService {

    User loadUserByEmailAndPassword(String email, String password) throws AuthenticationException;

    List<User> findByEmail(String email);

    List<User> findBySsn(String ssn);

    List<User> findAll();

}
