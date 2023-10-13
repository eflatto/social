package com.fiu.social.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fiu.social.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	

}
