package com.makes.makes.repository;

import com.makes.makes.model.BookCover;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookCoverRepository
        extends MongoRepository<BookCover, String> {
    BookCover findByTemplateName(String templateName);
    BookCover findCoverBookById(String id);
    List<BookCover> findCoverBooksByOwner(String owner);

}
