package com.makes.makes.service;
import com.makes.makes.model.BookCover;
import com.makes.makes.repository.BookCoverRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookCoverService {

    private final BookCoverRepository bookCoverRepository;

    public BookCoverService(BookCoverRepository bookCoverRepository) {
        this.bookCoverRepository = bookCoverRepository;
    }

    public List<BookCover> getAllBookCovers(){
        return bookCoverRepository.findAll();
    }
}
