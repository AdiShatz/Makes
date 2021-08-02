package com.makes.makes.repository;

import com.makes.makes.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mogodb.repository;


public interface BookRepository extends MongoRepository<Book, String> {

}
