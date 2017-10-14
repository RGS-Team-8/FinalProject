package com.codingSchool.webApp.Repository;

import com.codingSchool.webApp.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

//    @Query("FROM user WHERE email = :email AND password = :password")
//    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
        User findByEmailAndPassword(String email, String password);
}
