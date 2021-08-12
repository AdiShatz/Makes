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

  
//
//	@Bean
//	CommandLineRunner runner(BookTemplateRepository repository){
//
//		return args -> {
//
//			List<Page> pages = new ArrayList<Page>();
//			UUID u1 = UUID.randomUUID();
//			UUID u2 = UUID.randomUUID();
//			UUID[] uArr1 = {u2, null};
//			UUID[] uArr2 = {null, null};
//			Page p1 = new Page(" <PRINCE> הלכה לנשף עם <NAME>", "Sinderela.jpg", false, null, u1, uArr1, null);
//			Page p2 = new Page(" התאהבו וחיו באושר ועושר <PRINCE>ו <NAME>", "Sinderela.jpg", false, null, u2, uArr2, u1);
//			pages.add(p1);
//			pages.add(p2);
//
//			List<Question> questions = new ArrayList<Question>();
//			Question q1 = new Question("input", "?מה שם הילדה", null, "NAME" );
//			List<String> princes = new ArrayList<String>();
//			princes.add("ניר");
//			princes.add("סהר");
//			princes.add("אלמוג");
//			princes.add("רועי");
//			Question q2 = new Question("combo", "?שם הנסיך", princes, "PRINCE");
//			questions.add(q1);
//			questions.add(q2);
//
//
//			BookTemplate bt1 = new BookTemplate("סינדרלה", pages, questions);
//
//			repository.insert(bt1);
//
//		};
//	}
}