package com.makes.makes.service;

import com.makes.makes.model.CustomBook;
import com.makes.makes.repository.BookTemplateRepository;
import com.makes.makes.repository.CustomBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomBookService {
    private final CustomBookRepository customBookRepository;

    public CustomBookService (CustomBookRepository customBookRepository) {
        this.customBookRepository = customBookRepository;
    }

    public void insertCustomBook(CustomBook customBook)
    {
        customBookRepository.insert(customBook);
    }

//    public List<CustomBook> findUsersBook(String userEmail)
//    {
//        return customBookRepository.findByEmail(userEmail);
//    }


}
