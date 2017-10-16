package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User loadUserByEmailAndPassword(String email, String password) throws AuthenticationException {
        User user = userRepository.findByEmailAndPassword(email, password);

        return user;
    }

}
