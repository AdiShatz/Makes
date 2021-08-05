package com.makes.makes.controller;

import com.makes.makes.model.BookCover;
import com.makes.makes.service.BookCoverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booksCovers")
public class BookCoverController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class.getName());

    private final BookCoverService bookCoverService;

    public BookCoverController(BookCoverService bookCoverService) {
        this.bookCoverService = bookCoverService;
    }

    @GetMapping("/")
    public List<BookCover> fetchAllBooks() {
        return bookCoverService.getAllBookCovers();
    }
}