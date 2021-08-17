package com.makes.makes;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import com.makes.makes.model.*;
import com.makes.makes.repository.*;
import com.makes.makes.model.BookCover;
import com.makes.makes.model.Question;
import com.makes.makes.repository.BookCoverRepository;
// import com.makes.makes.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MakesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakesApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(BookCoverRepository repository) {
//
//		return args -> {
//
//			BookCover bookCover = new BookCover("הדייג ואשתו", "Sinderela.jpg");
//
//			repository.insert(bookCover);
//
//		};
//	}
}

