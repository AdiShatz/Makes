package com.makes.makes.controller;

import com.makes.makes.model.BookFactory;
import com.makes.makes.model.BookTemplate;
import com.makes.makes.model.CustomBook;
import com.makes.makes.service.BookTemplateService;
import com.makes.makes.service.CustomBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customBooks")
public class CustomBookController {
    private static final Logger log = LoggerFactory.getLogger(CustomBookController.class.getName());

    private final CustomBookService customBookService;
    private final BookTemplateService bookTemplateService;

    public CustomBookController(CustomBookService customBookService,BookTemplateService bookTemplateService) {
        this.customBookService = customBookService;
        this.bookTemplateService = bookTemplateService;
    }

    @PostMapping("/")
    public CustomBook createCustomBook(@RequestBody Map<String,String> data)
    {
        BookFactory bookFactory = new BookFactory();


        String user =data.get("userName");
        String bookName =data.get("bookName");
        String bookData = data.get("newBookData");
        Map<String,String> questionsAnswersMap = createMapFromString(bookData);
        BookTemplate bookTemplate = bookTemplateService.getBookTemplate(bookName);

        CustomBook newCustomBook = bookFactory.createNewBook(bookTemplate,user,questionsAnswersMap);

        customBookService.insertCustomBook(newCustomBook);
        return newCustomBook;


    }

    private Map<String,String> createMapFromString(String data)
    {
        Map<String, String> newMap = new HashMap<String, String>();
        String[] pairs = data.split(" ");
        for (int i=0;i<pairs.length;i++)
        {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            newMap.put(keyValue[0], keyValue[1]);
        }
        return newMap;
    }

}
