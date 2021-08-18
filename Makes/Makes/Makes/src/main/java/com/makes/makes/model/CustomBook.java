package com.makes.makes.model;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Data
@Document
@NoArgsConstructor
public class CustomBook {
    @Id
    private String id;
    private String name;
    private List<Page>  pages;
    private String owner;
    private boolean isSave;

    public CustomBook(String name, List<Page> pages,String owner){
        this.name = name;
        this.pages = pages;
        this.owner = owner;
        this.isSave = false;
    }

    public String getId() { return this.id;}

    public String getName() { return this.name;}

    public List<Page> getPages() { return this.pages;}

    public void setSave(boolean save) {
        this.isSave = save;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

//    public String getCoverBookId() {
//        return coverBookName;
//    }
//
//    public String getCoverBookName() {
//        return coverBookName;
//    }
//
//    public void setCoverBookName(String coverBookName) {
//        this.coverBookName = coverBookName;
//    }

    public boolean isSave() {
        return isSave;
    }
}
