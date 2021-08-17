package com.makes.makes.repository;


import com.makes.makes.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

   Optional <User> findUserByEmail(String email);

}
