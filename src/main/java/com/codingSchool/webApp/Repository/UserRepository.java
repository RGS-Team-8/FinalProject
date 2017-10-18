package com.codingSchool.webApp.Repository;

import com.codingSchool.webApp.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

        User findByEmailAndPassword(String email, String password);

        List<User> findByEmail(String email);

        List<User> findAll();

        User save(User user);

}
