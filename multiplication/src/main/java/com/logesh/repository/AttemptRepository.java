package com.logesh.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.logesh.model.Attempt;

public interface AttemptRepository extends CrudRepository<Attempt, Integer> {

	List<Attempt> findByUsersUserName(String userName);

}
