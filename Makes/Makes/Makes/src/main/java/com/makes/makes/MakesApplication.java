package com.makes.makes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.makes.makes.model.Book;
import com.makes.makes.repository.BookRepository;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MakesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BookRepository repository){
		return args -> {
			Book book = new Book("כיפה אדומה","כיפה הלכה לבקר את סבתא פעם שנייה",3);
			repository.insert(book);
		};
	}
}

