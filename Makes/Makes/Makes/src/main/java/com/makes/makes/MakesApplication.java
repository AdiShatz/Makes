package com.makes.makes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.makes.makes.model.Book;
import com.makes.makes.repository.BookRepository;

@SpringBootApplication
public class MakesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MakesApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception{
		this.bookRepository.save(new Book("Kipa Aduma", "once in a far away place...", 39));
		this.bookRepository.save(new Book("Piterpan", "i'll never grow up...", 100));
	}
}

