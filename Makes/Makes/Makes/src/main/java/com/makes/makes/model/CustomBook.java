package com.makes.makes.model;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Data
@Document
// @NoArgsConstructor
public class CustomBook {
    @Id
    private String id;
    private String name;
    // private List<Page>  pages;
    private String owner;
    // private boolean isSave;

    public CustomBook(String name/*, List<Page> pages*/,String owner){
        this.name = name;
        // this.pages = pages;
        this.owner = owner;
        // this.isSave = false;
    }

    public String getId() { return this.id;}

    public String getName() { return this.name;}

    // public List<Page> getPages() { return this.pages;}

    public void setSave(boolean save) {
        // this.isSave = save;
    }
}
