package com.codingSchool.webApp.Repository;

import com.codingSchool.webApp.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

        User findByEmailAndPassword(String email, String password);

        List<User> findByEmail(String email);

        List<User> findBySsn(String ssn);

        List<User> findByEmailOrSsn(String email, String ssn);

        List<User> findAll();

        User save(User user);

        User delete(long userid);
}
