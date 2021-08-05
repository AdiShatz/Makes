package com.makes.makes.controller;

import com.makes.makes.model.Book;
import com.makes.makes.model.Question;
import com.makes.makes.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class.getName());

    private final BookService bookService;

    public QuestionnaireController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Question> fetchQuestionnaire(@RequestParam(value = "name") String name) {
        return bookService.getQuestionnaire(name);
    }

}
