package com.makes.makes.controller;

import com.makes.makes.model.BookCover;
import com.makes.makes.service.BookCoverService;
import com.makes.makes.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/booksCovers")
public class BookCoverController {

    private static final Logger log = LoggerFactory.getLogger(BookCoverController.class.getName());

    private final BookCoverService bookCoverService;
    private final CustomBookController customBookController;
    private final UserService userService;//TODO CHECK IF NEED!

    public BookCoverController(BookCoverService bookCoverService,CustomBookController customBookController,UserService userService) {
        this.bookCoverService = bookCoverService;
        this.customBookController = customBookController;
        this.userService = userService;
    }

    @GetMapping("/")
    public List<BookCover> fetchAllBooksCover() {
        return bookCoverService.getAllBookCovers();
    }

    @GetMapping("/{id}")
    public BookCover userGallery(@PathVariable String id)
    {
        //TODO maybe we can save the user id in customBook.owner


    }
}