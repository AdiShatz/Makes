package com.makes.makes.service;
import com.makes.makes.model.Book;
import com.makes.makes.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}