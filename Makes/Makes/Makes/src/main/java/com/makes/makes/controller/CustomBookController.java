package com.makes.makes.controller;

import Exceptions.RequirementsException;
import com.makes.makes.model.*;
import com.makes.makes.service.BookCoverService;
import com.makes.makes.service.BookTemplateService;
import com.makes.makes.service.CustomBookService;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.json.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customBooks")
public class CustomBookController {
    private static final Logger log = LoggerFactory.getLogger(CustomBookController.class.getName());

    private final CustomBookService customBookService;
    private final BookTemplateService bookTemplateService;
    private final BookCoverService bookCoverService;

    public CustomBookController(CustomBookService customBookService,BookTemplateService bookTemplateService,BookCoverService bookCoverService) {
        this.customBookService = customBookService;
        this.bookTemplateService = bookTemplateService;
        this.bookCoverService = bookCoverService;
    }

    @PostMapping("/")
    public CustomBook createCustomBook(@RequestBody JSONObject data) throws RequirementsException {

        BookFactory bookFactory = new BookFactory();

        String user = data.getAsString("userName");
        String bookName = data.getAsString("bookName");
        String chosenBookName = data.getAsString("chosenBookName");
        String bookData = data.getAsString("newBookData");

        if (isBookNameExists(chosenBookName,user)==true)
        {

            throw new RequirementsException("Book name already exists");
        }
        else
        {
            BookTemplate bookTemplate = bookTemplateService.getBookTemplate(bookName);

            BookCover bookCover = bookCoverService.findBookCoverById(bookTemplate.getBookCoverId());
            BookCover userBookCover = new BookCover(chosenBookName,bookCover.getTemplateName(),bookCover.getCoverPhoto(),user,null);
            bookCoverService.insertBookCover(userBookCover);

            Map<String,String> questionsAnswersMap = createMapFromString(bookData);

            CustomBook newCustomBook = bookFactory.createNewBook(bookTemplate,user,questionsAnswersMap,chosenBookName,userBookCover.getId());

            customBookService.insertCustomBook(newCustomBook);
            userBookCover.setBookId(newCustomBook.getId());
            bookCoverService.saveBookCover(userBookCover);
            return newCustomBook;

        }
    }

    @PutMapping("/editBook/{bookId}")
    public void editBook(@PathVariable String bookId,@RequestBody JSONObject data )
    {
        String text = data.getAsString("text");
        UUID pageId = (UUID) data.getOrDefault("pageId",UUID.class);
        CustomBook userBook = customBookService.findUserBook(bookId);
        userBook.editPageById(pageId,text);
        customBookService.saveBook(userBook);
    }


//    @PutMapping("/editBook/{bookId}")
//    public void editBook(@PathVariable String bookId/*??*/ ,@RequestBody CustomBook editedBook)
//    {
//        editedBook.setId(bookId);//???
//        customBookService.saveBook(editedBook);
//    }

    @GetMapping("/readUserBook/{bookId}")
    public CustomBook readUserBook(@PathVariable String bookId )
    {
        return  customBookService.findUserBook(bookId);
    }

    @DeleteMapping("/deleteUserBook/{bookId}")
    public void deleteUserBook(@PathVariable String bookId)
    {
        CustomBook deleteBook = customBookService.findUserBook(bookId);
        bookCoverService.deleteBookCoverById(deleteBook.getBookCoverId());
        customBookService.deleteBookById(bookId);
    }

    private boolean isBookNameExists(String userBookName,String user)
    {
        List<CustomBook> userBooks = customBookService.findUserBookByName(userBookName,user);
        if (userBooks.size()==0)
        {
            return false;
        }
        else
        {
            return true;
        }

    }



    private Map<String,String> createMapFromString(String data)
    {
        Map<String, String> newMap = new HashMap<String, String>();
        data = data.substring(1,data.length()-1);
        String[] pairs = data.split(",");
        for (int i=0;i<pairs.length;i++)
        {
            String pair = pairs[i];
            String[] keyValue = pair.split("=");
            if (keyValue.length==1)
            {
                ArrayList<String> newKeyValue = new ArrayList<String>();
                newKeyValue.add(keyValue[0]);
                newKeyValue.add(null);
                newMap.put(newKeyValue.get(0), newKeyValue.get(1));
            }
            else
            {
                newMap.put(keyValue[0], keyValue[1]);
            }
        }
        return newMap;
    }




}
