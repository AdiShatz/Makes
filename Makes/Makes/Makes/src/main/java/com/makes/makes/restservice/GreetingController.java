package com.makes.makes.restservice;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.makes.makes.MakesApplication;
import com.makes.makes.model.BookFactory;
import com.makes.makes.model.BookTemplate;
import com.makes.makes.model.Page;
import com.makes.makes.service.BookTemplateService;
import com.makes.makes.service.CustomBookService;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.*;

@ResponseBody
@RestController
@RequestMapping("/greeting")
@CrossOrigin(origins = "http://localhost:3000")
public class GreetingController {

    private static final Logger log = LoggerFactory.getLogger(GreetingController.class.getName());
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final BookTemplateService bookTemplateService;

    public GreetingController( BookTemplateService bookTemplateService) {
        this.bookTemplateService = bookTemplateService;
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        log.info("request greeting");
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }

//   @CrossOrigin(origins = "http://localhost:8080")
//   @PostMapping(value =  "/display",
//           consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//           produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//   public ResponseEntity<Greeting> displayGreeting(@RequestBody Greeting greeting)
//    {
//        greeting.setContent("kakiiiiiii!!!!!");
//        return ResponseEntity
//                .created(URI
//                        .create(String.format("/greeting/%s",greeting.getContent())))
//                .body(greeting);
//    }
//    @RequestMapping(value = "/display",method = RequestMethod.POST ,
//            consumes = {MediaType.APPLICATION_JSON_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PostMapping("/display")
    public String postBody(@RequestBody JSONObject greeting)
    {

        BookFactory bookFactory = new BookFactory();
        String bookName =greeting.getAsString("bookName");

        BookTemplate bookTemplate = bookTemplateService.getBookTemplate(bookName);

        //Greeting newGreerting = new Greeting(1, greeting);

        return greeting.getAsString("newBookData");
    }
}