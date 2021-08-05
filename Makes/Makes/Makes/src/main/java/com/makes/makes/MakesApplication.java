package com.makes.makes;

import com.makes.makes.model.BookCover;
import com.makes.makes.model.Question;
import com.makes.makes.repository.BookCoverRepository;
import com.makes.makes.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MakesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakesApplication.class, args);
	}

//	 @Bean
//	 CommandLineRunner runner(BookCoverRepository repository){
//
//	 	return args -> {
//			BookCover bookCover1 = new BookCover("זה כריכה חדשה של ספר אומג", "Photo");
//			BookCover bookCover2 = new BookCover("זה כריכה שניה חדשה של ספר אומג", "Photo");
//			BookCover bookCover3 = new BookCover("זה כריכה שלישית חדשה של ספר אומג", "Photo");
//			BookCover bookCover4 = new BookCover("זה כריכה רביעית חדשה של ספר אומג", "Photo");
//
//	 		repository.insert(bookCover1);
//	 		repository.insert(bookCover2);
//	 		repository.insert(bookCover3);
//	 		repository.insert(bookCover4);
//	 	};
//	 }
}

