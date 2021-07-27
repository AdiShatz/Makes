package com.makes.makes.model;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="book_name")
    private String name;
    @Column(name="book_text")
    private String text;
    @Column(name="book_numOfPages")
    private int numOfPages;

    public Book(){

    }

    public Book(String name, String text ,int numOfPages){
        this.name = name;
        this.text = text;
        this.numOfPages = numOfPages;
    }

    public int getNumOfPages() {
        return numOfPages;
    }
    public String getName() {
        return name;
    }
    public String getText() {
        return text;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }
    public void setText(String text) {
        this.text = text;
    }
}
