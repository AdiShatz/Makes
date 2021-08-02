package com.makes.makes.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Document
public class Book {
    @Id
    private String id;
    private String name;
    private String text;
    private int numOfPages;


    public Book(String name, String text ,int numOfPages){
        this.name = name;
        this.text = text;
        this.numOfPages = numOfPages;
    }

}
