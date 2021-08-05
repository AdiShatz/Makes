package com.makes.makes.repository;

import com.makes.makes.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository
        extends MongoRepository<Book, String>{

        Book findByName(String name);
}
