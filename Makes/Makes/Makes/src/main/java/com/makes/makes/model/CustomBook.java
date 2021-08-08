package com.makes.makes.model;



import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Data
@Document
public class CustomBook {
    @Id
    private String id;
    private String name;
    private List<Page>  pages;
    private String owner;

    public CustomBook(String name, List<Page> pages,String owner){
        this.name = name;
        this.pages = pages;
        this.owner = owner;
    }

    public String getId() { return id;}

    public String getName() { return name;}

    public List<Page> getPages() { return pages;}


}
