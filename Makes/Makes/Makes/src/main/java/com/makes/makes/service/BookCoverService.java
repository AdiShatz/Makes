package com.makes.makes.service;
import com.makes.makes.model.BookCover;
import com.makes.makes.repository.BookCoverRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
public class BookCoverService {

    private final BookCoverRepository bookCoverRepository;

    public BookCoverService(BookCoverRepository bookCoverRepository) {
        this.bookCoverRepository = bookCoverRepository;
    }

    public List<BookCover> getAllBookCovers(){
        System.out.println(bookCoverRepository.findAll().toString());

        return bookCoverRepository.findAll();
    }

    public String findBookCoverIdByName(String name)
    {
        BookCover bookCover = bookCoverRepository.findByName(name);
        return bookCover.getId();
    }

    public  BookCover findBookCoverById(String id)
    {
        return bookCoverRepository.findCoverBookById(id);
    }
}
