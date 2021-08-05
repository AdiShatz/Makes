package com.makes.makes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.makes.makes.model.Book;
import com.makes.makes.model.Question;
import com.makes.makes.repository.BookRepository;
import com.makes.makes.systemObjects.Page;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping()
public class BookController {

    

    private static final Logger log = LoggerFactory.getLogger(BookController.class.getName());

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getBooks() {
        log.info("request book");

        // return this.bookRepository.findAll();

        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();
        UUID ids[] = {id1, id2};

        List<Page> p_list = new ArrayList<Page>();
; 
        List<Question> q_list = new ArrayList<Question>(); 

        p_list.add(new Page("טובים בהכל הלכו ביער ולא הצליחו כלום", "photo1.png", false, null, ids, id3));

        q_list.add(new Question("input", "?מה שם הילד", null, null));

        List<Book> b_list = new ArrayList<Book>();
        b_list.add(new Book("כיפה אדומה", p_list, q_list));


        return b_list;
    }
}