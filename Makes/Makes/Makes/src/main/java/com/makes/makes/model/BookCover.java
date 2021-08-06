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

    // @Id
    // private String id;
    private String name;
    private String coverPhoto;

    public BookCover(String name, String coverPhoto) {
        this.name = name;
        this.coverPhoto = coverPhoto;
    }
}
