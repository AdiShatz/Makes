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

    public BookCover findBookCoverByTemplateName(String name)
    {
        return bookCoverRepository.findByTemplateName(name);
    }

    public  BookCover findBookCoverById(String id)
    {
        return bookCoverRepository.findCoverBookById(id);
    }

    public void insertBookCover (BookCover bookCover)
    {
        bookCoverRepository.insert(bookCover);
    }

    public void saveBookCover(BookCover bookCover)
    {
        bookCoverRepository.save(bookCover);
    }

    public List<BookCover> getAllUserCoverBook(String user)
    {
        return bookCoverRepository.findCoverBooksByOwner(user);
    }
}
