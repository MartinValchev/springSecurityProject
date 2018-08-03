package com.spring.security.test.SpringSecurityProject.repository;

import com.spring.security.test.SpringSecurityProject.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findOneByUsername(String username);
}
