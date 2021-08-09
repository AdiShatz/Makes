package com.makes.makes.repository;

import com.makes.makes.model.BookTemplate;
import com.makes.makes.model.CustomBook;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomBookRepository extends MongoRepository<CustomBook, String> {
}
