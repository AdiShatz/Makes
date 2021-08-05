package com.makes.makes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.makes.makes.model.Book;
import com.makes.makes.repository.BookRepository;
import org.springframework.context.annotation.Bean;


import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import com.makes.makes.model.Question;
import com.makes.makes.systemObjects.Page;


@SpringBootApplication
public class MakesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakesApplication.class, args);
	}

	// @Bean
	// CommandLineRunner runner(BookRepository repository){

	// 	return args -> {

	// 		UUID id1 = UUID.randomUUID();
	// 		UUID id2 = UUID.randomUUID();
	// 		UUID id3 = UUID.randomUUID();
	// 		UUID ids[] = {id1, id2};
	// 		List<Page> p_list = new ArrayList<Page>();
	// 		List<Question> q_list = new ArrayList<Question>(); 
			
	// 		p_list.add(new Page("אני לא רוצה יותר דיייייייייייייי", "photo1.png", false, null, ids, id3));
	// 		q_list.add(new Question("input", "?למה זה חרא", null, null));
			
	// 		Book book = new Book("דני שובבני", p_list, q_list);
	
	// 		repository.insert(book);
	// 	};
	// }
}

