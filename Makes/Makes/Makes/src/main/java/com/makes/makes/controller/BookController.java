package com.makes.makes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import com.makes.makes.model.Book;
import com.makes.makes.model.Question;
import com.makes.makes.repository.BookRepository;
import com.makes.makes.service.BookService;
import com.makes.makes.systemObjects.Page;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;


@RestController
@RequestMapping("/books")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class.getName());

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> fetchAllBooks() {
        return bookService.getAllBooks();
    }
}