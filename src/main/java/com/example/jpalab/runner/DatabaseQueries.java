package com.example.jpalab.runner;

import com.example.jpalab.entity.*;
import com.example.jpalab.enums.ProjectStatus;
import com.example.jpalab.repository.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseQueries implements CommandLineRunner {
    private InternRepository internRepository;
    private ProjectRepository projectRepository;
    private TrackRepository trackRepository;
    private MentorRepository mentorRepository;
    private InternProjectsRepository internProjectsRepository;

    @Autowired
    public void setInternRepository(InternRepository internRepository) {
        this.internRepository = internRepository;
    }

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Autowired
    public void setMentorRepository(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Autowired
    public void setInternProjectsRepository(InternProjectsRepository internProjectsRepository) {
        this.internProjectsRepository = internProjectsRepository;
    }

    @Override
    public void run (String... args) throws Exception {
        Task10QueryAssignmentTable();
        System.out.println("################");
        Task13ValidateSampleData();
    }

    private void Task10QueryAssignmentTable() {
        System.out.println("Finding all projects assigned to an intern");
        projectRepository.findByInternProjects_Intern_InternName("Omar Nabil").
                forEach(project -> System.out.println(project.getProjectName()));


        System.out.println("Finding all interns assigned to a project");
        internRepository.findByInternProjects_Project_ProjectName("Task Tracker API").
                forEach(intern -> System.out.println(intern.getInternName()));

        System.out.println("Finding assignments created after a given date");
        internProjectsRepository.
                findByAssignedAtAfter(LocalDateTime.of(2025, Month.APRIL, 8, 12, 30))
                .forEach(internProject -> System.out.println(internProject.getAssignedAt()));
    }

    private void Task13ValidateSampleData() {
        System.out.println("Showing tracks");
        trackRepository.findAll().
                forEach(track -> System.out.println("Track Name: " + track.getTrackName()));

        System.out.println("Showing mentors");
        mentorRepository.findAll().
                forEach(mentor -> System.out.println("Mentor Name: " + mentor.getMentorName()));

        System.out.println("Showing interns");
        internRepository.findAll().
                forEach(intern -> System.out.println("Intern Name: " + intern.getInternName()));

        System.out.println("Showing projects");
        projectRepository.findAll().
                forEach(project -> System.out.println("Project Name: " + project.getProjectName()));


    }

    private void FindByBirthDateBeforeQueries() {
        internRepository.findByInternBirthDateBefore(LocalDate.of(2003, 01, 01))
                .forEach(intern -> {
                    System.out.println(intern.getInternEmail());
                    System.out.println(intern.getInternBirthDate());
                });
    }

    private void FindByTrackOrderByNameQueries() {
        internRepository.findByTrackOrderByName("Backend").forEach(intern -> {
            System.out.println(intern.getInternEmail());
            System.out.println(intern.getInternBirthDate());
        });
    }

    private void ProjectsQueries() {
        projectRepository.findByProjectName("Task Tracker API").forEach(project -> {
            System.out.println(project.getProjectName());
            System.out.println(project.getProjectId());
        });

        int numberOfPlannedProjects = projectRepository.countByProjectStatus(ProjectStatus.planned);
        System.out.println("Number of planned projects: "+ numberOfPlannedProjects);
    }

}
