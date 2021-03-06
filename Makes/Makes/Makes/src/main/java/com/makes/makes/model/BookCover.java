package com.makes.makes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document
@NoArgsConstructor
public class BookCover {

     @Id
    private String id;
    private String templateName;
    private String bookName;
    private String coverPhoto;
    private String owner;
    private String bookId;

    public BookCover(String bookName,String templateName, String coverPhoto,String owner,String bookId) {
        this.templateName = templateName;
        this.bookName = bookName;
        this.coverPhoto = coverPhoto;
        this.owner = owner;
        this.bookId = bookId;
    }

    public BookCover(String templateName, String coverPhoto,String bookId)
    {
        this.templateName = templateName;
        this.bookName = null;
        this.coverPhoto = coverPhoto;
        this.owner = "Admin";
        this.bookId = bookId;

    }

    public void setName(String name) {
        this.templateName = name;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return templateName;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
