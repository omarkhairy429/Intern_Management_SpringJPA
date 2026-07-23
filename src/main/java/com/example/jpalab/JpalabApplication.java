package com.example.jpalab;

import com.example.jpalab.entity.Intern;
import com.example.jpalab.entity.Project;
import com.example.jpalab.enums.ProjectStatus;
import com.example.jpalab.repository.InternRepository;
import com.example.jpalab.repository.ProjectRepository;
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
	}

}
