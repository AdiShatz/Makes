package com.makes.makes.repository;


import com.makes.makes.model.CustomBook;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomBookRepository extends MongoRepository<CustomBook, String> {


    List<CustomBook> findByEmail(String userEmail);
}
