package com.makes.makes.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document
@NoArgsConstructor
public class BookTemplate {
    @Id
    private String id;
    private String name;
    private List<Page> pages;
    private List<Question> questions;
    private String owner;

    public BookTemplate(String name, List<Page> pages, List<Question> questions){
        this.name = name;
        this.questions = questions;
        this.pages =pages;
        this.owner = "Admin";

    }

    public String getId() { return id;}

    public String getName() { return name;}

    public List<Page> getPages() { return pages;}

    public List<Question> getQuestions() { return questions;}

    private void setPages(List<Page> pages) {
        for (Page page:pages)
        {
            Page newPage = new Page(page);
        }
    }

    public void setQuestions(List<Question> questions) {
        for (Question question: questions)
        {
           Question newQuestion = new Question(question);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
