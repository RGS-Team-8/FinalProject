package com.codingSchool.webApp.Services;

//import com.codingSchool.webApp.Domain.User;
//import com.codingSchool.webApp.Repository.UserRepository;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public abstract class UserServiceImpl implements UserService {
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

//    @Autowired
//    private UserRepository userRepository;

    @Override
    public void login(String username, String password) /*throws Exception*/ {
//        if (userRepository.containsKey(getCredentials(username, password))) {
//            User user = userRepository.get(getCredentials(username, password));
//            loggedInUsers.put(username, user);
//            return null;
//        }
//        throw new Exception("User Not Found");
    }


}
