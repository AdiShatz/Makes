package com.makes.makes.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.makes.makes.model.Book;
import com.makes.makes.repository.BookRepository;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class.getName());

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("books")
    public List<Book> getBooks() {
        log.info("request book");
        return this.bookRepository.findAll();

    }
}