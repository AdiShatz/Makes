package com.makes.makes.controller;

import com.makes.makes.model.Question;
import com.makes.makes.service.BookTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    private static final Logger log = LoggerFactory.getLogger(BookTemplateController.class.getName());

    private final BookTemplateService bookTemplateService;

    public QuestionnaireController(BookTemplateService bookTemplateService) {
        this.bookTemplateService = bookTemplateService;
    }

    @GetMapping("/")
    public List<Question> fetchQuestionnaire(@RequestParam(value = "name") String name) {
        return bookTemplateService.getQuestionnaire(name);
    }

}
