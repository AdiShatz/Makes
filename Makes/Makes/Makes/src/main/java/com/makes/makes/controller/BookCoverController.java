package com.makes.makes.controller;

import com.makes.makes.model.BookCover;
import com.makes.makes.service.BookCoverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/booksCovers")
public class BookCoverController {

    private static final Logger log = LoggerFactory.getLogger(BookCoverController.class.getName());

    private final BookCoverService bookCoverService;

    public BookCoverController(BookCoverService bookCoverService) {
        this.bookCoverService = bookCoverService;
    }

    @GetMapping("/")
    public List<BookCover> fetchAllBooksCover() {
        return bookCoverService.getAllBookCovers();
    }
}