package com.makes.makes.repository;

import com.makes.makes.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepository
        extends MongoRepository<Book, String>  {
}
