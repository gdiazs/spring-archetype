package com.example.exampleapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.exampleapp.domain.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  public User findUserByUsername(String userName);
}
