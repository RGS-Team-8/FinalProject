package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class UserServiceImpl implements UserService {
   // private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) throws AuthenticationException {

        User user = userRepository.findByEmailAndPassword(email, password);
        return user;

    }

}
