package com.makes.makes.controller;

import com.makes.makes.model.BookTemplate;
import com.makes.makes.service.BookTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/templateBooks")
public class BookTemplateController {

    private static final Logger log = LoggerFactory.getLogger(BookTemplateController.class.getName());

    private final BookTemplateService bookTemplateService;

    public BookTemplateController(BookTemplateService bookTemplateService) {
        this.bookTemplateService = bookTemplateService;
    }

    @GetMapping("/")
    public List<BookTemplate> fetchAllBooks() {
        return bookTemplateService.getAllBooksTemplate();
    }
}