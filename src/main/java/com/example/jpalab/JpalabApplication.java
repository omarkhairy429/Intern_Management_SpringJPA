package com.example.jpalab;

import com.example.jpalab.entity.Intern;
import com.example.jpalab.repository.InternRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class JpalabApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpalabApplication.class, args);

		System.out.println();
	}

	@Bean
	public CommandLineRunner testingOurRepos(InternRepository internRepository) {
		return args -> {
			List<Intern> interns = internRepository.findByInternBirthDateBefore(LocalDate.of(2003, 01, 01));
			for (Intern intern: interns) {
				System.out.println(intern.getInternEmail());
				System.out.println(intern.getInternBirthDate());
			}
			Intern intern1 = internRepository.findByInternEmail("omar@example.com");
			System.out.println(intern1.getInternName());
		};
	}

}
