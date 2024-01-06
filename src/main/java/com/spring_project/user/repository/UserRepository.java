package com.spring_project.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring_project.user.model.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
