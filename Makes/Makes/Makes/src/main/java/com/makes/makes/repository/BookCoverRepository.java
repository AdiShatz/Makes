package com.makes.makes.repository;

import com.makes.makes.model.BookCover;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookCoverRepository
        extends MongoRepository<BookCover, String> {
    BookCover findByName(String name);
    BookCover findCoverBookById(String id);

}
