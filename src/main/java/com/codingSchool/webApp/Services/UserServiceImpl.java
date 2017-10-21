package com.codingSchool.webApp.Services;

import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public List<User> findByEmail(String email) { return userRepository.findByEmail(email); }

    @Override
    public List<User> findBySsn(String ssn) { return userRepository.findBySsn(ssn); }

    @Override
    public List<User> findAll() { return userRepository.findAll(); }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void insert(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) { userRepository.save(user); }

}
