package com.makes.makes.controller;

import com.makes.makes.model.BookFactory;
import com.makes.makes.model.BookTemplate;
import com.makes.makes.model.CustomBook;
import com.makes.makes.service.BookTemplateService;
import com.makes.makes.service.CustomBookService;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.json.*;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
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
    public CustomBook createCustomBook(@RequestBody JSONObject data)
    {

        BookFactory bookFactory = new BookFactory();

        String user = data.getAsString("userName");
        String bookName = data.getAsString("bookName");
        String bookData = data.getAsString("newBookData");
        Map<String,String> questionsAnswersMap = createMapFromString(bookData);
        BookTemplate bookTemplate = bookTemplateService.getBookTemplate(bookName);

        // String bookData = data.get("newBookData");
        // Map<String,String> questionsAnswersMap = createMapFromString(bookData);
        // BookTemplate bookTemplate = bookTemplateService.getBookTemplate(bookName);

        // CustomBook newCustomBook = bookFactory.createNewBook(bookTemplate,user,questionsAnswersMap);

        // customBookService.insertCustomBook(newCustomBook);
        return /*newCustomBook*/data;
    }

    private Map<String,String> createMapFromString(String data)
    {
        Map<String, String> newMap = new HashMap<String, String>();
        data = data.substring(1,data.length()-1);
        data = data.replaceAll("\\s+","");
        String[] pairs = data.split(",");
        for (int i=0;i<pairs.length;i++)
        {
            String pair = pairs[i];
            String[] keyValue = pair.split("=");
            newMap.put(keyValue[0], keyValue[1]);
        }
        return newMap;
    }
}
