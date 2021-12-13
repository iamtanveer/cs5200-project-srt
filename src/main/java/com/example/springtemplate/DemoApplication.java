package com.example.springtemplate;

import com.example.springtemplate.models.Category;
import com.example.springtemplate.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@Component
class CategoryCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;


	@Override
	public void run(String... args) throws Exception {
		Category sports = new Category("SPORTS");
		Category education = new Category("EDUCATION");
		Category politics = new Category("POLITICS");
		Category entertainment = new Category("ENTERTAINMENT");
		categoryRepository.save(sports);
		categoryRepository.save(education);
		categoryRepository.save(politics);
		categoryRepository.save(entertainment);
	}
}
