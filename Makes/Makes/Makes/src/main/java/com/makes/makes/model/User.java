package com.makes.makes.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String userName;
    private String email;
    private String password;
    private String error;

    public User(String userName,String email,String password)
    {
        this.id= "1";
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.error = null;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getError() {
        return error;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setError(String error) {
        this.error = error;
    }

}
