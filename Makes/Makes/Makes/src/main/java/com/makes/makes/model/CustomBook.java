package com.makes.makes.model;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


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
    private String bookCoverId;

    public CustomBook(String name, List<Page> pages,String owner,String bookCoverId){
        this.name = name;
        this.pages = pages;
        this.owner = owner;
        this.isSave = false;
        this.bookCoverId = bookCoverId;
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

    public String getBookCoverId() {
        return bookCoverId;
    }

    public void setBookCoverId(String bookCoverId) {
        this.bookCoverId = bookCoverId;
    }

    public boolean isSave() {
        return isSave;
    }

    public void editPageById(String pageId,String text)
    {
        for (Page page:pages)
        {
            if (page.getId().equals(pageId))
            {
                page.setText(text);
                break;
            }

        }
    }

}
