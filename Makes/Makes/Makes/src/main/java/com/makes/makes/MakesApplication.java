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

	//  @Bean
	//  CommandLineRunner runner(BookCoverRepository repository){

	//  	return args -> {
	// 		Question q1 = new Question("input", "?מה שם הילד", null, null)
	// 		Question q2 = new Question("combo", "", null, null)
	// 		Question q3 = new Question("input", "?מה שם הילד", null, null)
	// 		Question q4 = new Question("input", "?מה שם הילד", null, null)

	//  		repository.insert(q1);
	//  		repository.insert(q2);
	//  		repository.insert(q3);
	//  		repository.insert(q4);
	//  	};
	// }
 }

