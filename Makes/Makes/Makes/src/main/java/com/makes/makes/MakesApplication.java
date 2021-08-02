package com.makes.makes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.makes.makes.model.Book;
import com.makes.makes.repository.BookRepository;

@SpringBootApplication
public class MakesApplication  {

	public static void main(String[] args) {
		SpringApplication.run(MakesApplication.class, args);
	}


}

