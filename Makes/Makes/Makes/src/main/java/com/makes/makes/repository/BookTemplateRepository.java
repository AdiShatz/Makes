package com.makes.makes.repository;

import com.makes.makes.model.BookTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookTemplateRepository
        extends MongoRepository<BookTemplate, String>{

        BookTemplate findByName(String name);
}
