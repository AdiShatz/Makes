package com.makes.makes.service;
import com.makes.makes.model.BookTemplate;
import com.makes.makes.model.Question;
import com.makes.makes.repository.BookTemplateRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTemplateService {

    private final BookTemplateRepository bookTemplateRepository;

    public BookTemplateService(BookTemplateRepository bookTemplateRepository) {
        this.bookTemplateRepository = bookTemplateRepository;
    }

    public List<BookTemplate> getAllBooksTemplate(){
        return bookTemplateRepository.findAll();
    }

    public List<Question> getQuestionnaire(String name){
        BookTemplate bookTemplate = bookTemplateRepository.findByName(name);
        return bookTemplate.getQuestions();
    }
}