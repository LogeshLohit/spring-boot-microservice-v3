package com.logesh.repository;

import org.springframework.data.repository.CrudRepository;

import com.logesh.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
