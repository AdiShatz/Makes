package com.makes.makes.controller;

import com.makes.makes.model.BookCover;
import com.makes.makes.model.CustomBook;
import com.makes.makes.model.User;
import com.makes.makes.service.BookCoverService;
import com.makes.makes.service.CustomBookService;
import com.makes.makes.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/booksCovers")
public class BookCoverController {

    private static final Logger log = LoggerFactory.getLogger(BookCoverController.class.getName());

    private final BookCoverService bookCoverService;
    private final CustomBookService customBookService;


    public BookCoverController(BookCoverService bookCoverService,CustomBookService customBookService,UserService userService) {
        this.bookCoverService = bookCoverService;
        this.customBookService = customBookService;
    }

    @GetMapping("/")
    public List<BookCover> fetchAllBooksCover()
    {
        return bookCoverService.getAllUserCoverBook("Admin");
    }

    @GetMapping("/{userEmail}")
    public List<BookCover> userGallery(@PathVariable String userEmail)
    {
        return bookCoverService.getAllUserCoverBook(userEmail);

//        List<CustomBook>  usersBooks = customBookService.findUsersBook(userEmail);
//        List<BookCover>  usersCoverBooks= new ArrayList<BookCover>();
//        for ( CustomBook userBook:usersBooks)
//        {
//            BookCover userCoverBook = bookCoverService.findBookCoverByTemplateName(userBook.getCoverBookName());
//            usersCoverBooks.add(userCoverBook);
//        }
//        return  usersCoverBooks;

    }
}