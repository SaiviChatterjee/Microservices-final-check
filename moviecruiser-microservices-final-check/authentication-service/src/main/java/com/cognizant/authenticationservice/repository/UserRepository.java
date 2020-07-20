package com.cognizant.authenticationservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservice.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByUserName(String userName);
	
}
