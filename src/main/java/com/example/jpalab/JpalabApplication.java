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

	@Bean
	public CommandLineRunner testingOurRepos(InternRepository internRepository,
											 ProjectRepository projectRepository) {
		return args -> {
			List<Intern> interns1 = internRepository.findByInternBirthDateBefore(LocalDate.of(2003, 01, 01));
			for (Intern intern: interns1) {
				System.out.println(intern.getInternEmail());
				System.out.println(intern.getInternBirthDate());
			}

			List<Intern> interns2 = internRepository.findByTrackOrderByName("Backend");
			for (Intern intern: interns2) {
				System.out.println(intern.getInternEmail());
				System.out.println(intern.getInternBirthDate());
			}



			Intern intern1 = internRepository.findByInternEmail("omar@example.com");
			System.out.println(intern1.getInternName());

			List<Project> projects = projectRepository.findByProjectName("Task Tracker API");
			for (Project project: projects) {
				System.out.println(project.getProjectName());
				System.out.println(project.getProjectId());
			}
			int numberOfPlannedProjects = projectRepository.countByProjectStatus(ProjectStatus.planned);
			System.out.println("Number of planned projects: "+ numberOfPlannedProjects);

		};
	}

}
