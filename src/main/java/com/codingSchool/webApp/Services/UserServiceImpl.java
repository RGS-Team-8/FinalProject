package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void login(String username, String password) throws AuthenticationException {

//        try {
//            userRepository.login(username, password);
//        } catch (Exception e) {
//            throw new InvalidCredentialsException("User not found!");
//        }
    }


}
