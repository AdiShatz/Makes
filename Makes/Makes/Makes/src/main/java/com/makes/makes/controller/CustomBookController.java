package com.makes.makes.controller;

import com.makes.makes.service.BookTemplateService;
import com.makes.makes.service.CustomBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customBooks")
public class CustomBookController {
    private static final Logger log = LoggerFactory.getLogger(CustomBookController.class.getName());

    private final CustomBookService customBookService;

    public CustomBookController(CustomBookService customBookService) {
        this.customBookService = customBookService;
    }
}
