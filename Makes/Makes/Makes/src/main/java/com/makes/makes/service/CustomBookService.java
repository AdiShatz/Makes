package com.makes.makes.service;

import com.makes.makes.model.CustomBook;
import com.makes.makes.repository.BookTemplateRepository;
import com.makes.makes.repository.CustomBookRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomBookService {
    private final CustomBookRepository customBookRepository;
    private final MongoTemplate mongoTemplate;

    public CustomBookService (CustomBookRepository customBookRepository,MongoTemplate mongoTemplate) {
        this.customBookRepository = customBookRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public void insertCustomBook(CustomBook customBook)
    {
        customBookRepository.insert(customBook);
    }

    public  CustomBook findUserBook(String bookId)
    {
        return customBookRepository.findById(bookId).get();
    }

    public void deleteBookById(String id)
    {
        customBookRepository.deleteById(id);
    }

    public List<CustomBook> findUserBookByName(String userBookName,String user)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("owner").is(user).and("name").is(userBookName));
        return mongoTemplate.find(query,CustomBook.class);
    }

    public void saveBook(CustomBook book)
    {
        customBookRepository.save(book);
    }

}
