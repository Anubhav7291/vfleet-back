package com.BBBCreation.Repository;

import org.springframework.data.repository.CrudRepository;

import com.BBBCreation.Entity.User;

public interface UserRepository extends CrudRepository<User,String> {

}
