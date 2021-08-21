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

    public  CustomBook findUserBookByBookName(String owner,String bookName)
    {
        List<CustomBook> customBookList = customBookRepository.findByOwner(owner);

        for (CustomBook customBook: customBookList)
        {
            if (customBook.getName().equals(bookName))
            {
               return customBook;
            }
        }
       return null;

    }


}
