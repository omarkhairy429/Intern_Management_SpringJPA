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
    private SubmissionRepository submissionRepository;


    public DatabaseQueries(InternRepository internRepository,
                           ProjectRepository projectRepository,
                           TrackRepository trackRepository,
                           MentorRepository mentorRepository,
                           InternProjectsRepository internProjectsRepository,
                           SubmissionRepository submissionRepository) {
        this.internRepository = internRepository;
        this.projectRepository = projectRepository;
        this.trackRepository = trackRepository;
        this.mentorRepository = mentorRepository;
        this.internProjectsRepository = internProjectsRepository;
        this.submissionRepository = submissionRepository;
    }


    @Override
    public void run (String... args) throws Exception {
        Task10QueryAssignmentTable();
        System.out.println("################");
        Task12SubmissionQueries();
        System.out.println("################");
        Task13ValidateSampleData();
        System.out.println("################");
        Task14SqlReportingQueries();
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

    private void Task12SubmissionQueries() {
        System.out.println("Showing submissions by an intern");
        submissionRepository.findByInternInternName("Omar Nabil").
                forEach(submission ->System.out.println("Submission Score: "+ submission.getScore()));

        System.out.println("Showing submissions by project");
        submissionRepository.findByProjectProjectName("Task Tracker API").
                forEach(submission ->System.out.println("Submission Score: "+ submission.getScore()));

        System.out.println("Showing submissions by score");
        submissionRepository.findByScoreGreaterThan(80).
                forEach(submission ->System.out.println("Submission Score: "+ submission.getScore()));

        System.out.println("Showing all submissions ordered by latest");
        submissionRepository.findAllByOrderBySubmittedAtDesc().
                forEach(submission ->System.out.println("Submission Id: "+ submission.getSubmissionId()));


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

    private void Task14SqlReportingQueries() {
        System.out.println("Getting intern by track and mentor names");
        internRepository.findByTrackTrackNameAndMentorMentorName("Backend", "Ali Hassan")
                .forEach(intern -> System.out.println(intern.getInternName()));

        System.out.println("Getting intern in Backend");
        internRepository.findByTrackTrackName("Backend")
                .forEach(intern -> System.out.println(intern.getInternName()));

        System.out.println("Project Assigned to Omar Nabil");
        projectRepository.findByInternProjects_Intern_InternName("Omar Nabil")
                .forEach(project -> System.out.println(project.getProjectName()));

        System.out.println("Counting interns by track name");
        System.out.println("Number of backend interns: " + internRepository.countByTrackTrackName("Backend"));

        System.out.println("Counting interns per mentor");
        System.out.println("Number of interns under Ali Hassan supervision: "
                + internRepository.countByMentorMentorName("Ali Hassan"));


        System.out.println("Displaying interns and their projects");
        internRepository.findAll().forEach(intern -> {
            System.out.println("Intern Name: " + intern.getInternName());
            projectRepository.findByInternProjects_Intern_InternName(intern.getInternName())
                    .forEach(project -> {
                        System.out.println(project.getProjectName());
                    });
        });



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
