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

    public BookCover(String bookName,String templateName, String coverPhoto) {
        this.templateName = templateName;
        this.bookName = bookName;
        this.coverPhoto = coverPhoto;
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
}
