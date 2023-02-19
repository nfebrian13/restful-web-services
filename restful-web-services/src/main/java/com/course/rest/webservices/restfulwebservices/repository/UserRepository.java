package com.course.rest.webservices.restfulwebservices.repository;

import com.course.rest.webservices.restfulwebservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}
